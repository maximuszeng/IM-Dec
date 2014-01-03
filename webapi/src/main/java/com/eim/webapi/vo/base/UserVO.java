package com.eim.webapi.vo.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.persist.enums.UserType;
import com.eim.webapi.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "user")
public class UserVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -5819736795237643687L;
	private Long uid;
	private String name;
	private UserType userType;
	private Integer staffLimited;
	private Integer staffUsed;
	private Long createDate;
	private String logoUrl;
	private String email;
	private String password;
	private ConcurrentServiceMode serviceMode;
	private Integer serviceConcurrentLimited;
	private StaffVO staffInfo;

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

	@XmlElement(name = "userType")
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("staffInfo")
	public StaffVO getStaffInfo() {
		return staffInfo;
	}

	@XmlElementRef
	public void setStaffInfo(StaffVO staffInfo) {
		this.staffInfo = staffInfo;
	}

	@JsonProperty("uid")
	public Long getUid() {
		return uid;
	}

	@XmlElement(name = "uid")
	public void setUid(Long uid) {
		this.uid = uid;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("userType")
	public UserType getUserType() {
		return userType;
	}

	@JsonProperty("staffLimited")
	public Integer getStaffLimited() {
		return staffLimited;
	}

	@XmlElement(name = "staffLimited")
	public void setStaffLimited(Integer staffLimited) {
		this.staffLimited = staffLimited;
	}

	@JsonProperty("staffUsed")
	public Integer getStaffUsed() {
		return staffUsed;
	}

	@XmlElement(name = "staffUsed")
	public void setStaffUsed(Integer staffUsed) {
		this.staffUsed = staffUsed;
	}

	@JsonProperty("createDate")
	public Long getCreateDate() {
		return createDate;
	}

	@XmlElement(name = "createDate")
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	@JsonProperty("logoUrl")
	public String getLogoUrl() {
		return logoUrl;
	}

	@XmlElement(name = "logoUrl")
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
