/**
 * 
 */
package com.eim.webapi.vo.tag;

import com.eim.webapi.vo.common.BaseVO;

/**
 * @author jacky.yong
 * 
 */
public class TagObjectRelationVO extends BaseVO {
	private Long tagId;
	private Long objectId;
	private Long objectCategoryId;
	private Long weight;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getObjectCategoryId() {
		return objectCategoryId;
	}

	public void setObjectCategoryId(Long objectCategoryId) {
		this.objectCategoryId = objectCategoryId;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

}
