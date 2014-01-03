package com.eim.webapi.vo.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.webapi.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "staff")
public class StaffVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 6362772710761035009L;
	private Long suid;
	private String userName;
	private String email;
	private Boolean canServe;
	private String password;
	private Long lastActiveDate;
	private Long createDate;
	private Boolean isAdmin;
	private Long uid;
	private ConcurrentServiceMode serviceMode;
	private Integer serviceConcurrentLimited;
	private Long[] canServeAppId;

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("createDate")
	public Long getCreateDate() {
		return createDate;
	}

	@XmlElement(name = "createDate")
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	@JsonProperty("canServeAppId")
	public Long[] getCanServeAppId() {
		return canServeAppId;
	}

	@XmlElement(name = "canServeAppId")
	public void setCanServeAppId(Long[] canServeAppId) {
		this.canServeAppId = canServeAppId;
	}

	@JsonProperty("serviceMode")
	public ConcurrentServiceMode getServiceMode() {
		return serviceMode;
	}

	@XmlElement(name = "serviceMode")
	public void setServiceMode(ConcurrentServiceMode serviceMode) {
		this.serviceMode = serviceMode;
	}

	@JsonProperty("serviceConcurrentLimited")
	public Integer getServiceConcurrentLimited() {
		return serviceConcurrentLimited;
	}

	@XmlElement(name = "serviceConcurrentLimited")
	public void setServiceConcurrentLimited(Integer serviceConcurrentLimited) {
		this.serviceConcurrentLimited = serviceConcurrentLimited;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("suid")
	public Long getSuid() {
		return suid;
	}

	@XmlElement(name = "suid")
	public void setSuid(Long suid) {
		this.suid = suid;
	}

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	@XmlElement(name = "userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("canServe")
	public Boolean getCanServe() {
		return canServe;
	}

	@XmlElement(name = "canServe")
	public void setCanServe(Boolean canServe) {
		this.canServe = canServe;
	}

	@JsonProperty("lastActiveDate")
	public Long getLastActiveDate() {
		return lastActiveDate;
	}

	@XmlElement(name = "lastActiveDate")
	public void setLastActiveDate(Long lastActiveDate) {
		this.lastActiveDate = lastActiveDate;
	}

	@JsonProperty("isAdmin")
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@JsonProperty("uid")
	public Long getUid() {
		return uid;
	}

	@XmlElement(name = "uid")
	public void setUid(Long uid) {
		this.uid = uid;
	}

}
