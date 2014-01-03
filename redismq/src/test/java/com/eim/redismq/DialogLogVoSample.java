package com.eim.redismq;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "d")
public class DialogLogVoSample implements Serializable {
	private static final long serialVersionUID = -2543883861899774812L;
	private Long appId;
	private Long suid;
	private Long createTime;
	private Long auid;
	private String direction;
	private String contentType;
	private String content;

	@JsonProperty("aid")
	public Long getAppId() {
		return appId;
	}

	@XmlElement(name = "aid")
	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@JsonProperty("suid")
	public Long getSuid() {
		return suid;
	}

	@XmlElement(name = "suid")
	public void setSuid(Long suid) {
		this.suid = suid;
	}

	@JsonProperty("t")
	public Long getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "t")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@JsonProperty("auid")
	public Long getAuid() {
		return auid;
	}

	@XmlElement(name = "auid")
	public void setAuid(Long auid) {
		this.auid = auid;
	}

	@JsonProperty("d")
	public String getDirection() {
		return direction;
	}

	@XmlElement(name = "d")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("ct")
	public String getContentType() {
		return contentType;
	}

	@XmlElement(name = "ct")
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@JsonProperty("c")
	public String getContent() {
		return content;
	}

	@XmlElement(name = "c")
	public void setContent(String content) {
		this.content = content;
	}
}
