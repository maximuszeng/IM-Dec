/**
 * 
 */
package com.eim.service.tag;

import java.util.List;

import com.eim.service.bo.tag.TagCategoryBO;

/**
 * @author maximus.zeng
 * 
 */
public interface TagCategoryService {
	TagCategoryBO insert(TagCategoryBO entity);

	TagCategoryBO load(Long pk);

	List<TagCategoryBO> loadAll();

	void update(TagCategoryBO entity);

	void delete(Long pk);

}