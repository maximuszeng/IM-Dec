package com.eim.persist.mapper.common;

import java.util.List;

import com.eim.persist.po.common.BasePO;

/**
 * Base Mapper
 * 
 * @author maximus.zeng
 * 
 * @param <T>
 *            Entity type
 * @param <P>
 *            Primiary Key type
 */
public interface BaseMapper<T extends BasePO, P> {
	/**
	 * Insert entity
	 * 
	 * @param entity
	 */
	void insert(T entity);

	/**
	 * Load entity by primary key
	 * 
	 * @param pk
	 * @return
	 */
	T load(P pk);
	
	List<T> loadAll();

	/**
	 * Update entity
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * Delete entity by primary key
	 * 
	 * @param pk
	 */
	void delete(P pk);

}
