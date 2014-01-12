package com.eim.robot.service;

import java.util.List;

import com.eim.robot.model.QAItem;

public interface RobotService {
	List<QAItem> answer(Long appId, String locale, String question);

	List<QAItem> answer(Long appId, String locale, String question, Integer hitsPerPage);

	void createQAItem(QAItem item);

	void updateQAItem(QAItem item);

	void deleteQAItem(QAItem item);
}
