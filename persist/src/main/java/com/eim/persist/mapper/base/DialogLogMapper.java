package com.eim.persist.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.po.base.DialogLogPO;

/**
 * DialogLog Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface DialogLogMapper {

	/**
	 * Load Dialog Logs by appid and staff user id, and range of create time
	 * 
	 * @param appId
	 * @param auId
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @return
	 */
	public List<DialogLogPO> loadByAppIdAndAuidAndCreateTimeRange(Long appId,
			Long auId, Long createTimeStart, Long createTimeEnd);

	/**
	 * Batch insert dialogs
	 * 
	 * @param entities
	 */
	@Transactional
	public void batchInsert(@Param("entities") List<DialogLogPO> entities);

	/**
	 * Insert single dialog
	 * 
	 * @param dialogLog
	 */
	@Transactional
	public void insert(DialogLogPO dialogLog);

	/**
	 * Delete dialog logs by appid and range of create time
	 * 
	 * @param appId
	 * @param createTimeStart
	 * @param createTimeEnd
	 */
	@Transactional
	public void deleteByAppIdAndCreateTimeRange(Long appId,
			Long createTimeStart, Long createTimeEnd);

	/**
	 * Delete dialog logs by appid
	 * 
	 * @param appId
	 */
	@Transactional
	public void deleteByAppId(Long appId);

	/**
	 * Delete dialog logs by access user id
	 * 
	 * @param auId
	 */
	@Transactional
	public void deleteByAuId(Long auId);

	/**
	 * Delete dialog logs by suid
	 * 
	 * @param suId
	 */
	@Transactional
	public void deleteBySuId(Long suId);
}
