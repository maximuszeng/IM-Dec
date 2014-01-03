/**
 * 
 */
package com.eim.service.common;

/**
 * @author maximus.zeng
 * 
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -5839727646449776282L;
	private String errorCode;
	private Object[] params;

	public ServiceException(String errorCode, Object... params) {
		super(errorCode);
		this.errorCode = errorCode;
		this.params = params;
	}

	public ServiceException(String errorCode, Throwable e, Object... params) {
		super(errorCode, e);
		this.errorCode = errorCode;
		this.params = params;
	}

	public ServiceException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public ServiceException(String errorCode, Throwable e) {
		super(errorCode, e);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}
