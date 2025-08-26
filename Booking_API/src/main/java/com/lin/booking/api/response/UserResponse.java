package com.lin.booking.api.response;

import com.lin.booking.dto.user.UserDTO;

public class UserResponse {

	private Long userId;

	private String name;

	private String email;

	private String token;

	private String createdTime;
	private String updatedTime;

	public UserResponse(UserDTO dto) {
		if (dto != null) {
			this.userId = dto.getUserId();
			this.name = dto.getName();
			this.email = dto.getEmail();
			this.token = dto.getToken();
			this.createdTime = dto.getCreatedTime();
			this.updatedTime = dto.getUpdatedTime();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
