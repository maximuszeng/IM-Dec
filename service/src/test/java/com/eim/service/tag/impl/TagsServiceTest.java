/**
 * 
 */
package com.eim.service.tag.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.eim.persist.enums.Locale;
import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.tag.TagsBO;
import com.eim.service.tag.TagsService;

/**
 * @author jacky.yong
 * 
 */
public class TagsServiceTest extends CommonJunitSpringTest {
	@Autowired
	private TagsService tagsService;

	private TagsBO newTags(int t) {
		TagsBO tagsBO = new TagsBO();
		tagsBO.setName("Tags" + t);
		tagsBO.setLocale(Locale.EN_US);
		tagsBO.setWeight((long) t);
		tagsBO.setCategoryId(6L);
		tagsBO.setCreateDate(new Date().getTime());
		return tagsBO;
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
			tagsService.insert(newTags(i));
		}
	}

	private int t = 10;

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
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#insert(com.eim.service.bo.tag.TagsBO)}
	 * .
	 */
	@Test
	public void testInsert() {
		tagsService.insert(newTags(t++));
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#batchInsert(java.util.List)}
	 * .
	 */
	@Test
	public void testBatchInsert() {
		List<TagsBO> lists = new ArrayList<TagsBO>();

		for (int i = 0; i < 100; i++) {
			lists.add(newTags(t++));
		}
		tagsService.batchInsert(lists);
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#load(java.lang.Long)}.
	 */
	@Test
	public void testLoad() {
		Assert.notNull(tagsService.load(1L));
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#loadAll()}.
	 */
	@Test
	public void testLoadAll() {
		Assert.notEmpty(tagsService.loadAll());
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#update(com.eim.service.bo.tag.TagsBO)}
	 * .
	 */
	@Test
	public void testUpdate() {
		TagsBO load = tagsService.load(1L);
		load.setName("changed");
		tagsService.update(load);
	}

	/**
	 * Test method for
	 * {@link com.eim.service.tag.impl.TagsServiceImpl#delete(java.lang.Long)}.
	 */
	@Test
	public void testDelete() {
		tagsService.delete(2L);
	}

}
