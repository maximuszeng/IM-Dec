/**
 * 
 */
package com.eim.service.redis.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.service.bo.tag.TagObjectRelationBO;
import com.eim.service.redis.common.AbstractOperator;
import com.eim.service.tag.TagObjectRelationService;

/**
 * @author jacky.yong
 * 
 */
@Service
public class TagObjectRelationOperator extends AbstractOperator<TagObjectRelationBO> {
	@Autowired
	private TagObjectRelationService tagObjectRelationService;

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
	public void addOne(TagObjectRelationBO entity) {
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
	public String getKey(TagObjectRelationBO entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
