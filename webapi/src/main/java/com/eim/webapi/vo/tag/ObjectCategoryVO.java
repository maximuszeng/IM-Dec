/**
 * 
 */
package com.eim.webapi.vo.tag;

import com.eim.webapi.vo.common.BaseVO;

/**
 * @author jacky.yong
 * 
 */
public class ObjectCategoryVO extends BaseVO {
	private Long categoryId;
	private String name;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
