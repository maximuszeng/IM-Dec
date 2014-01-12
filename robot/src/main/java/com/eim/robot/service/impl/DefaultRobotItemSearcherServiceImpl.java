package com.eim.robot.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eim.robot.model.QAItem;
import com.eim.robot.service.RobotItemSearcherService;

@Service
public class DefaultRobotItemSearcherServiceImpl implements RobotItemSearcherService {
	@Autowired
	private Directory directory;

	@Autowired
	private Analyzer analyzer;

	@Value("#{robotConfig['lucene.query.hitsPerPage']}")
	private Integer DEFAULT_HITS_PER_PAGE;

	public List<QAItem> answer(Long appId, String locale, String question) throws IOException, ParseException {
		return this.answer(appId, locale, question, DEFAULT_HITS_PER_PAGE);
	}

	public List<QAItem> answer(Long appId, String locale, String question, Integer hitsPerPage) throws IOException,
			ParseException {
		IndexReader reader = DirectoryReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);

		QueryParser appIdParser = new QueryParser(Version.LUCENE_45, "appId", analyzer);
		Query appIdQuery = appIdParser.parse(String.valueOf(appId));

		QueryParser localeParser = new QueryParser(Version.LUCENE_45, "locale", analyzer);
		Query localeQuery = localeParser.parse(locale);

		QueryParser contentParser = new QueryParser(Version.LUCENE_45, "content", analyzer);
		Query contentQuery = contentParser.parse(".*" + question + ".*");

		BooleanQuery finalQuery = new BooleanQuery();
		finalQuery.add(appIdQuery, Occur.MUST);
		finalQuery.add(localeQuery, Occur.MUST);
		finalQuery.add(contentQuery, Occur.MUST);

		TopDocs results = searcher.search(finalQuery, 5 * hitsPerPage);

		ScoreDoc[] hits = results.scoreDocs;

		int numTotalHits = results.totalHits;
		System.out.println(numTotalHits + " total matching documents");

		List<QAItem> result = new ArrayList<QAItem>(numTotalHits);
		int start = 0;
		int end = Math.min(numTotalHits, hitsPerPage);

		end = Math.min(hits.length, start + hitsPerPage);
		for (int i = start; i < end; i++) {
			Document doc = searcher.doc(hits[i].doc);
			QAItem item = new QAItem();
			item.setQaId(Long.valueOf(doc.get("qaid")));
			item.setAppId(Long.valueOf(doc.get("appid")));
			item.setCategoryId(Long.valueOf(doc.get("categoryId")));
			item.setLocale(doc.get("locale"));
			item.setContent(doc.get("content"));
			result.add(item);
		}

		reader.close();
		return result;
	}
}
