package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.enums.ConcurrentServiceMode;
import com.eim.persist.enums.UserType;
import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class UserPO extends BasePO implements Serializable {
	public static final String SEQUENCE_NAME = "UID";
	private Long uid;
	private String name;
	private UserType userType;
	private Integer staffLimited;
	private Integer staffUsed;
	private Long createDate;
	private String logoUrl;
	private ConcurrentServiceMode serviceMode;
	private Integer serviceConcurrentLimited;

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

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Integer getStaffLimited() {
		return staffLimited;
	}

	public void setStaffLimited(Integer staffLimited) {
		this.staffLimited = staffLimited;
	}

	public Integer getStaffUsed() {
		return staffUsed;
	}

	public void setStaffUsed(Integer staffUsed) {
		this.staffUsed = staffUsed;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
