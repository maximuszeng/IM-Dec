/**
 * 
 */
package com.eim.persist.po.tag;

import java.io.Serializable;

import com.eim.persist.po.common.BasePO;

/**
 * @author jacky.yong
 * 
 */
@SuppressWarnings("serial")
public class ObjectCategoryPO extends BasePO implements Serializable {
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
