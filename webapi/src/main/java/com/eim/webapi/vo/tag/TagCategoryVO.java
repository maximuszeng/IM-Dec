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
public class TagCategoryVO extends BaseVO {
	private Long id;
	private String name;
	private String desc;
	private Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
