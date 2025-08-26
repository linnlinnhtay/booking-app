package com.lin.booking.util.common;

import java.io.Serializable;

public class FieldError implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8290507358866711717L;

	private Integer fieldErrorCode;
	
	private String errorMessage;


	public FieldError() {
		super();
	}

	public FieldError(Integer fieldErrorCode, String errorMessage) {
		super();
		this.fieldErrorCode = fieldErrorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getFieldErrorCode() {
		return fieldErrorCode;
	}

	public void setFieldErrorCode(Integer fieldErrorCode) {
		this.fieldErrorCode = fieldErrorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
