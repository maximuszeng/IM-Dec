package com.eim.persist.mapper.base;

import com.eim.persist.mapper.common.BaseMapper;
import com.eim.persist.po.base.UserPO;

/**
 * User Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface UserMapper extends BaseMapper<UserPO, Long> {
	/**
	 * Update Staff Used After New Staff Created
	 * 
	 * @param uid
	 */
	void updateStaffUsedAfterNewStaffCreated(Long uid);

	/**
	 * Update Staff Used After New Staff Deleted
	 * 
	 * @param uid
	 */
	void updateStaffUsedAfterNewStaffDeleted(Long uid);

	/**
	 * Update Staff Used to zero After New Staff
	 * 
	 * @param uid
	 */
	void updateStaffUsedToZero(Long uid);
}
