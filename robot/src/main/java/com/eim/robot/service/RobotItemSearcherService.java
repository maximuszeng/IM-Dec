package com.eim.robot.service;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.eim.robot.model.QAItem;

public interface RobotItemSearcherService {

	List<QAItem> answer(Long appId, String locale, String question) throws IOException, ParseException;

	List<QAItem> answer(Long appId, String locale, String question, Integer hitsPerPage) throws IOException,
			ParseException;

}
