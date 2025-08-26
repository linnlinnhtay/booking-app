package com.lin.booking.util.common;

public enum FieldErrorCode {

	
	SUCCESS(1, "Success"),
	GENERAL(-1, "General application exception occurred while processing user request."),
	MULTIPLE_ERROR(1000, ""),
	INVALID_SESSION(1001, "Invalid Session!"),
	USER_LOGIN_FAIL(1002,"Email or Password is incorrect."),
	MAX_PERSON_LIMIT(1003,"Max person limit."),
	CLASS_FINISHED(1004, "This class has already finished."),
	BOOKING_OVERLAP(1005,"You already booked another class during this time."),
	USER_PACKAGE_EXPIRED(1006, "Your package has expired."),
	NOT_ENOUGH_CREDITS(1007,"Not enough credits.");
	
	private Integer code;
	private String desc;
	
	FieldErrorCode(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
