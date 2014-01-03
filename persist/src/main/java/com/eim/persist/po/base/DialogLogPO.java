package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.enums.ContentType;
import com.eim.persist.enums.DialogDirection;
import com.eim.persist.enums.DialogMode;
import com.eim.persist.po.common.BasePO;

@SuppressWarnings("serial")
public class DialogLogPO extends BasePO implements Serializable {
	private Long appId;
	private DialogMode dialogMode;
	// serve use id, if is robot, is the robot id, if is manual is the staff id
	private Long suid;
	private Long createTime;
	private Long auid;
	private DialogDirection direction;
	private ContentType contentType;
	private String content;

	public DialogMode getDialogMode() {
		return dialogMode;
	}

	public void setDialogMode(DialogMode dialogMode) {
		this.dialogMode = dialogMode;
	}

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

	public Long getAuid() {
		return auid;
	}

	public void setAuid(Long auid) {
		this.auid = auid;
	}

	public DialogDirection getDirection() {
		return direction;
	}

	public void setDirection(DialogDirection direction) {
		this.direction = direction;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
