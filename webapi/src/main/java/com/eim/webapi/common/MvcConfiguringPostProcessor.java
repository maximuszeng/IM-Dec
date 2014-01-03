/**
 * 
 */
package com.eim.webapi.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 * @author maximus.zeng
 * 
 */
public class MvcConfiguringPostProcessor implements BeanPostProcessor {

	/**
	 * Enable pretty print on any bean of type
	 * {@link MappingJacksonHttpMessageConverter} or
	 * {@link MappingJackson2HttpMessageConverter}.
	 */
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		if (bean instanceof HttpMessageConverter<?>)
			if (bean instanceof MappingJacksonHttpMessageConverter) {
				((MappingJacksonHttpMessageConverter) bean).setPrettyPrint(true);
			} else if (bean instanceof MappingJackson2HttpMessageConverter) {
				((MappingJackson2HttpMessageConverter) bean).setPrettyPrint(true);
			}

		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}