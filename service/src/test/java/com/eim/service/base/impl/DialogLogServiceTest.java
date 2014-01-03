/**
 * 
 */
package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.eim.persist.enums.ContentType;
import com.eim.persist.enums.DialogDirection;
import com.eim.service.CommonJunitSpringTest;
import com.eim.service.base.AccessUserService;
import com.eim.service.base.ApplicationService;
import com.eim.service.base.DialogLogService;
import com.eim.service.base.SequenceService;
import com.eim.service.base.StaffService;
import com.eim.service.bo.base.AccessUserBO;
import com.eim.service.bo.base.ApplicationBO;
import com.eim.service.bo.base.DialogLogBO;
import com.eim.service.bo.base.StaffBO;

public class DialogLogServiceTest extends CommonJunitSpringTest {
	@Autowired
	protected AccessUserService accessUserService;
	@Autowired
	protected ApplicationService applicationService;
	@Autowired
	protected DialogLogService dialogLogService;
	@Autowired
	protected SequenceService sequenceService;
	@Autowired
	protected StaffService staffService;

	private int t = 10;

	private ApplicationBO applicationBO;
	private AccessUserBO accessUserBO;
	private StaffBO staffBO;

	@Before
	@Rollback(false)
	public void init() {
		applicationBO = applicationService.load(1L);
		accessUserBO = accessUserService.load(1L, 1L);
		staffBO = staffService.load(1L);
	}

	private List<DialogLogBO> newDialogLog(int t) {
		List<DialogLogBO> _LISTS = new ArrayList<DialogLogBO>();

		for (int i = 0; i < t; i++) {
			DialogLogBO au = new DialogLogBO();
			au.setAppId(applicationBO.getAppId());
			au.setAuid(accessUserBO.getAuid());
			au.setContent("content " + i);
			au.setContentType(ContentType.TEXT);
			au.setCreateTime(new Date().getTime()+i);
			au.setDirection(DialogDirection.STA);
			au.setSuid(staffBO.getSuid());
			_LISTS.add(au);
		}
		return _LISTS;
	}

	@Test
	@Rollback(false)
	public void testInsert() {
		List<DialogLogBO> newDialogLog = newDialogLog(100);
		dialogLogService.batchInsert(newDialogLog);
	}

	@Test
	@Rollback(false)
	public void testDelete() {
	}

}
