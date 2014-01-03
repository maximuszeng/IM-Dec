/**
 * 
 */
package com.eim.webapi.controller.tag;

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

import com.eim.service.bo.tag.ObjectCategoryBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;
import com.eim.webapi.vo.tag.ObjectCategoryVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "tag/oc")
public class ObjectCategoryController extends BaseController<ObjectCategoryBO, ObjectCategoryVO> {
	@RequestMapping(value = "new", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO newObjectCategory(@RequestBody ObjectCategoryVO user) {
		LOGGER.info("Creating new user {}", user);
		// username, mail, password should not empty.
		ObjectCategoryBO insert = null;
		ResultVO result = new ResultVO();

		insert = objectCategoryService.insert(copyVOToBO(user));

		result.setId(insert.getCategoryId());

		return result;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ObjectCategoryVO get(@PathVariable(value = "id") Long id, ModelMap model) {
		LOGGER.info("Reading ObjectCategoryVO with id {}", id);
		ObjectCategoryVO user = copyBOToVO(objectCategoryService.load(id));
		return user;
	}

	@RequestMapping(value = "update/{uid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "uid") Long uid, @RequestBody ObjectCategoryVO entity) {
		objectCategoryService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{uid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("uid") Long id) {
		objectCategoryService.delete(id);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<ObjectCategoryVO> getAll() {
		LOGGER.info("Listing users");
		ArrayList<ObjectCategoryVO> vos = new ArrayList<ObjectCategoryVO>();
		List<ObjectCategoryBO> bos = objectCategoryService.loadAll();
		for (ObjectCategoryBO bo : bos) {
			vos.add(copyBOToVO(bo));
		}
		return new ListVO<ObjectCategoryVO>(vos);
	}

}
