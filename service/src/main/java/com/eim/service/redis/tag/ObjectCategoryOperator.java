/**
 * 
 */
package com.eim.service.redis.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.service.bo.tag.ObjectCategoryBO;
import com.eim.service.redis.common.AbstractOperator;
import com.eim.service.tag.ObjectCategoryService;

/**
 * @author jacky.yong
 * 
 */
@Service
public class ObjectCategoryOperator extends AbstractOperator<ObjectCategoryBO> {
	@Autowired
	private ObjectCategoryService objectCategoryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.redis.common.RedisOperator#addAll()
	 */
	@Override
	public void addAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.redis.common.RedisOperator#addOne(java.lang.Object)
	 */
	@Override
	public void addOne(ObjectCategoryBO entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.redis.common.AbstractOperator#getPrefix()
	 */
	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.redis.common.AbstractOperator#getKey(java.lang.Object)
	 */
	@Override
	public String getKey(ObjectCategoryBO entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
