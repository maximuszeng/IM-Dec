/**
 * 
 */
package com.eim.service.thirdparty.interpreter.ip.impl;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;
import com.eim.service.thirdparty.interpreter.IPInterpreterServiceManager;
import com.eim.service.thirdparty.interpreter.ip.IPInterpreterService;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class IPInterpreterServiceManagerImpl implements IPInterpreterServiceManager {
	@Autowired
	private Set<IPInterpreterService> providers;

	@Value("#{serviceConfig['ipinterpreter.provider']}")
	private String defaultProviderName;

	/* (non-Javadoc)
	 * @see com.eim.service.thirdparty.interpreter.IPInterpreterServiceManager#getService()
	 */
	@Override
	public IPInterpreterService getService() {
		return getService(defaultProviderName);
	}

	/* (non-Javadoc)
	 * @see com.eim.service.thirdparty.interpreter.IPInterpreterServiceManager#getService(java.lang.String)
	 */
	@Override
	public IPInterpreterService getService(String name) {
		for (IPInterpreterService service : providers) {
			if (StringUtils.equalsIgnoreCase(service.getName(), name)) {
				return service;
			}
		}
		throw new ServiceException(ErrorCodes.IPINTERPRETER_SERVICE_NOT_FOUND, name);
	}

}
