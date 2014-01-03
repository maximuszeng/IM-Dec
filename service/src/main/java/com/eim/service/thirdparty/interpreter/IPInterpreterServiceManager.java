/**
 * 
 */
package com.eim.service.thirdparty.interpreter;

import com.eim.service.thirdparty.interpreter.ip.IPInterpreterService;

/**
 * @author maximus.zeng
 * 
 */
public interface IPInterpreterServiceManager {

	public abstract IPInterpreterService getService();

	public abstract IPInterpreterService getService(String name);

}