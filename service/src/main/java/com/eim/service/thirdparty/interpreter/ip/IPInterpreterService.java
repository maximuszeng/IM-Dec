/**
 * 
 */
package com.eim.service.thirdparty.interpreter.ip;

import com.eim.service.bo.base.IPLocationBO;

/**
 * @author maximus.zeng
 * 
 */
public interface IPInterpreterService {
	IPLocationBO translate(String ip);

	String getName();
}
