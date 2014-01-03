/**
 * 
 */
package com.eim.webapi.controller.base;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eim.service.bo.base.StaffBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.base.StaffVO;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "staff")
public class StaffController extends BaseController<StaffBO, StaffVO> {

	@RequestMapping(value = "new", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO newStaff(@RequestBody StaffVO staffVO) {
		LOGGER.info("Creating new staff {}", staffVO);
		// username, mail, password should not empty.
		ResultVO result = new ResultVO();
		StaffBO sbo = copyVOToBO(staffVO);

		Long[] canServeAppId = staffVO.getCanServeAppId();
		if (canServeAppId == null || canServeAppId.length == 0) {

		}
		StaffBO insert = staffService.newFreeStaff(sbo);
		result.setId(insert.getSuid());
		return result;
	}

	@RequestMapping(value = "{suid}", method = RequestMethod.GET)
	@ResponseBody
	public StaffVO get(@PathVariable(value = "suid") Long suid, ModelMap model) {
		LOGGER.info("Reading user with id {}", suid);
		StaffVO staff = copyBOToVO(staffService.load(suid));
		return staff;
	}

	@RequestMapping(value = "update/{suid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "suid") Long suid, @RequestBody StaffVO entity) {
		staffService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{suid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("suid") Long suid) {
		staffService.delete(suid);
	}

	@RequestMapping(value = "list/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<StaffVO> getStaffListByUID(@PathVariable("uid") Long uid) {
		List<StaffBO> staffListByUID = staffService.getStaffListByUID(uid);
		ListVO<StaffVO> result = new ListVO<StaffVO>();
		for (StaffBO bo : staffListByUID) {
			result.add(copyBOToVO(bo));
		}
		return result;
	}

}
