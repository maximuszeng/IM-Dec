package com.eim.webapi.vo.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eim.webapi.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "u")
public class AccessUserVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -518128477815180710L;
	private Long appId;
	private Long auid;
	private String name;
	private String email;
	private String mobile;
	private Long accessTime;
	private String sessionId;

	// HTTP Headers
	// Client
	private String acceptLanguage;
	private String userAgent;
	private String referer;
	private String ipAddress;

	@JsonProperty("appId")
	public Long getAppId() {
		return appId;
	}

	@XmlElement(name = "appId")
	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@JsonProperty("auid")
	public Long getAuid() {
		return auid;
	}

	@XmlElement(name = "auid")
	public void setAuid(Long auid) {
		this.auid = auid;
	}

	@JsonProperty("ipAddress")
	public String getIpAddress() {
		return ipAddress;
	}

	@XmlElement(name = "ipAddress")
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("mobile")
	public String getMobile() {
		return mobile;
	}

	@XmlElement(name = "mobile")
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonProperty("accessTime")
	public Long getAccessTime() {
		return accessTime;
	}

	@XmlElement(name = "accessTime")
	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	@JsonProperty("sessionId")
	public String getSessionId() {
		return sessionId;
	}

	@XmlElement(name = "sessionId")
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@JsonProperty("acceptLanguage")
	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	@XmlElement(name = "acceptLanguage")
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	@JsonProperty("userAgent")
	public String getUserAgent() {
		return userAgent;
	}

	@XmlElement(name = "userAgent")
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@JsonProperty("referer")
	public String getReferer() {
		return referer;
	}

	@XmlElement(name = "referer")
	public void setReferer(String referer) {
		this.referer = referer;
	}

}
