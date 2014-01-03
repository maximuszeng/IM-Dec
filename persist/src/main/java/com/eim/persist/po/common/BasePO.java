/**
 * 
 */
package com.eim.persist.po.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author maximus.zeng
 * 
 */
public abstract class BasePO {

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
