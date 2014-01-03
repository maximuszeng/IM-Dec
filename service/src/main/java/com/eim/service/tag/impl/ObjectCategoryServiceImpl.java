package com.eim.service.tag.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.tag.ObjectCategoryMapper;
import com.eim.persist.po.tag.ObjectCategoryPO;
import com.eim.service.bo.tag.ObjectCategoryBO;
import com.eim.service.common.BaseService;
import com.eim.service.tag.ObjectCategoryService;

@Service
public class ObjectCategoryServiceImpl extends BaseService<ObjectCategoryBO, ObjectCategoryPO> implements
		ObjectCategoryService {
	@Autowired
	private ObjectCategoryMapper objectCategoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.ObjectCategoryService#insert(com.eim.bo.tag.
	 * ObjectCategoryBO)
	 */
	public ObjectCategoryBO insert(ObjectCategoryBO entity) {
		Long nextId = sequenceService.getNextId(ObjectCategoryBO.SEQUENCE_NAME);
		entity.setCategoryId(nextId);
		objectCategoryMapper.insert(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.ObjectCategoryService#load(java.lang.Long)
	 */
	public ObjectCategoryBO load(Long pk) {
		return super.copyPOToBO(objectCategoryMapper.load(pk));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.ObjectCategoryService#loadAll()
	 */
	public List<ObjectCategoryBO> loadAll() {
		List<ObjectCategoryPO> objectCategoryPOs = objectCategoryMapper.loadAll();
		List<ObjectCategoryBO> objectCategoryBOs = new ArrayList<ObjectCategoryBO>();
		for (ObjectCategoryPO objectCategory : objectCategoryPOs) {
			objectCategoryBOs.add(copyPOToBO(objectCategory));
		}
		return objectCategoryBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.ObjectCategoryService#update(com.eim.bo.tag.
	 * ObjectCategoryBO)
	 */
	public void update(ObjectCategoryBO entity) {
		objectCategoryMapper.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.tag.ObjectCategoryService#delete(java.lang.Long)
	 */
	public void delete(Long pk) {
		objectCategoryMapper.delete(pk);
	}
}
