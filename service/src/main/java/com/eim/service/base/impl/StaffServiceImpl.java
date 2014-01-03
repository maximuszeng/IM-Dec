package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.persist.mapper.base.ApplicationMapper;
import com.eim.persist.mapper.base.DialogLogMapper;
import com.eim.persist.mapper.base.StaffAppRelationMapper;
import com.eim.persist.mapper.base.StaffMapper;
import com.eim.persist.mapper.base.UserMapper;
import com.eim.persist.po.base.StaffAppRelationPO;
import com.eim.persist.po.base.StaffPO;
import com.eim.persist.po.base.UserPO;
import com.eim.service.base.SequenceService;
import com.eim.service.base.StaffService;
import com.eim.service.bo.base.StaffAppRelationBO;
import com.eim.service.bo.base.StaffBO;
import com.eim.service.common.BaseService;
import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;
import com.eim.service.redis.base.StaffOperator;
import com.eim.service.redis.base.UserOperator;

@Service
public class StaffServiceImpl extends BaseService<StaffBO, StaffPO> implements StaffService {
	@Autowired
	protected SequenceService sequenceService;
	@Autowired
	protected StaffMapper staffMapper;
	@Autowired
	protected UserMapper userMapper;
	@Autowired
	protected ApplicationMapper applicationMapper;
	@Autowired
	protected DialogLogMapper dialogLogMapper;
	@Autowired
	protected StaffAppRelationMapper staffAppRelationMapper;
	@Autowired
	protected StaffOperator staffOperator;
	@Autowired
	protected UserOperator userOperator;

	@Value("#{serviceConfig['user.default.stafflimited']}")
	private Integer defaultStaffLimited;

	@Value("#{serviceConfig['user.default.service.concurrent.limited']}")
	private Integer defaultServiceConcurrentLimited;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.impl.StaffService#load(java.lang.Long)
	 */
	public StaffBO load(Long suid) {
		StaffPO staffPO = staffMapper.load(suid);
		if (staffPO == null) {
			throw new ServiceException(ErrorCodes.STAFF_NOT_EXISTS_SUID, suid);
		}
		return copyPOToBO(staffPO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.impl.StaffService#loadAll()
	 */
	public List<StaffBO> loadAll() {
		List<StaffBO> ubs = new ArrayList<StaffBO>();

		List<StaffPO> loadAll = staffMapper.loadAll();

		for (StaffPO staff : loadAll) {
			ubs.add(copyPOToBO(staff));
		}

		return ubs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#delete(java.lang.Long)
	 */
	@Transactional
	public void delete(Long suid) {
		StaffPO staffPO = staffMapper.load(suid);
		if (staffPO == null) {
			throw new ServiceException(ErrorCodes.STAFF_NOT_EXISTS_SUID, suid);
		}
		dialogLogMapper.deleteBySuId(suid);
		staffMapper.delete(suid);
		userMapper.updateStaffUsedAfterNewStaffDeleted(staffPO.getUid());
		staffOperator.deleteOne(super.copyPOToBO(staffPO));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#update(com.eim.bo.StaffBO)
	 */
	@Transactional
	public void update(StaffBO staff) {
		checkStaffBONotNull(staff);
		checkUserNameIsUnique(staff.getUserName());
		checkEmailIsUnique(staff.getEmail());
		StaffPO load = staffMapper.load(staff.getSuid());
		if (load == null) {
			throw new ServiceException(ErrorCodes.STAFF_NOT_EXISTS_SUID, staff.getSuid());
		}
		staffMapper.update(staff);
		staffOperator.addOne(staff);
	}

	private void checkStaffBONotNull(StaffBO staff) {
		if (staff == null) {
			throw new ServiceException(ErrorCodes.STAFF_NOT_EXISTS_SUID);
		}
	}

	public void checkUserNameIsUnique(String userName) {
		// check username
		StaffPO loadByUserName = staffMapper.loadByUserName(userName);
		if (loadByUserName != null) {
			throw new ServiceException(ErrorCodes.STAFF_CONFLICT_USERNAME, userName);
		}
	}

	public void checkEmailIsUnique(String email) {
		// check email
		StaffPO loadByEmail = staffMapper.loadByEmail(email);
		if (loadByEmail != null) {
			throw new ServiceException(ErrorCodes.STAFF_CONFLICT_EMAIL, email);
		}
	}

	public void checkStaffQuantityIsNotExceeds(Long uid) {
		// check limited
		UserPO userPO = userMapper.load(uid);
		if (userPO != null && userPO.getStaffUsed() >= userPO.getStaffLimited()) {
			throw new ServiceException(ErrorCodes.STAFF_LIMITED_QUANTITY_EXCEEDS);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#regist(com.eim.bo.StaffBO)
	 */
	@Transactional
	public StaffBO newFreeStaff(StaffBO staffBO, boolean checkUnique) {
		checkStaffBONotNull(staffBO);
		Long uid = staffBO.getUid();
		checkStaffQuantityIsNotExceeds(uid);

		if (checkUnique) {
			checkUserNameIsUnique(staffBO.getUserName());
			checkEmailIsUnique(staffBO.getEmail());
		}

		staffBO.setCanServe(true);
		staffBO.setIsAdmin(true);
		staffBO.setCreateDate(new Date().getTime());
		staffBO.setServiceConcurrentLimited(defaultServiceConcurrentLimited);
		staffBO.setServiceMode(ConcurrentServiceMode.ONETOMANY);
		staffBO.setPassword(DigestUtils.md5DigestAsHex(staffBO.getPassword().getBytes()).toUpperCase());

		Long nextId = sequenceService.getNextId(StaffPO.SEQUENCE_NAME);
		staffBO.setSuid(nextId);

		userMapper.updateStaffUsedAfterNewStaffCreated(uid);
		staffMapper.insert(staffBO);

		// insert staffAppRelations
		List<StaffAppRelationBO> staffAppRelationBOS = staffBO.getStaffAppRelations();
		if (staffAppRelationBOS == null || staffAppRelationBOS.size() == 0) {

			List<Long> loadIDsByUID = applicationMapper.loadIDsByUID(uid);
			if (loadIDsByUID != null && loadIDsByUID.size() > 0) {
				staffAppRelationBOS = new ArrayList<StaffAppRelationBO>();

				for (Long appid : loadIDsByUID) {
					StaffAppRelationBO staffAppRelationBO = new StaffAppRelationBO();
					staffAppRelationBO.setAppId(appid);
					staffAppRelationBOS.add(staffAppRelationBO);
				}
			}
		}

		if (staffAppRelationBOS != null && staffAppRelationBOS.size() > 0) {
			List<StaffAppRelationPO> staffAppRelationPOS = new ArrayList<StaffAppRelationPO>();

			for (StaffAppRelationBO bo : staffAppRelationBOS) {
				bo.setSuid(nextId);
				staffAppRelationPOS.add(bo);
			}

			staffAppRelationMapper.batchInsert(staffAppRelationPOS);
		}

		staffOperator.addOne(staffBO);
		return staffBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#deleteByUID(java.lang.Long)
	 */
	@Transactional
	public void deleteByUID(Long uid) {
		List<Long> loadIDsByUID = staffMapper.loadIDsByUID(uid);
		for (Long suid : loadIDsByUID) {
			dialogLogMapper.deleteBySuId(suid);
			staffMapper.delete(suid);
		}

		userMapper.updateStaffUsedToZero(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#newFreeStaff(com.eim.bo.StaffBO)
	 */
	@Transactional
	public StaffBO newFreeStaff(StaffBO staff) {
		return this.newFreeStaff(staff, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.StaffService#getStaffListByUID(java.lang.Long)
	 */
	public List<StaffBO> getStaffListByUID(Long uid) {
		List<StaffPO> staffPOS = staffMapper.loadByUID(uid);
		List<StaffBO> ubs = new ArrayList<StaffBO>();

		for (StaffPO staff : staffPOS) {
			ubs.add(copyPOToBO(staff));
		}
		return ubs;
	}

}
