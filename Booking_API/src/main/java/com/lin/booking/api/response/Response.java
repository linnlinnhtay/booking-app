package com.lin.booking.api.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.FieldError;
import com.lin.booking.util.common.FieldErrorCode;


@JsonInclude(value = Include.NON_NULL)
public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7720139773115221467L;

	private Integer responseCode;

	private String responseMessage;

	private T data;

	private List<FieldError> error;

	public Response() {
		super();
		this.responseCode = FieldErrorCode.SUCCESS.getCode();
		this.responseMessage = FieldErrorCode.SUCCESS.getDesc();
	}

	public Response(List<FieldError> error) {
		if (CommonUtil.validList(error)) {
			this.responseCode = FieldErrorCode.MULTIPLE_ERROR.getCode();
			this.responseMessage = FieldErrorCode.MULTIPLE_ERROR.getDesc();
			this.error = error;
		}
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<FieldError> getError() {
		return error;
	}

	public void setError(List<FieldError> error) {
		this.error = error;
	}
}
