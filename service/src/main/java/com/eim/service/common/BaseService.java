package com.eim.service.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import com.eim.persist.mapper.base.AccessUserMapper;
import com.eim.persist.mapper.base.ApplicationMapper;
import com.eim.persist.mapper.base.DialogLogMapper;
import com.eim.persist.mapper.base.StaffMapper;
import com.eim.persist.mapper.base.UserMapper;
import com.eim.persist.po.common.BasePO;
import com.eim.service.base.SequenceService;
import com.eim.service.redis.base.ApplicationOperator;
import com.eim.service.redis.base.StaffOperator;
import com.eim.service.redis.base.UserOperator;

/**
 * @author maximus.zeng
 * 
 */
public abstract class BaseService<B, P extends BasePO> {
	@Autowired
	protected SequenceService sequenceService;
	@Autowired
	protected UserMapper userMapper;
	@Autowired
	protected ApplicationMapper applicationMapper;
	@Autowired
	protected StaffMapper staffMapper;
	@Autowired
	protected DialogLogMapper dialogLogMapper;
	@Autowired
	protected AccessUserMapper accessUserMapper;
	@Autowired
	protected ApplicationOperator applicationOperator;
	@Autowired
	protected StaffOperator staffOperator;
	@Autowired
	protected UserOperator userOperator;

	private Class<B> boType;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseService() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		boType = (Class) pt.getActualTypeArguments()[0];
	}

	protected B copyPOToBO(P po) {
		B bo = null;
		try {
			bo = boType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	protected String md5(Long value) {
		return md5(String.valueOf(value));
	}

	protected String md5(String value) {
		return DigestUtils.md5DigestAsHex(value.getBytes()).toUpperCase();
	}
}
