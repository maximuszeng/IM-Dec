/**
 * 
 */
package com.eim.webapi.vo.tag;

import com.eim.persist.enums.Locale;
import com.eim.webapi.vo.common.BaseVO;

/**
 * @author jacky.yong
 * 
 */
public class TagsVO extends BaseVO {
	private Long id;
	private String name;
	private Locale locale;
	private Long categoryId;
	private Long weight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

}
