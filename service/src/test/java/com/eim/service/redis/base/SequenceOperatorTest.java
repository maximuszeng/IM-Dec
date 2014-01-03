package com.eim.service.redis.base;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.base.AccessUserBO;
import com.eim.service.bo.base.ApplicationBO;
import com.eim.service.bo.base.StaffBO;
import com.eim.service.bo.base.UserBO;
import com.eim.service.redis.base.SequenceOperator;

public class SequenceOperatorTest extends CommonJunitSpringTest {
	@Autowired
	private SequenceOperator operator;

	@Test
	public void testDoIt() {
		operator.loadAll();

		for (int i = 0; i < 10; i++) {
			System.out.println("Next UID = " + operator.getNextId(UserBO.SEQUENCE_NAME));
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Next SUID = " + operator.getNextId(StaffBO.SEQUENCE_NAME));
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Next APPID = " + operator.getNextId(ApplicationBO.SEQUENCE_NAME));
		}

		for (int i = 0; i < 100; i++) {
			String multiLevelName = operator.getMultiLevelName(AccessUserBO.SEQUENCE_NAME, String.valueOf(i));
			System.out.println("Next AUID = " + operator.getNextId(multiLevelName) + " for appid " + i);
		}
	}
}
