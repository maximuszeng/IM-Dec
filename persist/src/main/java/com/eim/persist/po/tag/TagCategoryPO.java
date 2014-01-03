/**
 * 
 */
package com.eim.persist.po.tag;

import java.io.Serializable;

import com.eim.persist.enums.Locale;
import com.eim.persist.po.common.BasePO;

/**
 * @author jacky.yong
 * 
 */
@SuppressWarnings("serial")
public class TagCategoryPO extends BasePO implements Serializable {
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
