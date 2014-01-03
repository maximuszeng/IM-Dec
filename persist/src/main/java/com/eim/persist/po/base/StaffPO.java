package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class StaffPO extends BasePO implements Serializable {
	public static final String SEQUENCE_NAME = "SUID";
	private Long suid;
	private String userName;
	private String password;
	private Boolean canServe;
	private String email;
	private Long lastActiveDate;
	private Long createDate;
	private Boolean isAdmin;
	private Long uid;
	private ConcurrentServiceMode serviceMode;
	private Integer serviceConcurrentLimited;

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public ConcurrentServiceMode getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(ConcurrentServiceMode serviceMode) {
		this.serviceMode = serviceMode;
	}

	public Integer getServiceConcurrentLimited() {
		return serviceConcurrentLimited;
	}

	public void setServiceConcurrentLimited(Integer serviceConcurrentLimited) {
		this.serviceConcurrentLimited = serviceConcurrentLimited;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSuid() {
		return suid;
	}

	public void setSuid(Long suid) {
		this.suid = suid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getCanServe() {
		return canServe;
	}

	public void setCanServe(Boolean canServe) {
		this.canServe = canServe;
	}

	public Long getLastActiveDate() {
		return lastActiveDate;
	}

	public void setLastActiveDate(Long lastActiveDate) {
		this.lastActiveDate = lastActiveDate;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}
