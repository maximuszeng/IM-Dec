/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author maximus.zeng
 * 
 */
public enum UserType {
	FREE(0), MEMBER(1);

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	UserType(Integer id) {
		this.id = id;
	}

}
