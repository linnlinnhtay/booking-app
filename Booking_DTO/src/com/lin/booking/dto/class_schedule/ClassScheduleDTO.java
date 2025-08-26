package com.lin.booking.dto.class_schedule;

import java.math.BigDecimal;
import java.util.Date;

import com.lin.booking.entity.class_schedule.ClassSchedule;
import com.lin.booking.util.common.CommonConstant;
import com.lin.booking.util.common.CommonUtil;

public class ClassScheduleDTO {

	private Long classScheduleId;

	private String title;

	private String countryCode;

	private BigDecimal requiredCredits;

	private Integer maxPerson;

	private String startTime;

	private String endTime;

	private Date startTimeVal;
	private Date endTimeVal;

	public ClassScheduleDTO() {

	}

	public ClassScheduleDTO(ClassSchedule classSchedule) {
		if (classSchedule != null) {
			this.classScheduleId = classSchedule.getId();
			this.title = classSchedule.getTitle();
			this.countryCode = classSchedule.getCountryCode();
			this.requiredCredits = classSchedule.getRequiredCredits();
			this.maxPerson = classSchedule.getMaxPerson();
			this.startTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, classSchedule.getStartTime());
			this.endTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, classSchedule.getEndTime());
			this.startTimeVal = classSchedule.getStartTime();
			this.endTimeVal = classSchedule.getEndTime();
		}
	}

	public Long getClassScheduleId() {
		return classScheduleId;
	}

	public void setClassScheduleId(Long classScheduleId) {
		this.classScheduleId = classScheduleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public BigDecimal getRequiredCredits() {
		return requiredCredits;
	}

	public void setRequiredCredits(BigDecimal requiredCredits) {
		this.requiredCredits = requiredCredits;
	}

	public Integer getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(Integer maxPerson) {
		this.maxPerson = maxPerson;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getEndTimeVal() {
		return endTimeVal;
	}

	public void setEndTimeVal(Date endTimeVal) {
		this.endTimeVal = endTimeVal;
	}

	public Date getStartTimeVal() {
		return startTimeVal;
	}

	public void setStartTimeVal(Date startTimeVal) {
		this.startTimeVal = startTimeVal;
	}

}
