/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author maximus.zeng
 * 
 */
public enum ConcurrentServiceMode {
	ONETOONE(0), ONETOMANY(1);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	ConcurrentServiceMode(Integer id) {
		this.id = id;
	}
}
