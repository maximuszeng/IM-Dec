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

import com.eim.service.bo.tag.TagObjectRelationBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;
import com.eim.webapi.vo.tag.TagObjectRelationVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller
@RequestMapping(value = "tag/tor")
public class TagObjectRelationController extends BaseController<TagObjectRelationBO, TagObjectRelationVO> {
	@RequestMapping(value = "new", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO newObjectCategory(@RequestBody TagObjectRelationVO user) {
		LOGGER.info("Creating new user {}", user);
		// username, mail, password should not empty.
		ResultVO result = new ResultVO();
		TagObjectRelationBO bo = copyVOToBO(user);

		tagObjectRelationService.insert(bo);

		return result;
	}

	@RequestMapping(value = "{tagId}/{objectCategoryId}/{objectId}", method = RequestMethod.GET)
	@ResponseBody
	public TagObjectRelationVO get(@PathVariable(value = "tagId") Long tagId,
			@PathVariable(value = "objectCategoryId") Long objectCategoryId,
			@PathVariable(value = "objectId") Long objectId, ModelMap model) {
		TagObjectRelationVO user = copyBOToVO(tagObjectRelationService.load(tagId, objectId, objectCategoryId));
		return user;
	}

	@RequestMapping(value = "update/{uid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "uid") Long uid, @RequestBody TagObjectRelationVO entity) {
		tagObjectRelationService.updateWeight(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{tagId}/{objectCategoryId}/{objectId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "tagId") Long tagId,
			@PathVariable(value = "objectCategoryId") Long objectCategoryId,
			@PathVariable(value = "objectId") Long objectId) {
		tagObjectRelationService.delete(tagId, objectId, objectCategoryId);

	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<TagObjectRelationVO> getAll() {
		LOGGER.info("Listing users");
		ArrayList<TagObjectRelationVO> vos = new ArrayList<TagObjectRelationVO>();
		List<TagObjectRelationBO> bos = tagObjectRelationService.loadAll();
		for (TagObjectRelationBO bo : bos) {
			vos.add(copyBOToVO(bo));
		}
		return new ListVO<TagObjectRelationVO>(vos);
	}

}
