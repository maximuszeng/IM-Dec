/**
 * 
 */
package com.eim.persist.enums;

/**
 * @author jacky.yang
 * 
 */
public enum DialogDirection {
	// SUTOAU, AUTOSU
	STA(0), ATS(1);
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	DialogDirection(Integer id) {
		this.id = id;
	}
}
