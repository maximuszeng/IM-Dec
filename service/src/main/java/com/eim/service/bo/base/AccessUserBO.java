package com.eim.service.bo.base;

import com.eim.persist.po.base.AccessUserPO;

@SuppressWarnings("serial")
public class AccessUserBO extends AccessUserPO {
	private ApplicationBO application;

	public ApplicationBO getApplication() {
		return application;
	}

	public void setApplication(ApplicationBO application) {
		this.application = application;
	}

}
