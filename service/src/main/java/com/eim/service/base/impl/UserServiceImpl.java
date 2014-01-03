package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.persist.enums.UserType;
import com.eim.persist.po.base.UserPO;
import com.eim.service.base.StaffService;
import com.eim.service.base.UserService;
import com.eim.service.bo.base.StaffBO;
import com.eim.service.bo.base.UserBO;
import com.eim.service.common.BaseService;
import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;

@Service
public class UserServiceImpl extends BaseService<UserBO, UserPO> implements UserService {
	@Value("#{serviceConfig['user.default.stafflimited']}")
	private Integer defaultStaffLimited;

	@Value("#{serviceConfig['user.default.service.concurrent.limited']}")
	private Integer defaultServiceConcurrentLimited;
	@Autowired
	private StaffService staffService;

	@Transactional
	public UserBO registFreeUser(UserBO userBO) {
		// insert UserPO
		UserPO userPO = userBO;
		userPO.setCreateDate(new Date().getTime());
		userPO.setStaffLimited(defaultStaffLimited);
		userPO.setStaffUsed(0);
		// default is free
		userPO.setUserType(UserType.FREE);
		userPO.setServiceConcurrentLimited(defaultServiceConcurrentLimited);
		userPO.setServiceMode(ConcurrentServiceMode.ONETOMANY);

		StaffBO staffBO = userBO.getAdminStaff();

		// check if username/email available
		staffService.checkUserNameIsUnique(staffBO.getUserName());
		staffService.checkEmailIsUnique(staffBO.getEmail());
		
		// generate uid
		userBO.setUid(sequenceService.getNextId(UserPO.SEQUENCE_NAME));
		userMapper.insert(userPO);

		staffBO.setUid(userBO.getUid());
		staffService.newFreeStaff(staffBO, false);

		userOperator.addOne(userBO);
		// after insert, invoke redis operator
		return userBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.impl.UserService#loadAll()
	 */
	public List<UserBO> loadAll() {
		List<UserPO> ups = userMapper.loadAll();
		List<UserBO> ubs = new ArrayList<UserBO>();
		for (UserPO user : ups) {
			ubs.add(copyPOToBO(user));
		}
		return ubs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.service.UserService#update(com.eim.redispro.vo.UserVo)
	 */
	@Transactional
	public void update(UserBO user) {

		UserPO userPo = userMapper.load(user.getUid());
		if (userPo == null) {
			throw new ServiceException(ErrorCodes.USER_NOT_EXISTS_UID, user.getUid());
		}

		userMapper.update(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.UserService#delete(java.lang.Long)
	 */
	@Transactional
	public void delete(Long uid) {
		UserPO userPo = userMapper.load(uid);
		if (userPo == null) {
			throw new ServiceException(ErrorCodes.USER_NOT_EXISTS_UID, uid);
		}
		// find all appid
		List<Long> loadIDsByUID = applicationMapper.loadIDsByUID(uid);

		for (Long appId : loadIDsByUID) {
			// delete all dialoglog
			dialogLogMapper.deleteByAppId(uid);
			// delete all accessuser
			accessUserMapper.deleteByAppId(appId);
		}
		applicationMapper.deleteByUID(uid);

		// delete all staff
		staffMapper.deleteByUID(uid);
		// TODO delete from redis
		// delete user
		userMapper.delete(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.UserService#load(java.lang.Long)
	 */
	public UserBO load(Long uid) {
		UserPO userPo = userMapper.load(uid);
		if (userPo == null) {
			throw new ServiceException(ErrorCodes.USER_NOT_EXISTS_UID, uid);
		}
		return copyPOToBO(userMapper.load(uid));
	}

}
