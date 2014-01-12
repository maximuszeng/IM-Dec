package com.eim.robot.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eim.robot.model.QAItem;

public class RobotQuestionCreateServiceTest extends CommonJunitSpringTest {
	@Autowired
	private RobotService service;

	private static QAItem newItem(Long i) {
		QAItem item = new QAItem();
		item.setAppId(1L);
		item.setCategoryId(1L);
		item.setContent("这个问题是关于尼玛" + i);
		item.setLocale("cn");
		item.setQaId(i);
		return item;
	}

	@Test
	public void testCreate() {

		for (Long i = 0L; i < 1000; i++) {
			service.createQAItem(newItem(i));
		}
	}

}
