package com.lin.booking.entity.class_schedule;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lin.booking.entity.base.BaseEntity;

@Entity
@Table(name = "class_schedule")
public class ClassSchedule extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8732251829152301424L;

	@Column(name = "Title")
	private String title;

	@Column(name = "CountryCode")
	private String countryCode;

	@Column(name = "RequiredCredits")
	private BigDecimal requiredCredits;

	@Column(name = "MaxPerson")
	private Integer maxPerson;

	@Column(name = "StartTime")
	private Date startTime;

	@Column(name = "EndTime")
	private Date endTime;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
