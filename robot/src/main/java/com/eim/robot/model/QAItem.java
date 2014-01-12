package com.eim.robot.model;

public class QAItem {
	private Long qaId;
	private Long appId;
	private Long categoryId;
	private String locale;
	private String content;

	public Long getQaId() {
		return qaId;
	}

	public void setQaId(Long qaId) {
		this.qaId = qaId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
