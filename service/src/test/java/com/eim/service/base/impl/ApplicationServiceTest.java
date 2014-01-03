/**
 * 
 */
package com.eim.service.base.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import com.eim.persist.enums.AppType;
import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.ApplicationService;
import com.eim.service.bo.base.ApplicationBO;

public class ApplicationServiceTest extends CommonJunitSpringTest {
	@Autowired
	protected ApplicationService applicationService;

	private ApplicationBO application;
	private Long t = 2L;

	private ApplicationBO newApplication(Long t) {
		ApplicationBO app = new ApplicationBO();
		app.setAppType(AppType.WEB);
		app.setDomain("localhost" + t);
		app.setWelcomeMessage("Welcome to app " + t);
		app.setName("E-CM" + t);
		app.setUid(1L);
		return app;
	}

	@Before
	@Rollback(false)
	public void testInsert() {
		ApplicationBO app = newApplication(1L);
		applicationService.newApp(app);
		Long appId = app.getAppId();

		application = applicationService.load(appId);

		Assert.notNull(application, "Application id = " + appId + " must exists in db!");
	}

	@Test
	@Rollback(false)
	public void testBatchInsert() {
		for (Long i = t; i < 10; i++) {
			ApplicationBO app = newApplication(i);
			applicationService.newApp(app);
			Long appId = app.getAppId();
			ApplicationBO load = applicationService.load(appId);
			Assert.notNull(load, "Application id = " + appId + " must exists in db!");
		}
	}

	@Test
	@Rollback(false)
	public void testUpdate() {
		ApplicationBO app = applicationService.load(application.getAppId());
		app.setDomain("aaa");
		applicationService.update(app);
	}

	@Test
	// @Rollback(false)
	public void testDelete() {
		applicationService.delete(application.getAppId());
	}

}
