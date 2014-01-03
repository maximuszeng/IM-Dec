/**
 * 
 */
package com.eim.persist.mapper.tag;

import java.util.List;

import com.eim.persist.po.tag.TagObjectRelationPO;

/**
 * @author maximus.zeng
 * 
 */
public interface TagObjectRelationMapper {

	TagObjectRelationPO load(Long tagId, Long objectId, Long objectCategoryId);

	List<TagObjectRelationPO> loadByObjectId(Long objectCategoryId,
			Long objectId);

	List<TagObjectRelationPO> loadByObjectCategoryId(Long objectCategoryId);

	List<TagObjectRelationPO> loadByTagId(Long tagId);

	List<TagObjectRelationPO> loadAll();

	void insert(TagObjectRelationPO entity);

	void batchInsert(List<? extends TagObjectRelationPO> entities);

	void updateWeight(TagObjectRelationPO entity);

	void delete(Long tagId, Long objectId, Long objectCategoryId);

	void deleteByObjectId(Long objectId, Long objectCategoryId);

	void deleteByObjectCategoryId(Long objectCategoryId);

	void deleteByTagId(Long tagId);

}
