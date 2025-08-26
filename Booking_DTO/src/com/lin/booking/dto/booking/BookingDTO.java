package com.lin.booking.dto.booking;

import java.util.Date;

import com.lin.booking.entity.booking.Booking;
import com.lin.booking.util.common.CommonConstant;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.enumeration.BookingStatus;

public class BookingDTO {

	private Long bookingId;
	private Long userPackageId;
	private Long classScheduleId;
	private Integer bookingStatus;
	private String bookingStatusDesc;
	private String canceledTime;
	private String createdTime;
	private String updatedTime;

	private Date userPackageExpiryDateVal;
	private Date classScheduleStartTimeVal;
	private Date classScheduleEndTimeVal;

	public BookingDTO(Booking booking) {
		if (booking != null) {
			this.bookingId = booking.getId();
			this.userPackageId = booking.getUserPackage().getId();
			this.userPackageExpiryDateVal = booking.getUserPackage().getExpiryDate();
			this.classScheduleId = booking.getClassSchedule().getId();
			this.classScheduleStartTimeVal = booking.getClassSchedule().getStartTime();
			this.classScheduleEndTimeVal = booking.getClassSchedule().getEndTime();
			this.bookingStatus = booking.getBookingStatus();
			this.bookingStatusDesc = BookingStatus.getDescByCode(booking.getBookingStatus());
			this.canceledTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, booking.getCanceledTime());
			this.createdTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, booking.getCreatedTime());
			this.updatedTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, booking.getUpdatedTime());
		}
	}

	public BookingDTO() {

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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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

	public Date getClassScheduleStartTimeVal() {
		return classScheduleStartTimeVal;
	}

	public void setClassScheduleStartTimeVal(Date classScheduleStartTimeVal) {
		this.classScheduleStartTimeVal = classScheduleStartTimeVal;
	}

	public Date getClassScheduleEndTimeVal() {
		return classScheduleEndTimeVal;
	}

	public void setClassScheduleEndTimeVal(Date classScheduleEndTimeVal) {
		this.classScheduleEndTimeVal = classScheduleEndTimeVal;
	}

	public Date getUserPackageExpiryDateVal() {
		return userPackageExpiryDateVal;
	}

	public void setUserPackageExpiryDateVal(Date userPackageExpiryDateVal) {
		this.userPackageExpiryDateVal = userPackageExpiryDateVal;
	}

}
