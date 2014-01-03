/**
 * 
 */
package com.eim.service.base.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.IPLocationService;
import com.eim.service.bo.base.IPLocationBO;

/**
 * @author maximus.zeng
 * 
 */
public class IPLocationServiceImplTest extends CommonJunitSpringTest {
	@Autowired
	protected IPLocationService IPLocationService;

	@Test
	public void testInsert() {
		try {
			IPLocationBO translate = IPLocationService.load("120.204.61.212");
			LOGGER.info(translate.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
