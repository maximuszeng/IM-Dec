/**
 * 
 */
package com.eim.service.tag;

import java.util.List;

import com.eim.service.bo.tag.TagObjectRelationBO;

/**
 * @author maximus.zeng
 * 
 */
public interface TagObjectRelationService {
	void insert(TagObjectRelationBO entity);

	TagObjectRelationBO load(Long tagId, Long objectId, Long objectCategoryId);

	List<TagObjectRelationBO> loadAll();

	void updateWeight(TagObjectRelationBO entity);

	void delete(Long tagId, Long objectId, Long objectCategoryId);

	List<TagObjectRelationBO> loadByObjectId(Long objectCategoryId,
			Long objectId);

	List<TagObjectRelationBO> loadByObjectCategoryId(Long objectCategoryId);

	List<TagObjectRelationBO> loadByTagId(Long tagId);
	
	void batchInsert(List<TagObjectRelationBO> entities);

	void deleteByObjectId(Long objectId, Long objectCategoryId);

	void deleteByObjectCategoryId(Long objectCategoryId);

	void deleteByTagId(Long tagId);
	
}