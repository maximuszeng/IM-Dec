package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class AccessUserPO extends BasePO implements Serializable {
	public static final String SEQUENCE_NAME = "AUID";
	private Long appId;
	private Long auid;
	private String ipAddress;
	private String name;
	private String email;
	private String mobile;
	private Long accessTime;
	private String sessionId;
	private String acceptLanguage;
	private String userAgent;
	private String referer;

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Long getAuid() {
		return auid;
	}

	public void setAuid(Long auid) {
		this.auid = auid;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
