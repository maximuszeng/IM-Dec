package com.eim.service.bo.base;

import com.eim.persist.po.base.DialogLogPO;

@SuppressWarnings("serial")
public class DialogLogBO extends DialogLogPO {
	private ApplicationBO application;
	private StaffBO staff;
	private AccessUserBO accessUser;

	public ApplicationBO getApplication() {
		return application;
	}

	public void setApplication(ApplicationBO application) {
		this.application = application;
	}

	public StaffBO getStaff() {
		return staff;
	}

	public void setStaff(StaffBO staff) {
		this.staff = staff;
	}

	public AccessUserBO getAccessUser() {
		return accessUser;
	}

	public void setAccessUser(AccessUserBO accessUser) {
		this.accessUser = accessUser;
	}

}
