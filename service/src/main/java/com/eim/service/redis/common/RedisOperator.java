/**
 * 
 */
package com.eim.service.redis.common;

/**
 * Redis Operator Interface
 * 
 * @author jacky.yong
 * 
 * @param <T>
 */
public interface RedisOperator<T> {
	/**
	 * Load All Entity
	 */
	void addAll();

	/**
	 * Add one entity
	 * 
	 * @param entity
	 */
	void addOne(T entity);

	/**
	 * Delete one entity
	 * 
	 * @param entity
	 */
	void deleteOne(T entity);

	/**
	 * Delete All Entity
	 * 
	 * @param entity
	 */
	void deleteAll();
}
