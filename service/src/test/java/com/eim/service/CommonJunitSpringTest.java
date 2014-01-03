package com.eim.service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Base Junit Spring Test
 * 
 * @author maximus.zeng
 * 
 *         if you want to disable auto rollback, add @Rollback(false) to your
 *         test method.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/spring-*.xml")
public class CommonJunitSpringTest extends TestCase {
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	public CommonJunitSpringTest(String testName) {
		super(testName);
	}

	public CommonJunitSpringTest() {

	}

	public static Test suite() {
		return new TestSuite(CommonJunitSpringTest.class);
	}

}
