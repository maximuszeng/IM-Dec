/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author jacky.yang
 * 
 */
public enum Locale {
	EN_US(0), ZH_CN(1);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	Locale(Integer id) {
		this.id = id;
	}
}
