/**
 * 
 */
package com.eim.service.redis.base;

import static com.eim.service.redis.common.KeyConstants.USER_PREFIX;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_CREATEDATE;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_LOGOURL;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_SERVICECONCURRENTLIMITED;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_SERVICEMODE;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_STAFFLIMITED;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_STAFFUSED;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_UID;
import static com.eim.service.redis.common.KeyConstants.USER_PROPERTY_USERTYPE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.eim.service.base.UserService;
import com.eim.service.bo.base.UserBO;
import com.eim.service.redis.common.AbstractOperator;

/**
 * User Redis Operator
 * 
 * @author maximus.zeng
 * 
 */
@Service
public class UserOperator extends AbstractOperator<UserBO> {
	@Autowired
	private UserService userService;

	public String getKey(UserBO user) {
		return USER_PREFIX + user.getUid();
	}

	public void addAll() {
		List<UserBO> users = userService.loadAll();
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		for (UserBO user : users) {
			addOneInternal(opsForHash, user);
		}
	}

	public void deleteOne(UserBO entity) {
		super.deleteOne(entity);
	}

	protected void addOneInternal(HashOperations<String, String, String> opsForHash, UserBO user) {
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_UID, "" + user.getUid());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_LOGOURL, user.getLogoUrl());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_USERTYPE, user.getUserType().name());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_CREATEDATE, "" + user.getCreateDate());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_STAFFLIMITED, "" + user.getStaffLimited());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_STAFFUSED, "" + user.getStaffUsed());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_SERVICEMODE, user.getServiceMode().name());
		addHashValue(opsForHash, getKey(user), USER_PROPERTY_SERVICECONCURRENTLIMITED,
				"" + user.getServiceConcurrentLimited());
	}

	public void addOne(UserBO user) {
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		addOneInternal(opsForHash, user);
	}

	public String getPrefix() {
		return USER_PREFIX;
	}

}
