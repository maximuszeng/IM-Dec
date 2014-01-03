package com.eim.service.bo.base;

import com.eim.persist.po.base.StaffAppRelationPO;

@SuppressWarnings("serial")
public class StaffAppRelationBO extends StaffAppRelationPO {
	private ApplicationBO application;
	private StaffBO staff;

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

}
