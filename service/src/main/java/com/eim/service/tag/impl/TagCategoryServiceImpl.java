/**
 * 
 */
package com.eim.service.tag.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.tag.TagCategoryMapper;
import com.eim.persist.po.tag.TagCategoryPO;
import com.eim.service.bo.tag.TagCategoryBO;
import com.eim.service.common.BaseService;
import com.eim.service.tag.TagCategoryService;

/**
 * @author jacky.yong
 * 
 */
@Service
public class TagCategoryServiceImpl extends BaseService<TagCategoryBO, TagCategoryPO> implements TagCategoryService {
	@Autowired
	private TagCategoryMapper tagCategoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagCategoryService#insert(com.eim.bo.tag.TagCategoryBO
	 * )
	 */
	public TagCategoryBO insert(TagCategoryBO entity) {
		Long nextId = sequenceService.getNextId(TagCategoryBO.SEQUENCE_NAME);
		entity.setId(nextId);
		tagCategoryMapper.insert(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagCategoryService#load(java.lang.Long)
	 */
	public TagCategoryBO load(Long pk) {
		return super.copyPOToBO(tagCategoryMapper.load(pk));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagCategoryService#loadAll()
	 */
	public List<TagCategoryBO> loadAll() {
		List<TagCategoryPO> tagCategoryPOs = tagCategoryMapper.loadAll();
		List<TagCategoryBO> tagCategoryBOs = new ArrayList<TagCategoryBO>();
		for (TagCategoryPO tagCategoryPO : tagCategoryPOs) {
			tagCategoryBOs.add(copyPOToBO(tagCategoryPO));
		}
		return tagCategoryBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagCategoryService#update(com.eim.bo.tag.TagCategoryBO
	 * )
	 */
	public void update(TagCategoryBO entity) {
		tagCategoryMapper.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagCategoryService#delete(java.lang.Long)
	 */

	public void delete(Long pk) {
		tagCategoryMapper.delete(pk);
	}

}
