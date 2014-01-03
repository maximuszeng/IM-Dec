package com.eim.service.bo.base;

import java.util.List;

import com.eim.persist.po.base.StaffPO;

@SuppressWarnings("serial")
public class StaffBO extends StaffPO {
	private UserBO user;
	private List<StaffAppRelationBO> staffAppRelations;
	private List<DialogLogBO> dialogLogs;

	public List<DialogLogBO> getDialogLogs() {
		return dialogLogs;
	}

	public void setDialogLogs(List<DialogLogBO> dialogLogs) {
		this.dialogLogs = dialogLogs;
	}

	public List<StaffAppRelationBO> getStaffAppRelations() {
		return staffAppRelations;
	}

	public void setStaffAppRelations(List<StaffAppRelationBO> staffAppRelations) {
		this.staffAppRelations = staffAppRelations;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

}
