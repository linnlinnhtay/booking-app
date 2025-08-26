package com.lin.booking.api.response;

import com.lin.booking.dto.booking.BookingDTO;

public class BookingResponse {

	private Long bookingId;
	private Long userPackageId;
	private Long classScheduleId;
	private Integer bookingStatus;
	private String bookingStatusDesc;
	private String canceledTime;
	private String createdTime;
	private String updatedTime;

	public BookingResponse(BookingDTO bookingDTO) {
		this.bookingId = bookingDTO.getBookingId();
		this.userPackageId = bookingDTO.getUserPackageId();
		this.classScheduleId = bookingDTO.getClassScheduleId();
		this.bookingStatus = bookingDTO.getBookingStatus();
		this.bookingStatusDesc = bookingDTO.getBookingStatusDesc();
		this.canceledTime = bookingDTO.getCanceledTime();
		this.createdTime = bookingDTO.getCreatedTime();
		this.updatedTime = bookingDTO.getUpdatedTime();
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

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

	public Integer getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getBookingStatusDesc() {
		return bookingStatusDesc;
	}

	public void setBookingStatusDesc(String bookingStatusDesc) {
		this.bookingStatusDesc = bookingStatusDesc;
	}

	public String getCanceledTime() {
		return canceledTime;
	}

	public void setCanceledTime(String canceledTime) {
		this.canceledTime = canceledTime;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
