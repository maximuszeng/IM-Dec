package com.eim.persist.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eim.persist.po.base.AccessUserPO;

/**
 * Access User Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface AccessUserMapper {

	/**
	 * Load access users by appid and range of access time
	 * 
	 * @param appId
	 * @param accessTimeStart
	 * @param accessTimeEnd
	 * @return
	 */
	List<AccessUserPO> loadByAppIdAndAccessTimeRange(
			@Param("appId") Long appId,
			@Param("accessTimeStart") Long accessTimeStart,
			@Param("accessTimeEnd") Long accessTimeEnd);

	/**
	 * Load unique access user by appid and access user id
	 * 
	 * @param appId
	 * @param auid
	 * @return
	 */
	AccessUserPO load(@Param("appId") Long appId, @Param("auid") Long auid);

	/**
	 * Insert access user
	 * 
	 * @param entity
	 */
	void insert(AccessUserPO entity);

	/**
	 * Delete access user by appid and access user id
	 * 
	 * @param appId
	 * @param auid
	 */
	void delete(@Param("appId") Long appId, @Param("auid") Long auid);

	/**
	 * Delete access users by appid
	 * 
	 * @param appId
	 */
	void deleteByAppId(@Param("appId") Long appId);

	/**
	 * Update access user(such as email, mobileno etc.)
	 * 
	 * @param entity
	 */
	void update(AccessUserPO entity);

	/**
	 * Delete access users by appid and range of access time
	 * 
	 * @param appId
	 * @param accessTimeStart
	 * @param accessTimeEnd
	 */
	void deleteByAppIdAndAccessTimeRange(@Param("appId") Long appId,
			@Param("accessTimeStart") Long accessTimeStart,
			@Param("accessTimeEnd") Long accessTimeEnd);

}
