package com.lin.booking.dto.gym_package;

import java.math.BigDecimal;
import java.util.Date;

import com.lin.booking.entity.gym_package.UserPackage;
import com.lin.booking.util.common.CommonConstant;
import com.lin.booking.util.common.CommonUtil;

public class UserPackageDTO {

	private Long userPackageId;
	private Long userId;
	private Long gymPackageId;
	private BigDecimal remainingCredits;
	private String purchaseDate;
	private String expiryDate;
	private Integer status;

	private Date expiryDateVal;

	public UserPackageDTO(UserPackage userPackage) {
		this.userPackageId = userPackage.getId();
		this.userId = userPackage.getUser().getId();
		this.gymPackageId = userPackage.getGymPackage().getId();
		this.remainingCredits = userPackage.getRemainingCredits();
		this.purchaseDate = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, userPackage.getPurchaseDate());
		this.expiryDate = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, userPackage.getExpiryDate());
		this.status = userPackage.getStatus();

		this.expiryDateVal = userPackage.getExpiryDate();
	}

	public UserPackageDTO() {

	}

	public Long getUserPackageId() {
		return userPackageId;
	}

	public void setUserPackageId(Long userPackageId) {
		this.userPackageId = userPackageId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGymPackageId() {
		return gymPackageId;
	}

	public void setGymPackageId(Long gymPackageId) {
		this.gymPackageId = gymPackageId;
	}

	public BigDecimal getRemainingCredits() {
		return remainingCredits;
	}

	public void setRemainingCredits(BigDecimal remainingCredits) {
		this.remainingCredits = remainingCredits;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getExpiryDateVal() {
		return expiryDateVal;
	}

	public void setExpiryDateVal(Date expiryDateVal) {
		this.expiryDateVal = expiryDateVal;
	}

}
