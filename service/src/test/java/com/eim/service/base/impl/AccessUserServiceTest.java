/**
 * 
 */
package com.eim.service.base.impl;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.AccessUserService;
import com.eim.service.base.ApplicationService;
import com.eim.service.base.SequenceService;
import com.eim.service.bo.base.AccessUserBO;
import com.eim.service.bo.base.ApplicationBO;

public class AccessUserServiceTest extends CommonJunitSpringTest {
	@Autowired
	protected AccessUserService accessUserService;
	@Autowired
	protected ApplicationService applicationService;
	@Autowired
	protected SequenceService sequenceService;

	private int t = 10;

	private ApplicationBO application;
	private AccessUserBO FOR_SINGLE_TEST;

	@Before
	@Rollback(false)
	public void loadApplication() {
		application = applicationService.load(1L);
		FOR_SINGLE_TEST = newAccessUser(0);
		accessUserService.insert(FOR_SINGLE_TEST);
	}

	private AccessUserBO newAccessUser(int t) {
		AccessUserBO au = new AccessUserBO();
		au.setAccessTime(new Date().getTime());
		au.setAppId(application.getAppId());
		au.setEmail("jackyyang0501@hotmail.com");
		au.setIpAddress("192.111.111.111");
		au.setMobile("11111111111");
		au.setName("jacky" + t);
		au.setSessionId("ssssssssssssssss");
		return au;
	}

	@Test
	@Rollback(false)
	public void testInsert() {
		AccessUserBO app = newAccessUser(1);
		accessUserService.insert(app);
	}

	@Test
	@Rollback(false)
	public void testUpdate() {
		AccessUserBO app = accessUserService.load(application.getAppId(), FOR_SINGLE_TEST.getAuid());
		app.setName("changeit");
		accessUserService.update(app);
	}

	@Test
	public void testDelete() {
		accessUserService.delete(application.getAppId(), FOR_SINGLE_TEST.getAuid());
	}

	@Test
	@Rollback(false)
	public void testBatchInsert() {
		for (int i = 0; i < 100; i++) {
			AccessUserBO app = newAccessUser(1);
			accessUserService.insert(app);
		}
	}

}
