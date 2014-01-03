/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.DialogLogBO;

/**
 * @author maximus.zeng
 * 
 */
public interface DialogLogService {

	public List<DialogLogBO> loadByAppIdAndAuidAndCreateTimeRange(Long appId, Long auid, Long createTimeStart,
			Long createTimeEnd);

	@Transactional
	public void batchInsert(List<DialogLogBO> accessUsers);

	@Transactional
	public void deleteByAppIdAndCreateTimeRange(Long appId, Long createTimeStart, Long createTimeEnd);

	@Transactional
	public void deleteByAppId(Long appId);

	@Transactional
	public void deleteByAuId(Long auId);

	@Transactional
	public void deleteBySuId(Long suId);
}