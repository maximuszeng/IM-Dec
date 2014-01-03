/**
 * 
 */
package com.eim.webapi.controller.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eim.service.base.IPLocationService;
import com.eim.service.bo.base.IPLocationBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.base.IPLocationVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "tool/ip")
public class IPLocationController extends BaseController<IPLocationBO, IPLocationVO> {

	@Autowired
	private IPLocationService IPLocationService;

	@RequestMapping(value = "{ip}", method = RequestMethod.GET)
	@ResponseBody
	public IPLocationVO get(@PathVariable(value = "ip") String ip, ModelMap model) {
		IPLocationVO ipl = copyBOToVO(IPLocationService.load(decodeIP(ip)));
		return ipl;
	}

	@RequestMapping(value = "del/{ip}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("ip") String ip) {
		IPLocationService.delete(ip);
	}

}
