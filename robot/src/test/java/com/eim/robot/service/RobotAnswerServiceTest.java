package com.eim.robot.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eim.robot.model.QAItem;

public class RobotAnswerServiceTest extends CommonJunitSpringTest {
	@Autowired
	private RobotService service;

	@Test
	public void testAnswer() {
		List<QAItem> answers = service.answer(1L, "cn", "");
		if (answers != null) {
			for (QAItem item : answers) {
				System.out.println(item.getContent());
			}
		}
	}

}
