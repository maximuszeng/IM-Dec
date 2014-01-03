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

import com.eim.service.bo.tag.TagsBO;
import com.eim.webapi.controller.common.BaseController;
import com.eim.webapi.vo.common.ListVO;
import com.eim.webapi.vo.common.ResultVO;
import com.eim.webapi.vo.tag.TagsVO;

/**
 * @author maximus.zeng
 * 
 */
@Controller	
@RequestMapping(value = "tag/tags")
public class TagsController extends BaseController<TagsBO, TagsVO> {
	@RequestMapping(value = "new", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO newTags(@RequestBody TagsVO tags) {
		LOGGER.info("Creating newObjectCategory {}", tags);
		ResultVO result = new ResultVO();
		TagsBO bo = copyVOToBO(tags);

		bo = tagsService.insert(bo);

		result.setId(bo.getId());

		return result;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public TagsVO get(@PathVariable(value = "id") Long id, ModelMap model) {
		LOGGER.info("Reading tags with id {}", id);
		TagsVO tags = copyBOToVO(tagsService.load(id));
		return tags;
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "id") Long id, @RequestBody TagsVO entity) {
		tagsService.update(copyVOToBO(entity));
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		tagsService.delete(id);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	@ResponseBody
	public ListVO<TagsVO> getAll() {
		LOGGER.info("Listing users");
		ArrayList<TagsVO> vos = new ArrayList<TagsVO>();
		List<TagsBO> bos = tagsService.loadAll();
		for (TagsBO bo : bos) {
			vos.add(copyBOToVO(bo));
		}
		return new ListVO<TagsVO>(vos);
	}

}
