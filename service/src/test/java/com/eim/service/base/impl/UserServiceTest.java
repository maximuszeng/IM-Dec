package com.eim.service.base.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.UserService;
import com.eim.service.bo.base.StaffBO;
import com.eim.service.bo.base.UserBO;

public class UserServiceTest extends CommonJunitSpringTest {
	@Autowired
	protected UserService userService;
	private int t = 1;

	private UserBO newUser(int t) {
		UserBO user = new UserBO();
		user.setCreateDate(new Date().getTime());
		user.setName("jacky" + t);

		StaffBO sbo = new StaffBO();
		sbo.setEmail("jackyyang05" + t + "@hotmail.com");
		sbo.setPassword("password");
		sbo.setUserName("jackyyang" + t);

		user.setAdminStaff(sbo);

		return user;
	}

//	@Test
//	@Rollback(false)
//	public void testInsertUser() {
//		userService.registFreeUser(newUser(++t));
//	}

	@Test
	@Rollback(false)
	public void testBatchInsertUser() {
		for (int i = 0; i < 100; i++) {
			userService.registFreeUser(newUser(++t));
		}
	}

	@Test
	public void testLoadUser() {
		UserBO load = userService.load(1L);
		System.out.println(load.getUserType());
	}

}
