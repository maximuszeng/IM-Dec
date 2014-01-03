package com.eim.webapi.common;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 
 * @author maximus.zeng
 * 
 */
public class LogbackConfigListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(LogbackConfigListener.class);

	private static final String CONFIG_LOCATION = "logbackConfigLocation";

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String logbackConfigLocation = event.getServletContext().getInitParameter(CONFIG_LOCATION);

		try {
			ClassPathResource resource = new ClassPathResource(logbackConfigLocation);
			String fn = resource.getFile().getAbsolutePath();
			LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
			loggerContext.reset();
			JoranConfigurator joranConfigurator = new JoranConfigurator();
			joranConfigurator.setContext(loggerContext);
			joranConfigurator.doConfigure(fn);
			logger.debug("loaded slf4j configure file from {}", fn);
		} catch (JoranException e) {
			logger.error("can loading slf4j configure file from " + logbackConfigLocation, e);
		} catch (IOException e) {
			logger.error("can loading slf4j configure file from " + logbackConfigLocation, e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}