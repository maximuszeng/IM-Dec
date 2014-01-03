package com.eim.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.mapper.base.IPLocationMapper;
import com.eim.persist.po.base.IPLocationPO;
import com.eim.service.base.IPLocationService;
import com.eim.service.bo.base.IPLocationBO;
import com.eim.service.common.BaseService;
import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;
import com.eim.service.thirdparty.interpreter.IPInterpreterServiceManager;

@Service
public class IPLocationServiceImpl extends BaseService<IPLocationBO, IPLocationPO> implements IPLocationService {
	@Autowired
	protected IPLocationMapper IPLocationMapper;
	@Autowired
	protected IPInterpreterServiceManager IPInterpreterServiceManager;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.service.impl.UserService#insert(com.eim.redispro.persist
	 * .domain.UserVo)
	 */
	@Transactional
	public void insert(IPLocationBO bo) {
		// generate uid
		IPLocationMapper.insert(bo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.UserService#delete(java.lang.Long)
	 */
	@Transactional
	public void delete(String ip) {
		IPLocationPO load = IPLocationMapper.load(ip);
		if (load == null) {
			throw new ServiceException(ErrorCodes.IPLOCATION_NOT_EXISTS, ip);
		}
		IPLocationMapper.delete(ip);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.redispro.service.UserService#load(java.lang.Long)
	 */
	public IPLocationBO load(String ip) {
		IPLocationPO po = IPLocationMapper.load(ip);
		if (po == null) {
			// insert
			IPLocationBO translate = IPInterpreterServiceManager.getService().translate(ip);
			if (translate != null) {
				IPLocationMapper.insert(translate);
			} else {
				return null;
			}
		}
		return copyPOToBO(IPLocationMapper.load(ip));
	}

}
