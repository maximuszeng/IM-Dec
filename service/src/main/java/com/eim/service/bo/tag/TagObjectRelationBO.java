/**
 * 
 */
package com.eim.service.bo.tag;

import com.eim.persist.po.tag.TagObjectRelationPO;

/**
 * @author jacky.yong
 * 
 */
@SuppressWarnings("serial")
public class TagObjectRelationBO extends TagObjectRelationPO {
	private TagsBO tags;
	private ObjectCategoryBO objectCategory;

	public TagsBO getTags() {
		return tags;
	}

	public void setTags(TagsBO tags) {
		this.tags = tags;
	}

	public ObjectCategoryBO getObjectCategory() {
		return objectCategory;
	}

	public void setObjectCategory(ObjectCategoryBO objectCategory) {
		this.objectCategory = objectCategory;
	}

}
