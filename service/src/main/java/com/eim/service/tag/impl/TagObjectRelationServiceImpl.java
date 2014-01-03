/**
 * 
 */
package com.eim.service.tag.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.tag.TagObjectRelationMapper;
import com.eim.persist.po.tag.TagObjectRelationPO;
import com.eim.service.bo.tag.TagObjectRelationBO;
import com.eim.service.common.BaseService;
import com.eim.service.tag.TagObjectRelationService;

/**
 * @author jacky.yong
 * 
 */
@Service
public class TagObjectRelationServiceImpl extends BaseService<TagObjectRelationBO, TagObjectRelationPO> implements
		TagObjectRelationService {
	@Autowired
	private TagObjectRelationMapper tagObjectRelationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagObjectRelationService#insert(com.eim.bo.tag.
	 * TagObjectRelationBO)
	 */
	public void insert(TagObjectRelationBO entity) {
		tagObjectRelationMapper.insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagObjectRelationService#load(java.lang.Long)
	 */
	public TagObjectRelationBO load(Long tagId, Long objectId, Long objectCategoryId) {
		return super.copyPOToBO(tagObjectRelationMapper.load(tagId, objectId, objectCategoryId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagObjectRelationService#loadAll()
	 */
	public List<TagObjectRelationBO> loadAll() {
		List<TagObjectRelationPO> tagObjectRelationPOs = tagObjectRelationMapper.loadAll();
		List<TagObjectRelationBO> tagObjectRelationBOs = new ArrayList<TagObjectRelationBO>();
		for (TagObjectRelationPO tagCategoryPO : tagObjectRelationPOs) {
			tagObjectRelationBOs.add(copyPOToBO(tagCategoryPO));
		}
		return tagObjectRelationBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagObjectRelationService#update(com.eim.bo.tag.
	 * TagObjectRelationBO)
	 */
	public void updateWeight(TagObjectRelationBO entity) {
		tagObjectRelationMapper.updateWeight(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagObjectRelationService#delete(java.lang.Long)
	 */
	public void delete(Long tagId, Long objectId, Long objectCategoryId) {
		tagObjectRelationMapper.delete(tagId, objectId, objectCategoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#loadByObjectId(java.lang
	 * .Long, java.lang.Long)
	 */
	public List<TagObjectRelationBO> loadByObjectId(Long objectCategoryId, Long objectId) {
		List<TagObjectRelationPO> tagObjectRelationPOs = tagObjectRelationMapper.loadByObjectId(objectCategoryId,
				objectId);
		List<TagObjectRelationBO> tagObjectRelationBOs = new ArrayList<TagObjectRelationBO>();
		for (TagObjectRelationPO tagCategoryPO : tagObjectRelationPOs) {
			tagObjectRelationBOs.add(copyPOToBO(tagCategoryPO));
		}
		return tagObjectRelationBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#loadByObjectCategoryId(java
	 * .lang.Long)
	 */
	public List<TagObjectRelationBO> loadByObjectCategoryId(Long objectCategoryId) {
		List<TagObjectRelationPO> tagObjectRelationPOs = tagObjectRelationMapper
				.loadByObjectCategoryId(objectCategoryId);
		List<TagObjectRelationBO> tagObjectRelationBOs = new ArrayList<TagObjectRelationBO>();
		for (TagObjectRelationPO tagCategoryPO : tagObjectRelationPOs) {
			tagObjectRelationBOs.add(copyPOToBO(tagCategoryPO));
		}
		return tagObjectRelationBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#loadByTagId(java.lang.Long)
	 */
	public List<TagObjectRelationBO> loadByTagId(Long tagId) {
		List<TagObjectRelationPO> tagObjectRelationPOs = tagObjectRelationMapper.loadByTagId(tagId);
		List<TagObjectRelationBO> tagObjectRelationBOs = new ArrayList<TagObjectRelationBO>();
		for (TagObjectRelationPO tagCategoryPO : tagObjectRelationPOs) {
			tagObjectRelationBOs.add(copyPOToBO(tagCategoryPO));
		}
		return tagObjectRelationBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#batchInsert(java.util.List)
	 */
	public void batchInsert(List<TagObjectRelationBO> entities) {
		tagObjectRelationMapper.batchInsert(entities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#deleteByObjectId(java.lang
	 * .Long, java.lang.Long)
	 */
	public void deleteByObjectId(Long objectId, Long objectCategoryId) {
		tagObjectRelationMapper.deleteByObjectId(objectId, objectCategoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#deleteByObjectCategoryId
	 * (java.lang.Long)
	 */
	public void deleteByObjectCategoryId(Long objectCategoryId) {
		tagObjectRelationMapper.deleteByObjectCategoryId(objectCategoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.tag.TagObjectRelationService#deleteByTagId(java.lang.
	 * Long)
	 */
	public void deleteByTagId(Long tagId) {
		tagObjectRelationMapper.deleteByTagId(tagId);
	}

}
