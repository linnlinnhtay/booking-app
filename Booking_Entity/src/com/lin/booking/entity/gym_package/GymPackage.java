package com.lin.booking.entity.gym_package;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lin.booking.entity.base.BaseEntity;

@Entity
@Table(name = "gym_package")
public class GymPackage extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6450469949903265624L;

	@Column(name = "Name")
	private String name;

	@Column(name = "CountryCode")
	private String countryCode;

	@Column(name = "Credits")
	private BigDecimal credits;

	@Column(name = "Price")
	private BigDecimal price;

	@Column(name = "ExpiryDays")
	private Integer expiryDays;

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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
