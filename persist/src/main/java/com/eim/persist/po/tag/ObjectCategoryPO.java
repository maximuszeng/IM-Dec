/**
 * 
 */
package com.eim.persist.po.tag;

import java.io.Serializable;

import com.eim.persist.po.common.BasePO;

/**
 * @author maximus.zeng
 * 
 */
@SuppressWarnings("serial")
public class ObjectCategoryPO extends BasePO implements Serializable {
	private Long id;
	private String name;
	private String description;
	private Long createDate;
	private Long lastUpdateDate;

	public Long getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
