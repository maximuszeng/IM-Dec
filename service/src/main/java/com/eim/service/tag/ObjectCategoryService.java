/**
 * 
 */
package com.eim.service.tag;

import java.util.List;

import com.eim.service.bo.tag.ObjectCategoryBO;

/**
 * @author maximus.zeng
 * 
 */
public interface ObjectCategoryService {
	ObjectCategoryBO insert(ObjectCategoryBO entity);

	ObjectCategoryBO load(Long pk);

	List<ObjectCategoryBO> loadAll();

	void update(ObjectCategoryBO entity);

	void delete(Long pk);

}