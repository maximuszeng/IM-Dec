/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import com.eim.service.bo.base.StaffAppRelationBO;

/**
 * @author jacky.yong
 * 
 */
public interface StaffAppRelationService {
	/**
	 * Load relations by appid and suid
	 * 
	 * @param appId
	 * @param suid
	 * @return
	 */
	StaffAppRelationBO load(Long appId, Long suid);

	/**
	 * Load relations by appid
	 * 
	 * @param appid
	 * @return
	 */
	List<StaffAppRelationBO> loadByAppId(Long appid);

	/**
	 * Load relations by suid
	 * 
	 * @param suid
	 * @return
	 */
	List<StaffAppRelationBO> loadBySUID(Long suid);

	/**
	 * Insert staff app relation
	 * 
	 * @param entity
	 */
	void insert(StaffAppRelationBO entity);

	/**
	 * Batch insert
	 * 
	 * @param entities
	 */
	void batchInsert(List<StaffAppRelationBO> entities);

	/**
	 * Delete relation by appid and suid
	 * 
	 * @param appId
	 * @param suid
	 */
	void delete(Long appId, Long suid);

	/**
	 * Delete relations by appid
	 * 
	 * @param appId
	 */
	void deleteByAppId(Long appId);

	/**
	 * Delete relations by suid
	 * 
	 * @param suid
	 */
	void deleteBySUID(Long suid);

}
