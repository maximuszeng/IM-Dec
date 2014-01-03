/**
 * 
 */
package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.po.base.DialogLogPO;
import com.eim.service.base.DialogLogService;
import com.eim.service.bo.base.DialogLogBO;
import com.eim.service.common.BaseService;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class DialogLogServiceImpl extends BaseService<DialogLogBO, DialogLogPO> implements DialogLogService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.DialogLogService#loadByAppIdAndAuidAndCreateTimeRange
	 * (java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	public List<DialogLogBO> loadByAppIdAndAuidAndCreateTimeRange(Long appId, Long auid, Long createTimeStart,
			Long createTimeEnd) {
		List<DialogLogPO> dialogLogPOs = dialogLogMapper.loadByAppIdAndAuidAndCreateTimeRange(appId, auid,
				createTimeStart, createTimeEnd);
		List<DialogLogBO> dialogLogBOs = new ArrayList<DialogLogBO>();

		for (DialogLogPO dialogLogPO : dialogLogPOs) {
			dialogLogBOs.add(copyPOToBO(dialogLogPO));
		}

		return dialogLogBOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.DialogLogService#batchInsert(java.util.List)
	 */
	@Transactional
	public void batchInsert(List<DialogLogBO> dialogLogBOs) {
		List<DialogLogPO> dialogLogPOs = new ArrayList<DialogLogPO>();
		for (DialogLogBO dialogLogBO : dialogLogBOs) {
			dialogLogPOs.add(dialogLogBO);
		}

		dialogLogMapper.batchInsert(dialogLogPOs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.DialogLogService#deleteByAppIdAndCreateTimeRange(java
	 * .lang.Long, java.lang.Long, java.lang.Long)
	 */
	@Transactional
	public void deleteByAppIdAndCreateTimeRange(Long appId, Long createTimeStart, Long createTimeEnd) {
		dialogLogMapper.deleteByAppIdAndCreateTimeRange(appId, createTimeStart, createTimeEnd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.DialogLogService#deleteByAppId(java.lang.Long)
	 */
	@Transactional
	public void deleteByAppId(Long appId) {
		dialogLogMapper.deleteByAppId(appId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.DialogLogService#deleteByAuId(java.lang.Long)
	 */
	@Transactional
	public void deleteByAuId(Long auId) {
		dialogLogMapper.deleteByAuId(auId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.DialogLogService#deleteBySuId(java.lang.Long)
	 */
	@Transactional
	public void deleteBySuId(Long suId) {
		dialogLogMapper.deleteBySuId(suId);
	}
}
