package com.eim.webapi.vo.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eim.persist.enums.AppType;
import com.eim.webapi.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "a")
public class ApplicationVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -555254919694425490L;
	private Long appId;
	private Long uid;
	private String domain;
	private String name;
	private String industryCategory;
	private AppType appType;
	private String logoUrl;
	private String welcomeMessage;
	private String appKey;
	private Long createTime;
	private Long lastUpdateTime;
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("industryCategory")
	public String getIndustryCategory() {
		return industryCategory;
	}
	
	@XmlElement(name = "industryCategory")
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}
	
	@JsonProperty("createTime")
	public Long getCreateTime() {
		return createTime;
	}
	
	@XmlElement(name = "createTime")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	@JsonProperty("lastUpdateTime")
	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	@XmlElement(name = "lastUpdateTime")
	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@JsonProperty("appId")
	public Long getAppId() {
		return appId;
	}

	@XmlElement(name = "appId")
	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@JsonProperty("uid")
	public Long getUid() {
		return uid;
	}

	@XmlElement(name = "uid")
	public void setUid(Long uid) {
		this.uid = uid;
	}

	@JsonProperty("domain")
	public String getDomain() {
		return domain;
	}

	@XmlElement(name = "domain")
	public void setDomain(String domain) {
		this.domain = domain;
	}

	@JsonProperty("appType")
	public AppType getAppType() {
		return appType;
	}

	@XmlElement(name = "appType")
	public void setAppType(AppType appType) {
		this.appType = appType;
	}

	@JsonProperty("logoUrl")
	public String getLogoUrl() {
		return logoUrl;
	}

	@XmlElement(name = "logoUrl")
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@JsonProperty("welcomeMessage")
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	@XmlElement(name = "welcomeMessage")
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@JsonProperty("appKey")
	public String getAppKey() {
		return appKey;
	}

	@XmlElement(name = "appKey")
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

}
