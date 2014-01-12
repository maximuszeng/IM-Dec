package com.eim.robot.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.robot.model.QAItem;
import com.eim.robot.service.RobotItemIndexerService;
import com.eim.robot.service.RobotItemSearcherService;
import com.eim.robot.service.RobotService;

@Service
public class DefaultRobotServiceImpl implements RobotService {
	@Autowired
	private RobotItemIndexerService itemIndexerService;

	@Autowired
	private RobotItemSearcherService itemSearcherService;

	public List<QAItem> answer(Long appId, String locale, String question) {
		List<QAItem> answers = null;
		try {
			answers = itemSearcherService.answer(appId, locale, question);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return answers;
	}

	public void createQAItem(QAItem item) {
		try {
			itemIndexerService.newQAItem(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<QAItem> answer(Long appId, String locale, String question, Integer hitsPerPage) {
		List<QAItem> answers = null;
		try {
			answers = itemSearcherService.answer(appId, locale, question, hitsPerPage);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return answers;
	}

	public void updateQAItem(QAItem item) {
		try {
			itemIndexerService.updateQAItem(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteQAItem(QAItem item) {
		try {
			itemIndexerService.deleteQAItem(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
