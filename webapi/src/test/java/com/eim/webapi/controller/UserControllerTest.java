package com.eim.webapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.eim.service.bo.base.UserBO;
import com.eim.webapi.vo.base.UserVO;
import com.eim.webapi.vo.base.result.UserVOList;

public class UserControllerTest {
	private static final String REST_SERVICE_URL = "http://localhost:8080/zmeu-blog-spring-rest/users";
	private RestTemplate restTemplate;

	@Before
	protected void beforeClass() {
		restTemplate = new RestTemplate();
	}

	public void create() {
		createAndAssertUser();
	}

	public void read() {
		UserVO createdUser = createAndAssertUser();
		UserVO user = restTemplate.getForObject(REST_SERVICE_URL + "/{userId}", UserVO.class, createdUser.getUid());
		assertUser(user, createdUser);
	}

	public void update() {
		UserVO user = createAndAssertUser();
		user.setName("Updated user name");
		restTemplate.put(REST_SERVICE_URL + "/{userId}", user, user.getUid());
		UserVO updatedUser = restTemplate.getForObject(REST_SERVICE_URL + "/{userId}", UserVO.class, user.getUid());
		assertUser(updatedUser, user);
	}

	public void updateIncorrectUrl() {
		UserVO user = createAndAssertUser();
		user.setName("Updated user name");
		try {
			restTemplate.put(REST_SERVICE_URL + "/{userId}", user, user.getUid() + 1);
			Assert.fail("Expecting HttpClientErrorException: 400 Bad Request");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.BAD_REQUEST);
		}
	}

	public void delete() {
		UserVO createdUser = createAndAssertUser();
		restTemplate.delete(REST_SERVICE_URL + "/{userId}", createdUser.getUid());
		try {
			restTemplate.getForObject(REST_SERVICE_URL + "/{userId}", UserBO.class, createdUser.getUid());
			Assert.fail("Expecting HttpClientErrorException: 400 Bad Request");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.BAD_REQUEST);
		}
	}

	public void list() {
		UserVOList initialUsers = restTemplate.getForObject(REST_SERVICE_URL, UserVOList.class);
		UserVO createdUser = createAndAssertUser();
		UserVOList users = restTemplate.getForObject(REST_SERVICE_URL, UserVOList.class);
		List<UserVO> createdUsers = new ArrayList<UserVO>(users.getUsers());
		createdUsers.removeAll(initialUsers.getUsers());
		Assert.assertEquals(createdUsers.size(), 1);
		assertUser(createdUsers.get(0), createdUser);
	}

	private UserVO createAndAssertUser() {
		UserVO user = new UserVO();
		user.setUid(0L);
		user.setName("UserVo name");
		user.setCreateDate(new Date().getTime());
		return createAndAssertUser(user);
	}

	private UserVO createAndAssertUser(UserVO user) {
		UserVO createdUser = restTemplate.postForObject(REST_SERVICE_URL, user, UserVO.class);
		assertUserNoId(createdUser, user);
		return createdUser;
	}

	private void assertUserNoId(UserVO actual, UserVO expected) {
		Assert.assertTrue(actual.getUid() > 0);
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getCreateDate(), expected.getCreateDate());
	}

	private void assertUser(UserVO actual, UserVO expected) {
		Assert.assertTrue(actual.getUid() > 0);
		Assert.assertEquals(actual.getName(), expected.getName());
		Assert.assertEquals(actual.getCreateDate(), expected.getCreateDate());
	}
}