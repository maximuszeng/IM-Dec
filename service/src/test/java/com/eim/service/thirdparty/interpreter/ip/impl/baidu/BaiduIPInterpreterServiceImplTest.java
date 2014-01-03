/**
 * 
 */
package com.eim.service.thirdparty.interpreter.ip.impl.baidu;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.bo.base.IPLocationBO;
import com.eim.service.thirdparty.interpreter.ip.IPInterpreterService;

/**
 * @author maximus.zeng
 * 
 */
public class BaiduIPInterpreterServiceImplTest extends CommonJunitSpringTest {
	@Autowired
	protected IPInterpreterService IPInterpreterService;

	@Test
	public void testInsert() {
		IPLocationBO translate = IPInterpreterService.translate("120.204.61.212");
		LOGGER.info(translate.toString());
	}

}
