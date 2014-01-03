/**
 * 
 */
package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.ApplicationService;
import com.eim.service.base.StaffService;
import com.eim.service.bo.base.StaffAppRelationBO;
import com.eim.service.bo.base.StaffBO;

/**
 * @author maximus.zeng
 * 
 */
public class StaffServiceTest extends CommonJunitSpringTest {
	@Autowired
	protected StaffService staffService;
	@Autowired
	protected ApplicationService applicationService;
	private int t = 10;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	private StaffBO newStaff(int i) {
		StaffBO au = new StaffBO();
		au.setCanServe(true);
		au.setIsAdmin(true);
		au.setLastActiveDate(new Date().getTime());
		au.setPassword("password");
		au.setUid(1L);
		au.setEmail("jackyyang050" + i + "@hotmail.com");
		au.setUserName("jacky" + i);
		au.setServiceMode(ConcurrentServiceMode.ONETOMANY);
		au.setServiceConcurrentLimited(3);

		List<StaffAppRelationBO> staffAppRelations = new ArrayList<StaffAppRelationBO>();

		List<Long> loadIDsByUID = applicationService.loadIDsByUID(1L);

		for (Long appid : loadIDsByUID) {
			StaffAppRelationBO bo = new StaffAppRelationBO();
			bo.setAppId(appid);
			bo.setCreateTime(new Date().getTime());
			staffAppRelations.add(bo);
		}

		au.setStaffAppRelations(staffAppRelations);

		return au;
	}

	/**
	 * Test method for
	 * {@link com.eim.service.base.StaffService#newApp(com.eim.redispro.persist.domain.StaffBO)}
	 * .
	 */
	@Test
	@Rollback(false)
	public void testInsert() {
		StaffBO newStaff = newStaff(1);
		staffService.newFreeStaff(newStaff);
	}

	/**
	 * Test method for {@link com.eim.service.base.StaffService#load(java.lang.Long)}
	 * .
	 */
	@Test
	public void testLoad() {
		StaffBO load = staffService.load(1L);
		System.out.println(load.getServiceMode());
	}

	/**
	 * Test method for
	 * {@link com.eim.service.base.StaffService#batchInsert(java.util.List)} .
	 */
	@Test
	@Rollback(false)
	public void testBatchInsert() {
		for (int i = 0; i < 100; i++) {
			StaffBO newStaff = newStaff(t++);
			staffService.newFreeStaff(newStaff);
		}

	}

}
