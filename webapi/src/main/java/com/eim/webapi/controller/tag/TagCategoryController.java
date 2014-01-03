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

import com.eim.service.bo.tag.TagCategoryBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;
import com.eim.webapi.vo.tag.TagCategoryVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "tag/tc")
public class TagCategoryController extends BaseController<TagCategoryBO, TagCategoryVO> {
	@RequestMapping(value = "new", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO newObjectCategory(@RequestBody TagCategoryVO user) {
		LOGGER.info("Creating new user {}", user);
		// username, mail, password should not empty.
		TagCategoryBO insert = null;
		ResultVO result = new ResultVO();
		TagCategoryBO bo = copyVOToBO(user);

		insert = tagCategoryService.insert(bo);

		result.setId(insert.getId());

		return result;
	}

	@RequestMapping(value = "{uid}", method = RequestMethod.GET)
	@ResponseBody
	public TagCategoryVO get(@PathVariable(value = "uid") Long uid, ModelMap model) {
		LOGGER.info("Reading user with id {}", uid);
		TagCategoryVO user = copyBOToVO(tagCategoryService.load(uid));
		return user;
	}

	@RequestMapping(value = "update/{uid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "uid") Long uid, @RequestBody TagCategoryVO entity) {
		tagCategoryService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{uid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("uid") Long id) {
		tagCategoryService.delete(id);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<TagCategoryVO> getAll() {
		LOGGER.info("Listing users");
		ArrayList<TagCategoryVO> vos = new ArrayList<TagCategoryVO>();
		List<TagCategoryBO> bos = tagCategoryService.loadAll();
		for (TagCategoryBO bo : bos) {
			vos.add(copyBOToVO(bo));
		}
		return new ListVO<TagCategoryVO>(vos);
	}

}
