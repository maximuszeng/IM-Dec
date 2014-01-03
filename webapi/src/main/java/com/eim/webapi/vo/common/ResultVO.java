package com.eim.webapi.vo.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "result")
public class ResultVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -5819736795237643687L;
	// Y for success, N for failed
	public static final String STATUS_YES = "Y";
	public static final String STATUS_NO = "N";

	private Long id;
	private String status = STATUS_YES;
	private String errorCode;
	private String errorMessage;

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}
	
	@XmlElement(name = "errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@XmlElement(name = "id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	@XmlElement(name = "errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
