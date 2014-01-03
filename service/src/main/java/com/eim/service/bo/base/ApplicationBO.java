package com.eim.service.bo.base;

import java.util.List;

import com.eim.persist.po.base.ApplicationPO;

@SuppressWarnings("serial")
public class ApplicationBO extends ApplicationPO {
	private UserBO user;
	private List<StaffAppRelationBO> staffs;
	private List<AccessUserBO> accessUsers;

	public List<AccessUserBO> getAccessUsers() {
		return accessUsers;
	}

	public void setAccessUsers(List<AccessUserBO> accessUsers) {
		this.accessUsers = accessUsers;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public List<StaffAppRelationBO> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffAppRelationBO> staffs) {
		this.staffs = staffs;
	}

}
