package com.lin.booking.api.request;

public class BookingRequest {

	private Long userPackageId;
	private Long classScheduleId;

	public Long getUserPackageId() {
		return userPackageId;
	}

	public void setUserPackageId(Long userPackageId) {
		this.userPackageId = userPackageId;
	}

	public Long getClassScheduleId() {
		return classScheduleId;
	}

	public void setClassScheduleId(Long classScheduleId) {
		this.classScheduleId = classScheduleId;
	}

}
