package com.lin.booking.api.exception;

import java.util.List;

import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.FieldError;
import com.lin.booking.util.common.FieldErrorCode;

public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4284330544334538374L;
	private Integer responseCode;
	private String responseMessage;
	private List<FieldError> error;

	public InvalidRequestException(List<FieldError> error) {
		if (CommonUtil.validList(error)) {
			this.responseCode = FieldErrorCode.MULTIPLE_ERROR.getCode();
			this.responseMessage = FieldErrorCode.MULTIPLE_ERROR.getDesc();
			this.error = error;
		}
	}

	public InvalidRequestException(FieldError error) {

		this.responseCode = error.getFieldErrorCode();
		this.responseMessage = error.getErrorMessage();

	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<FieldError> getError() {
		return error;
	}

	public void setError(List<FieldError> error) {
		this.error = error;
	}

}
