/**
 * 
 */
package com.eim.service.redis.base;

import static com.eim.service.redis.common.KeyConstants.STAFF_APPIDS_PREFIX;
import static com.eim.service.redis.common.KeyConstants.STAFF_PREFIX;
import static com.eim.service.redis.common.KeyConstants.STAFF_PREFIX_GET_PWD_BY_EMAIL;
import static com.eim.service.redis.common.KeyConstants.STAFF_PREFIX_GET_SUID_BY_EMAIL;
import static com.eim.service.redis.common.KeyConstants.STAFF_PREFIX_GET_SUID_BY_USERNAME;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_CANSERVE;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_EMAIL;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_ISADMIN;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_LASTACTIVEDATE;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_SERVICECONCURRENTLIMITED;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_SERVICEMODE;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_SUID;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_UID;
import static com.eim.service.redis.common.KeyConstants.STAFF_PROPERTY_USERNAME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.eim.service.base.StaffService;
import com.eim.service.bo.base.StaffAppRelationBO;
import com.eim.service.bo.base.StaffBO;
import com.eim.service.redis.common.AbstractOperator;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class StaffOperator extends AbstractOperator<StaffBO> {
	@Autowired
	private StaffService staffService;

	public String getKey(StaffBO staff) {
		return STAFF_PREFIX + staff.getSuid();
	}

	protected void addOneInternal(HashOperations<String, String, String> opsForHash,
			ValueOperations<String, String> opsForValue, StaffBO staff) {

		opsForValue.set(STAFF_PREFIX_GET_SUID_BY_USERNAME + staff.getUserName(), String.valueOf(staff.getSuid()));
		opsForValue.set(STAFF_PREFIX_GET_SUID_BY_EMAIL + staff.getEmail(), String.valueOf(staff.getSuid()));
		opsForValue.set(STAFF_PREFIX_GET_PWD_BY_EMAIL + String.valueOf(staff.getSuid()), staff.getPassword());

		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_USERNAME, staff.getUserName());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_EMAIL, staff.getEmail());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_LASTACTIVEDATE, "" + staff.getLastActiveDate());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_UID, "" + staff.getUid());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_CANSERVE, "" + staff.getCanServe());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_SUID, "" + staff.getSuid());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_ISADMIN, "" + staff.getIsAdmin());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_SERVICEMODE, staff.getServiceMode().name());
		addHashValue(opsForHash, getKey(staff), STAFF_PROPERTY_SERVICECONCURRENTLIMITED,
				"" + staff.getServiceConcurrentLimited());

		List<StaffAppRelationBO> staffAppRelations = staff.getStaffAppRelations();
		
		if (staffAppRelations != null && staffAppRelations.size() > 0) {
			for (StaffAppRelationBO bo : staffAppRelations) {
				opsForHash.put(getAppIDKey(staff), String.valueOf(bo.getAppId()), String.valueOf(bo.getAppId()));
			}
		}
		
	}
	
	public String getAppIDKey(StaffBO staff) {
		return STAFF_APPIDS_PREFIX + staff.getSuid();
	}

	public void deleteOne(StaffBO entity) {
		super.deleteOne(entity);
		template.delete(STAFF_PREFIX_GET_SUID_BY_USERNAME + entity.getUserName());
		template.delete(STAFF_PREFIX_GET_SUID_BY_EMAIL + entity.getEmail());
		template.delete(STAFF_PREFIX_GET_PWD_BY_EMAIL + String.valueOf(entity.getSuid()));
	}

	public void addAll() {
		List<StaffBO> staffs = staffService.loadAll();
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		ValueOperations<String, String> opsForValue = template.opsForValue();
		for (StaffBO staff : staffs) {
			addOneInternal(opsForHash, opsForValue, staff);
		}
	}

	public void addOne(StaffBO staff) {
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		ValueOperations<String, String> opsForValue = template.opsForValue();
		addOneInternal(opsForHash, opsForValue, staff);
	}

	public void deleteAll() {
		super.deleteAll();
		super.deleteAll(STAFF_PREFIX_GET_SUID_BY_USERNAME);
		super.deleteAll(STAFF_PREFIX_GET_SUID_BY_EMAIL);
		super.deleteAll(STAFF_PREFIX_GET_PWD_BY_EMAIL);
	}

	public String getPrefix() {
		return STAFF_PREFIX;
	}

}
