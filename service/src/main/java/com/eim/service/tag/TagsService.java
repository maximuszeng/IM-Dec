/**
 * 
 */
package com.eim.service.tag;

import java.util.List;

import com.eim.service.bo.tag.TagsBO;

/**
 * @author maximus.zeng
 * 
 */
public interface TagsService {
	TagsBO insert(TagsBO entity);

	TagsBO load(Long pk);

	List<TagsBO> loadAll();

	void update(TagsBO entity);

	void delete(Long pk);
	
	List<TagsBO> batchInsert(List<TagsBO> entities);

}