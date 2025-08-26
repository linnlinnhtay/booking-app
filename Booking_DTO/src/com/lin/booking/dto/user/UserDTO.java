package com.lin.booking.dto.user;

import com.lin.booking.entity.user.User;
import com.lin.booking.util.common.CommonConstant;
import com.lin.booking.util.common.CommonUtil;

public class UserDTO {

	private Long userId;

	private String name;

	private String password;

	private String email;

	private Integer status;

	private String token;

	private String createdTime;
	private String updatedTime;

	public UserDTO(User user) {
		if (user != null) {
			this.userId = user.getId();
			this.name = user.getName();
			this.email = user.getEmail();
			this.token = user.getToken();
			this.createdTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, user.getCreatedTime());
			this.updatedTime = CommonUtil.dateToString(CommonConstant.STD_DATE_TIME_FORMAT, user.getUpdatedTime());
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
