/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.AccessUserBO;

/**
 * @author maximus.zeng
 * 
 */
public interface AccessUserService {

	public List<AccessUserBO> loadByAppIdAndAccessTimeRange(Long appId, Long accessTimeStart, Long accessTimeEnd);

	public AccessUserBO load(Long appId, Long auid);

	@Transactional
	public AccessUserBO insert(AccessUserBO accessUser);

	@Transactional
	public void delete(Long appId, Long auid);

	@Transactional
	public void deleteByAppId(Long appId);

	@Transactional
	public void deleteByAppIdAndAccessTimeRange(Long appId, Long accessTimeStart, Long accessTimeEnd);

	@Transactional
	public void update(AccessUserBO entity);

}