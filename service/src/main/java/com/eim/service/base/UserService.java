/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.UserBO;

/**
 * @author maximus.zeng
 * 
 */
public interface UserService {
	
	@Transactional
	public abstract UserBO registFreeUser(UserBO user);
	
	@Transactional
	public abstract void delete(Long uid);
	
	@Transactional
	public abstract void update(UserBO user);

	public abstract List<UserBO> loadAll();

	public abstract UserBO load(Long uid);

}