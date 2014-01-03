package com.eim.webapi.vo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "r")
public class ListVO<E> extends BaseVO implements Serializable {
	private static final long serialVersionUID = -5819736795237643687L;
	private String errorCode;
	private String errorMessage;
	private Integer count = 0;
	private List<E> contents = new ArrayList<E>();

	public ListVO(List<E> contents) {
		this.setContents(contents);
		this.setCount(contents != null ? contents.size() : 0);
	}

	public ListVO() {

	}

	public void add(E content) {
		contents.add(content);
		count++;
	}

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@XmlElement(name = "count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("contents")
	public List<E> getContents() {
		return contents;
	}

	@XmlElementRef
	public void setContents(List<E> contents) {
		this.contents = contents;
	}

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@XmlElement(name = "errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
