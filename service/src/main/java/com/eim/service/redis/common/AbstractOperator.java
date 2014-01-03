/**
 * 
 */
package com.eim.service.redis.common;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Abstract Operator
 * 
 * @author maximus.zeng
 * 
 */
public abstract class AbstractOperator<T> implements RedisOperator<T> {
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	// inject the actual template
	@Resource(name = "redisTemplate")
	protected RedisTemplate<String, String> template;

	protected void addHashValue(HashOperations<String, String, String> ho, String key, String hkey, String value) {
		if (ho != null && StringUtils.isNotBlank(value) && StringUtils.isNotBlank(key)) {
			ho.put(key, hkey, value);
		}
	}

	protected void addSetValue(SetOperations<String, String> so, String key, String... values) {
		if (so != null && StringUtils.isNotBlank(key)) {
			so.add(key, values);
		}
	}

	protected void addStringValue(ValueOperations<String, String> vo, String key, String value) {
		if (vo != null && StringUtils.isNotBlank(key)) {
			vo.set(key, value);
		}
	}

	public abstract String getPrefix();

	public abstract String getKey(T entity);

	public void deleteOne(T entity) {
		template.delete(getKey(entity));
	}

	public void deleteAll() {
		template.delete(getPrefix() + "*");
	}

	public void deleteAll(String prefix) {
		template.delete(prefix + "*");
	}

}
