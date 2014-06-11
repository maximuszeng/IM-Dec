package com.eim.persist;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.mapper.base.SequenceVerifierMapper;

/**
 * Base Junit Spring Test
 * 
 * @author jacky.yang
 * 
 *         if you want to disable auto rollback, add @Rollback(false) to your
 *         test method.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/spring-*.xml")
public class CommonJunitSpringTest extends TestCase {

	@Autowired
	protected SequenceVerifierMapper sequenceMapper;
	
	public CommonJunitSpringTest(String testName) {
		super(testName);
	}

	public CommonJunitSpringTest() {

	}
	
	public static Test suite() {
		return new TestSuite(CommonJunitSpringTest.class);
	}

}
