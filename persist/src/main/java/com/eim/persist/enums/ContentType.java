/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author jacky.yang
 * 
 */
public enum ContentType {
	TEXT(0), IMAGE(1), AUDIO(2);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	ContentType(Integer id) {
		this.id = id;
	}
}
