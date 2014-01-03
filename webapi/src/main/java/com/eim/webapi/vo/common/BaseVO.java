/**
 * 
 */
package com.eim.webapi.vo.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author maximus.zeng
 * 
 */
public class BaseVO {
	public static Boolean isTrueForSwitch(String value) {
		return StringUtils.equalsIgnoreCase(value, "on");
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
