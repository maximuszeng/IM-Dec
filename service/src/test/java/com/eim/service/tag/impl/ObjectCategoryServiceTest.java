/**
 * 
 */
package com.eim.service.tag.impl;


import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.tag.ObjectCategoryBO;
import com.eim.service.tag.ObjectCategoryService;

/**
 * @author jacky.yong
 * 
 */
public class ObjectCategoryServiceTest extends CommonJunitSpringTest {

	@Autowired
	private ObjectCategoryService objectCategoryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		for (int i = 1; i < 10; i++) {
			objectCategoryService.insert(newObjectCategory(i));
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

	private int t = 10;

	private ObjectCategoryBO newObjectCategory(int t) {
		ObjectCategoryBO objectCategoryBO = new ObjectCategoryBO();
		objectCategoryBO.setName("ObjectCategory" + t);
		objectCategoryBO.setCreateDate(new Date().getTime());
		objectCategoryBO.setDescription("ObjectCategory" + t);
		return objectCategoryBO;
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.ObjectCategoryServiceImpl#insert(com.eim.service.bo.tag.ObjectCategoryBO)}
	 * .
	 */
	@Test
	public void testInsert() {
		objectCategoryService.insert(newObjectCategory(t++));
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.ObjectCategoryServiceImpl#load(java.lang.Long)}
	 * .
	 */
	@Test
	public void testLoad() {
		Assert.notNull(objectCategoryService.load(1L));
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.ObjectCategoryServiceImpl#loadAll()}.
	 */
	@Test
	public void testLoadAll() {
		Assert.notEmpty(objectCategoryService.loadAll());
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.ObjectCategoryServiceImpl#update(com.eim.service.bo.tag.ObjectCategoryBO)}
	 * .
	 */
	@Test
	public void testUpdate() {
		ObjectCategoryBO load = objectCategoryService.load(1L);
		load.setName("changed");
		objectCategoryService.update(load);
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.ObjectCategoryServiceImpl#delete(java.lang.Long)}
	 * .
	 */
	@Test
	public void testDelete() {
		objectCategoryService.delete(2L);
	}

}
