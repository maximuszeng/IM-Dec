/**
 * 
 */
package com.eim.webapi.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

/**
 * @author maximus.zeng
 * 
 */
public class RequestParameterLocaleResolver extends AbstractLocaleResolver {

	public static final String DEFAULT_PARAM_NAME = "lang";

	private String paramName = DEFAULT_PARAM_NAME;

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return this.paramName;
	}

	public Locale resolveLocale(HttpServletRequest request) {
		String newLocale = request.getParameter(this.paramName);
		if (newLocale != null) {
			return StringUtils.parseLocaleString(newLocale);
		}
		return getDefaultLocale();
	}

	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		
	}

}
