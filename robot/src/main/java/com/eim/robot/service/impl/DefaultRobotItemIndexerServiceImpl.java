package com.eim.robot.service.impl;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.robot.model.QAItem;
import com.eim.robot.service.RobotItemIndexerService;

@Service
public class DefaultRobotItemIndexerServiceImpl implements RobotItemIndexerService {
	@Autowired
	private Directory directory;

	@Autowired
	private Analyzer analyzer;

	@Autowired
	private IndexWriter indexWriter;

	public void newQAItem(QAItem item) throws IOException {
		Document doc = convertQAItemToDocument(item);
		indexWriter.addDocument(doc);
	}

	public void updateQAItem(QAItem item) throws IOException {
		Document doc = convertQAItemToDocument(item);
		indexWriter.updateDocument(new Term("qaid", String.valueOf(item.getQaId())), doc);
	}

	public void deleteQAItem(QAItem item) throws IOException {
		Document doc = new Document();
		doc.add(new LongField("qaid", item.getQaId(), Field.Store.YES));
		indexWriter.deleteDocuments(new Term("qaid", String.valueOf(item.getQaId())));
	}

	private Document convertQAItemToDocument(QAItem item) {
		Document doc = new Document();
		doc.add(new LongField("qaid", item.getQaId(), Field.Store.YES));
		doc.add(new LongField("appid", item.getAppId(), Field.Store.YES));
		doc.add(new LongField("categoryId", item.getCategoryId(), Field.Store.YES));
		doc.add(new StringField("locale", item.getLocale(), Field.Store.YES));
		doc.add(new TextField("content", item.getContent(), Field.Store.YES));

		return doc;
	}
}
