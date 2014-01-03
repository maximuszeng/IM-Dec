/**
 * 
 */
package com.eim.webapi.controller.base;

import java.util.ArrayList;
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
import com.eim.service.bo.base.UserBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.base.UserVO;
import com.eim.webapi.vo.base.result.UserVOList;
import com.eim.webapi.vo.common.ResultVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController<UserBO, UserVO> {

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO regist(@RequestBody UserVO user) {
		LOGGER.info("Creating new user {}", user);
		// username, mail, password should not empty.
		UserBO insert = null;
		ResultVO result = new ResultVO();
		UserBO bo = copyVOToBO(user);

		StaffBO sbo = new StaffBO();
		sbo.setEmail(user.getEmail());
		sbo.setPassword(user.getPassword());
		sbo.setUserName(user.getName());

		bo.setAdminStaff(sbo);

		insert = userService.registFreeUser(bo);

		result.setId(insert.getUid());

		return result;
	}

	@RequestMapping(value = "{uid}", method = RequestMethod.GET)
	@ResponseBody
	public UserVO get(@PathVariable(value = "uid") Long uid, ModelMap model) {
		LOGGER.info("Reading user with id {}", uid);
		UserVO user = copyBOToVO(userService.load(uid));
		return user;
	}

	@RequestMapping(value = "update/{uid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "uid") Long uid, @RequestBody UserVO entity) {
		userService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{uid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("uid") Long id) {
		userService.delete(id);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	@ResponseBody
	public UserVOList getAll() {
		LOGGER.info("Listing users");
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		List<UserBO> bos = userService.loadAll();
		for (UserBO bo : bos) {
			vos.add(copyBOToVO(bo));
		}
		return new UserVOList(vos);
	}

}
