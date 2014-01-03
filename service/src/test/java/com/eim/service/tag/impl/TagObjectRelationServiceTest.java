/**
 * 
 */
package com.eim.service.tag.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.tag.TagObjectRelationBO;
import com.eim.service.tag.TagObjectRelationService;

/**
 * @author jacky.yong
 * 
 */
public class TagObjectRelationServiceTest extends CommonJunitSpringTest {
	@Autowired
	private TagObjectRelationService tagObjectRelationService;

	private int t = 10;

	private TagObjectRelationBO newTagObjectRelation(int t) {
		TagObjectRelationBO tagObjectRelationBO = new TagObjectRelationBO();
		tagObjectRelationBO.setObjectCategoryId(1L);
		tagObjectRelationBO.setObjectId((long) t);
		tagObjectRelationBO.setTagId(1L);
		tagObjectRelationBO.setWeight((long) t);
		return tagObjectRelationBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		for (int i = 1; i < 10; i++) {
			tagObjectRelationService.insert(newTagObjectRelation(i));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagObjectRelationServiceImpl#insert(com.eim.service.bo.tag.TagObjectRelationBO)}
	 * .
	 */
	@Test
	public void testInsert() {
		tagObjectRelationService.insert(newTagObjectRelation(++t));
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagObjectRelationServiceImpl#loadAll()}.
	 */
	@Test
	public void testLoadAll() {
		Assert.notEmpty(tagObjectRelationService.loadAll());
	}

}
