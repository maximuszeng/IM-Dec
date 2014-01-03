package com.eim.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.base.SequenceVerifierMapper;
import com.eim.service.base.SequenceService;
import com.eim.service.redis.base.SequenceOperator;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class SequenceServiceImpl implements SequenceService {
	@Autowired
	private SequenceVerifierMapper sequenceVerifierMapper;

	@Autowired
	private SequenceOperator sequenceOperator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.service.impl.SequenceService#getNextId(java.lang.String)
	 */
	public Long getNextId(String name) {
		return sequenceOperator.getNextId(name);
	}

	public String getMultiLevelName(String prefix, String subValue) {
		return sequenceOperator.getMultiLevelName(prefix, subValue);
	}

}
