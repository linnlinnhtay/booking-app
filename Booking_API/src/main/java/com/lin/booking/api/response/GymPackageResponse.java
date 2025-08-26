package com.lin.booking.api.response;

import java.math.BigDecimal;

import com.lin.booking.dto.gym_package.GymPackageDTO;

public class GymPackageResponse {

	private Long gymPackageId;

	private String name;

	private String countryCode;

	private BigDecimal credits;

	private BigDecimal price;

	private Integer expireDays;

	public GymPackageResponse() {

	}

	public GymPackageResponse(GymPackageDTO dto) {
		this.gymPackageId = dto.getGymPackageId();
		this.name = dto.getName();
		this.countryCode = dto.getCountryCode();
		this.credits = dto.getCredits();
		this.price = dto.getPrice();
		this.expireDays = dto.getExpiryDays();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public BigDecimal getCredits() {
		return credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getExpireDays() {
		return expireDays;
	}

	public void setExpireDays(Integer expireDays) {
		this.expireDays = expireDays;
	}

	public Long getGymPackageId() {
		return gymPackageId;
	}

	public void setGymPackageId(Long gymPackageId) {
		this.gymPackageId = gymPackageId;
	}

}
