/**
 * 
 */
package com.eim.service.base;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.IPLocationBO;

/**
 * @author maximus.zeng
 * 
 */
public interface IPLocationService {

	public IPLocationBO load(String ip);

	@Transactional
	public void delete(String ip);
}