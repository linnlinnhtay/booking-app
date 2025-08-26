package com.lin.booking.entity.gym_package;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lin.booking.entity.base.BaseEntity;
import com.lin.booking.entity.user.User;

@Entity
@Table(name = "user_package")
public class UserPackage extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1044351282820959492L;

	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "GymPackage_Id")
	private GymPackage gymPackage;

	@Column(name = "RemainingCredits")
	private BigDecimal remainingCredits;

	@Column(name = "PurchaseDate")
	private Date purchaseDate;

	@Column(name = "ExpiryDate")
	private Date expiryDate;

	@Column(name = "Status")
	private Integer status;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GymPackage getGymPackage() {
		return gymPackage;
	}

	public void setGymPackage(GymPackage gymPackage) {
		this.gymPackage = gymPackage;
	}

	public BigDecimal getRemainingCredits() {
		return remainingCredits;
	}

	public void setRemainingCredits(BigDecimal remainingCredits) {
		this.remainingCredits = remainingCredits;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
