/**
 * 
 */
package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.po.base.StaffAppRelationPO;
import com.eim.service.base.StaffAppRelationService;
import com.eim.service.bo.base.StaffAppRelationBO;
import com.eim.service.common.BaseService;

/**
 * @author maximus.zeng
 * 
 */
public class StaffAppRelationServiceImpl extends BaseService<StaffAppRelationBO, StaffAppRelationPO> implements
		StaffAppRelationService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.base.StaffAppRelationService#load(java.lang.Long,
	 * java.lang.Long)
	 */
	public StaffAppRelationBO load(Long appId, Long suid) {
		StaffAppRelationBO copyPOToBO = super.copyPOToBO(staffAppRelationMapper.load(appId, suid));
		return copyPOToBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#loadByAppId(java.lang.Long)
	 */
	public List<StaffAppRelationBO> loadByAppId(Long appid) {
		List<StaffAppRelationPO> pos = staffAppRelationMapper.loadByAppId(appid);
		List<StaffAppRelationBO> bos = new ArrayList<StaffAppRelationBO>();
		for (StaffAppRelationPO po : pos) {
			bos.add(copyPOToBO(po));
		}
		return bos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#loadBySUID(java.lang.Long)
	 */
	public List<StaffAppRelationBO> loadBySUID(Long suid) {
		List<StaffAppRelationPO> pos = staffAppRelationMapper.loadBySUID(suid);
		List<StaffAppRelationBO> bos = new ArrayList<StaffAppRelationBO>();
		for (StaffAppRelationPO po : pos) {
			bos.add(copyPOToBO(po));
		}
		return bos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#insert(com.eim.service.bo
	 * .base.StaffAppRelationBO)
	 */
	@Transactional
	public void insert(StaffAppRelationBO entity) {
		staffAppRelationMapper.insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#batchInsert(java.util.List)
	 */
	@Transactional
	public void batchInsert(List<StaffAppRelationBO> entities) {
		staffAppRelationMapper.batchInsert(entities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.base.StaffAppRelationService#delete(java.lang.Long,
	 * java.lang.Long)
	 */
	@Transactional
	public void delete(Long appId, Long suid) {
		staffAppRelationMapper.delete(appId, suid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#deleteByAppId(java.lang.
	 * Long)
	 */
	@Transactional
	public void deleteByAppId(Long appId) {
		staffAppRelationMapper.deleteByAppId(appId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.base.StaffAppRelationService#deleteBySUID(java.lang.Long)
	 */
	@Transactional
	public void deleteBySUID(Long suid) {
		staffAppRelationMapper.deleteBySUID(suid);
	}

}
