/**
 * 
 */
package com.eim.service.tag.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.tag.TagsMapper;
import com.eim.persist.po.tag.TagsPO;
import com.eim.service.bo.tag.TagsBO;
import com.eim.service.common.BaseService;
import com.eim.service.tag.TagsService;

/**
 * @author jacky.yong
 * 
 */
@Service
public class TagsServiceImpl extends BaseService<TagsBO, TagsPO> implements TagsService {
	@Autowired
	private TagsMapper tagsMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagsService#insert(com.eim.bo.tag.TagsBO)
	 */
	public TagsBO insert(TagsBO entity) {
		Long nextId = sequenceService.getNextId(TagsBO.SEQUENCE_NAME);
		entity.setId(nextId);
		tagsMapper.insert(entity);
		return entity;
	}

	public List<TagsBO> batchInsert(List<TagsBO> entities) {
		if (entities != null && entities.size() > 0) {
			for (TagsBO entity : entities) {
				entity.setId(sequenceService.getNextId(TagsBO.SEQUENCE_NAME));
			}
			tagsMapper.batchInsert(entities);
		}
		return entities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagsService#load(java.lang.Long)
	 */
	public TagsBO load(Long pk) {
		return super.copyPOToBO(tagsMapper.load(pk));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagsService#loadAll()
	 */
	public List<TagsBO> loadAll() {
		List<TagsPO> tagsPOs = tagsMapper.loadAll();
		List<TagsBO> tagsBOs = new ArrayList<TagsBO>();
		for (TagsPO tagsPO : tagsPOs) {
			tagsBOs.add(copyPOToBO(tagsPO));
		}
		return tagsBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagsService#update(com.eim.bo.tag.TagsBO)
	 */
	public void update(TagsBO entity) {
		tagsMapper.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.TagsService#delete(java.lang.Long)
	 */
	public void delete(Long pk) {
		tagsMapper.delete(pk);
	}

}
