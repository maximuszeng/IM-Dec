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

import com.eim.persist.enums.Locale;
import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.tag.TagCategoryBO;
import com.eim.service.tag.TagCategoryService;

/**
 * @author jacky.yong
 *
 */
public class TagCategoryServiceTest extends CommonJunitSpringTest {

	@Autowired
	private TagCategoryService tagCategoryService;

	private TagCategoryBO newTagCategory(int t) {
		TagCategoryBO tagCategoryBO = new TagCategoryBO();
		tagCategoryBO.setName("TagCategory" + t);
		tagCategoryBO.setDescription("DESC" + t);
		tagCategoryBO.setLocale(Locale.EN_US);
		tagCategoryBO.setCreateDate(new Date().getTime());
		return tagCategoryBO;
	}

	private int t = 10;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		for (int i = 1; i < 10; i++) {
			tagCategoryService.insert(newTagCategory(i));
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.eim.service.tag.impl.TagCategoryServiceImpl#insert(com.eim.service.bo.tag.TagCategoryBO)}.
	 */
	@Test
	public void testInsert() {
		tagCategoryService.insert(newTagCategory(t++));
	}

	/**
	 * Test method for {@link com.eim.service.tag.impl.TagCategoryServiceImpl#load(java.lang.Long)}.
	 */
	@Test
	public void testLoad() {
		Assert.notNull(tagCategoryService.load(1L));
	}

	/**
	 * Test method for {@link com.eim.service.tag.impl.TagCategoryServiceImpl#loadAll()}.
	 */
	@Test
	public void testLoadAll() {
		Assert.notEmpty(tagCategoryService.loadAll());
	}

	/**
	 * Test method for {@link com.eim.service.tag.impl.TagCategoryServiceImpl#update(com.eim.service.bo.tag.TagCategoryBO)}.
	 */
	@Test
	public void testUpdate() {
		TagCategoryBO load = tagCategoryService.load(1L);
		load.setName("changed");
		tagCategoryService.update(load);
	}

	/**
	 * Test method for {@link com.eim.service.tag.impl.TagCategoryServiceImpl#delete(java.lang.Long)}.
	 */
	@Test
	public void testDelete() {
		tagCategoryService.delete(2L);
	}

}
