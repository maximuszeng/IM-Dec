/**
 * 
 */
package com.eim.persist.mapper.base;

import java.util.List;

import com.eim.persist.mapper.common.BaseMapper;
import com.eim.persist.po.base.StaffPO;

/**
 * Staff Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface StaffMapper extends BaseMapper<StaffPO, Long> {
	/**
	 * Load staffs by uid
	 * 
	 * @param uid
	 * @return
	 */
	List<StaffPO> loadByUID(Long uid);

	/**
	 * Load unique staff by username
	 * 
	 * @param userName
	 * @return
	 */
	StaffPO loadByUserName(String userName);

	/**
	 * Load unique staff by email
	 * 
	 * @param email
	 * @return
	 */
	StaffPO loadByEmail(String email);

	/**
	 * Load ids by uid
	 * 
	 * @param uid
	 * @return
	 */
	List<Long> loadIDsByUID(Long uid);

	/**
	 * Delete by uid
	 * 
	 * @param uid
	 */
	void deleteByUID(Long uid);
}
