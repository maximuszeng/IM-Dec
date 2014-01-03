package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.enums.AppType;
import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class ApplicationPO extends BasePO implements Serializable {
	public static final String SEQUENCE_NAME = "APPID";
	private Long appId;
	private Long uid;
	private String name;
	private String industryCategory;
	private String domain;
	private AppType appType;
	private String logoUrl;
	private String welcomeMessage;
	private String appKey;
	private Long createTime;
	private Long lastUpdateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public AppType getAppType() {
		return appType;
	}

	public void setAppType(AppType appType) {
		this.appType = appType;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

}
