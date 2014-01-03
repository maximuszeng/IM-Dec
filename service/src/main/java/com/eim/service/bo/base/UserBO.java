package com.eim.service.bo.base;

import java.util.List;

import com.eim.persist.po.base.UserPO;

@SuppressWarnings("serial")
public class UserBO extends UserPO {
	private List<StaffBO> staffs;
	private List<ApplicationBO> applications;
	private StaffBO adminStaff;

	public List<ApplicationBO> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationBO> applications) {
		this.applications = applications;
	}

	public List<StaffBO> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffBO> staffs) {
		this.staffs = staffs;
	}

	public StaffBO getAdminStaff() {
		return adminStaff;
	}

	public void setAdminStaff(StaffBO adminStaff) {
		this.adminStaff = adminStaff;
	}

}
