/**
 * 
 */
package com.eim.service.bo.tag;

import com.eim.persist.po.tag.TagsPO;

/**
 * @author jacky.yong
 * 
 */
@SuppressWarnings("serial")
public class TagsBO extends TagsPO {
	public static final String SEQUENCE_NAME = "TAG_TAGS_ID";
	private TagCategoryBO tagCategory;

	public TagCategoryBO getTagCategory() {
		return tagCategory;
	}

	public void setTagCategory(TagCategoryBO tagCategory) {
		this.tagCategory = tagCategory;
	}

}
