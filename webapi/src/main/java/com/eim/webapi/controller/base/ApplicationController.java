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

import com.eim.service.bo.base.ApplicationBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.base.ApplicationVO;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "app")
public class ApplicationController extends BaseController<ApplicationBO, ApplicationVO> {
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO regist(@RequestBody ApplicationVO applicationVO) {
		LOGGER.info("Creating new applicationVO {}", applicationVO);
		// username, mail, password should not empty.
		ResultVO result = new ResultVO();
		ApplicationBO sbo = copyVOToBO(applicationVO);
		ApplicationBO insert = applicationService.newApp(sbo);
		result.setId(insert.getAppId());
		return result;
	}

	@RequestMapping(value = "{appid}", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationVO get(@PathVariable(value = "appid") Long appid, ModelMap model) {
		LOGGER.info("Reading app with id {}", appid);
		ApplicationVO app = copyBOToVO(applicationService.load(appid));
		return app;
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@RequestBody ApplicationVO entity) {
		applicationService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{appid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("appid") Long appid) {
		applicationService.delete(appid);
	}

	@RequestMapping(value = "list/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<ApplicationVO> getAppListByUID(@PathVariable("uid") Long uid) {
		List<ApplicationBO> appListByUID = applicationService.getAppListByUID(uid);
		ListVO<ApplicationVO> result = new ListVO<ApplicationVO>();
		for (ApplicationBO bo : appListByUID) {
			result.add(copyBOToVO(bo));
		}
		return result;
	}

}
