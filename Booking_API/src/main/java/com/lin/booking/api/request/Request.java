package com.lin.booking.api.request;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = 46683615543207819L;

	private String sessionId;

	private Long customerId;

	public Request() {
		super();
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
