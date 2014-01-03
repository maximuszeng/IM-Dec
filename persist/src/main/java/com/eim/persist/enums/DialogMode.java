/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author maximus.zeng
 * 
 */
public enum DialogMode {
	// SUTOAU, AUTOSU
	ROBOT(0), MANUAL(1);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	DialogMode(Integer id) {
		this.id = id;
	}

}
