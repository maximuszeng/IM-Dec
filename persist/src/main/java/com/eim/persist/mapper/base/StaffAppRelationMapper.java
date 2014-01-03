package com.eim.persist.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eim.persist.po.base.StaffAppRelationPO;

/**
 * Staff App Relation Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface StaffAppRelationMapper {
	/**
	 * Load relations by appid and suid
	 * 
	 * @param appId
	 * @param suid
	 * @return
	 */
	StaffAppRelationPO load(@Param("appId") Long appId, @Param("suid") Long suid);

	/**
	 * Load relations by appid
	 * 
	 * @param appid
	 * @return
	 */
	List<StaffAppRelationPO> loadByAppId(Long appid);

	/**
	 * Load relations by suid
	 * 
	 * @param suid
	 * @return
	 */
	List<StaffAppRelationPO> loadBySUID(Long suid);

	/**
	 * Insert staff app relation
	 * 
	 * @param entity
	 */
	void insert(StaffAppRelationPO entity);

	/**
	 * Batch insert
	 * 
	 * @param entities
	 */
	void batchInsert(@Param("entities") List<StaffAppRelationPO> entities);

	/**
	 * Delete relation by appid and suid
	 * 
	 * @param appId
	 * @param suid
	 */
	void delete(@Param("appId") Long appId, @Param("suid") Long suid);

	/**
	 * Delete relations by appid
	 * 
	 * @param appId
	 */
	void deleteByAppId(@Param("appId") Long appId);

	/**
	 * Delete relations by suid
	 * 
	 * @param suid
	 */
	void deleteBySUID(@Param("suid") Long suid);

}
