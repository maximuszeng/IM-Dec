/**
 * 
 */
package com.eim.webapi.controller.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eim.service.bo.base.AccessUserBO;
import com.eim.service.bo.base.IPLocationBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.base.AccessUserVO;
import com.eim.webapi.vo.base.IPLocationVO;
import com.eim.webapi.vo.base.result.AccessUserResultVO;

/**
 * AccessUser Controller
 * 
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "au")
public class AccessUserController extends BaseController<AccessUserBO, AccessUserVO> {
	/**
	 * Process AccessUser request when enter(First Time)
	 * 
	 * @param staffVO
	 * @return
	 */
	@RequestMapping(value = "enter", method = RequestMethod.POST)
	@ResponseBody
	public AccessUserResultVO enter(@RequestBody AccessUserVO accessUserVO) {
		LOGGER.info("Creating new accessUserVO {}", accessUserVO);
		// username, mail, password should not empty.
		AccessUserResultVO result = new AccessUserResultVO();
		AccessUserBO sbo = copyVOToBO(accessUserVO);
		AccessUserBO insert = accessUserService.insert(sbo);

		if (StringUtils.isNotBlank(accessUserVO.getIpAddress())) {
			IPLocationBO ipLocationBO = IPLocationService.load(decodeIP(accessUserVO.getIpAddress()));
			if (ipLocationBO != null) {
				IPLocationVO iPLocationVO = new IPLocationVO();
				BeanUtils.copyProperties(ipLocationBO, iPLocationVO);
				result.setIpLocationVO(iPLocationVO);
			}
		}

		result.setId(insert.getAuid());
		return result;
	}

	@RequestMapping(value = "/{appid}/{suid}", method = RequestMethod.GET)
	@ResponseBody
	public AccessUserVO get(@PathVariable(value = "appid") Long appid, @PathVariable(value = "auid") Long auid,
			ModelMap model) {
		LOGGER.info("Reading access user with id {}", auid);
		AccessUserVO staff = copyBOToVO(accessUserService.load(appid, auid));
		return staff;
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@RequestBody AccessUserVO entity) {
		accessUserService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "appid") Long appid, @PathVariable(value = "auid") Long auid) {
		accessUserService.delete(appid, auid);
	}

}
