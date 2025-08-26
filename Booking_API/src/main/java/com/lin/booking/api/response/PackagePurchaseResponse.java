package com.lin.booking.api.response;

import java.math.BigDecimal;

import com.lin.booking.dto.gym_package.UserPackageDTO;
import com.lin.booking.util.enumeration.CommonStatus;

public class PackagePurchaseResponse {

	private Long userPackageId;
	private Long userId;
	private Long gymPackageId;
	private BigDecimal remainingCredits;
	private String purchaseDate;
	private String expiryDate;
	private Integer status;
	private String statusDesc;

	public PackagePurchaseResponse(UserPackageDTO dto) {
		this.userPackageId = dto.getUserPackageId();
		this.userId = dto.getUserId();
		this.gymPackageId = dto.getGymPackageId();
		this.remainingCredits = dto.getRemainingCredits();
		this.purchaseDate = dto.getPurchaseDate();
		this.expiryDate = dto.getExpiryDate();
		this.status = dto.getStatus();
		this.statusDesc = CommonStatus.getDescByCode(dto.getStatus());
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

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}
