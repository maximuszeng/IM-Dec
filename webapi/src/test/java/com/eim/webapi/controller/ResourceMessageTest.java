/**
 * 
 */
package com.eim.webapi.controller;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author maximus.zeng
 * 
 */
public class ResourceMessageTest {
	public static void main(String[] args) {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("classpath:/META-INF/i18n/error/message");

		System.out.println(source.getMessage("100001", new Object[] { "1111" }, Locale.CHINA));
	}

}
