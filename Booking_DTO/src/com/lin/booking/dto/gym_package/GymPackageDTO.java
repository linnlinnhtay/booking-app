package com.lin.booking.dto.gym_package;

import java.math.BigDecimal;

import com.lin.booking.entity.gym_package.GymPackage;

public class GymPackageDTO {

	private Long gymPackageId;

	private String name;

	private String countryCode;

	private BigDecimal credits;

	private BigDecimal price;

	private Integer expiryDays;

	public GymPackageDTO() {
	}

	public GymPackageDTO(GymPackage gymPackage) {
		this.gymPackageId = gymPackage.getId();
		this.name = gymPackage.getName();
		this.countryCode = gymPackage.getCountryCode();
		this.credits = gymPackage.getCredits();
		this.price = gymPackage.getPrice();
		this.expiryDays = gymPackage.getExpiryDays();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}

	public Long getGymPackageId() {
		return gymPackageId;
	}

	public void setGymPackageId(Long gymPackageId) {
		this.gymPackageId = gymPackageId;
	}

}
