package com.eim.robot.service;

import java.io.IOException;

import com.eim.robot.model.QAItem;

public interface RobotItemIndexerService {
	
	void newQAItem(QAItem item) throws IOException;

	void updateQAItem(QAItem item) throws IOException;

	void deleteQAItem(QAItem item) throws IOException;
	
}
