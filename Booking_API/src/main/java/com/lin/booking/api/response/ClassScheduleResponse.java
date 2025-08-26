package com.lin.booking.api.response;

import java.math.BigDecimal;

import com.lin.booking.dto.class_schedule.ClassScheduleDTO;

public class ClassScheduleResponse {

	private Long classScheduleId;

	private String title;

	private String countryCode;

	private BigDecimal requiredCredits;

	private Integer maxPerson;

	private String startTime;

	private String endTime;

	public ClassScheduleResponse() {

	}

	public ClassScheduleResponse(ClassScheduleDTO dto) {
		this.classScheduleId = dto.getClassScheduleId();
		this.title = dto.getTitle();
		this.countryCode = dto.getCountryCode();
		this.requiredCredits = dto.getRequiredCredits();
		this.maxPerson = dto.getMaxPerson();
		this.startTime = dto.getStartTime();
		this.endTime = dto.getEndTime();
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

}
