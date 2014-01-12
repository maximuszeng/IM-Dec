package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class StaffAppRelationPO extends BasePO implements Serializable {
	private Long appId;
	private Long suid;
	private Long createTime;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Long getSuid() {
		return suid;
	}

	public void setSuid(Long suid) {
		this.suid = suid;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}
