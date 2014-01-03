/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author maximus.zeng
 * 
 */
public enum AppType {
	WEB(0), IOS(1), ANDORID(2);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	AppType(Integer id) {
		this.id = id;
	}
}
