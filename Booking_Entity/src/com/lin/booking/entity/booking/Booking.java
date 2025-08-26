package com.lin.booking.entity.booking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lin.booking.entity.base.BaseEntity;
import com.lin.booking.entity.class_schedule.ClassSchedule;
import com.lin.booking.entity.gym_package.UserPackage;

@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3373591858768425808L;

	@ManyToOne
	@JoinColumn(name = "UserPackage_Id")
	private UserPackage userPackage;

	@ManyToOne
	@JoinColumn(name = "ClassSchedule_Id")
	private ClassSchedule classSchedule;

	@Column(name = "BookingStatus")
	private Integer bookingStatus;

	@Column(name = "CanceledTime")
	private Date canceledTime;

	public UserPackage getUserPackage() {
		return userPackage;
	}

	public void setUserPackage(UserPackage userPackage) {
		this.userPackage = userPackage;
	}

	public ClassSchedule getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassSchedule classSchedule) {
		this.classSchedule = classSchedule;
	}

	public Integer getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getCanceledTime() {
		return canceledTime;
	}

	public void setCanceledTime(Date canceledTime) {
		this.canceledTime = canceledTime;
	}

}
