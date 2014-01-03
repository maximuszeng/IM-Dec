package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.po.base.AccessUserPO;
import com.eim.service.base.AccessUserService;
import com.eim.service.bo.base.AccessUserBO;
import com.eim.service.common.BaseService;

@Service
public class AccessUserServiceImpl extends BaseService<AccessUserBO, AccessUserPO> implements AccessUserService {
	@Transactional
	public void delete(Long appId, Long auid) {
		dialogLogMapper.deleteByAuId(auid);
		accessUserMapper.delete(appId, auid);
	}

	@Transactional
	public void update(AccessUserBO entity) {
		accessUserMapper.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.persist.service.impl.AccessUserService#insert(com.eim
	 * .redispro.persist.domain.AccessUserVo)
	 */
	@Transactional
	public AccessUserBO insert(AccessUserBO accessUser) {
		Long nextId = sequenceService.getNextId(sequenceService.getMultiLevelName(AccessUserPO.SEQUENCE_NAME,
				String.valueOf(accessUser.getAppId())));
		accessUser.setAuid(nextId);
		accessUserMapper.insert(accessUser);
		return accessUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.AccessUserService#loadByAppIdAndAccessTimeRange(java.
	 * lang.Long, java.lang.Long, java.lang.Long)
	 */
	public List<AccessUserBO> loadByAppIdAndAccessTimeRange(Long appId, Long accessTimeStart, Long accessTimeEnd) {
		List<AccessUserPO> accessUsers = accessUserMapper.loadByAppIdAndAccessTimeRange(appId, accessTimeStart,
				accessTimeEnd);
		List<AccessUserBO> accessUserBOS = new ArrayList<AccessUserBO>();

		for (AccessUserPO accessUser : accessUsers) {
			accessUserBOS.add(copyPOToBO(accessUser));
		}

		return accessUserBOS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.AccessUserService#deleteByAppIdAndAccessTimeRange(java
	 * .lang.Long, java.lang.Long, java.lang.Long)
	 */
	@Transactional
	public void deleteByAppIdAndAccessTimeRange(Long appId, Long accessTimeStart, Long accessTimeEnd) {
		accessUserMapper.deleteByAppIdAndAccessTimeRange(appId, accessTimeStart, accessTimeEnd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.AccessUserService#load(java.lang.Long,
	 * java.lang.Long)
	 */
	public AccessUserBO load(Long appId, Long auid) {
		return copyPOToBO(accessUserMapper.load(appId, auid));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.AccessUserService#deleteByAppId(java.lang.Long)
	 */
	@Transactional
	public void deleteByAppId(Long appId) {
		accessUserMapper.deleteByAppId(appId);
	}

}
