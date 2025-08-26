package com.lin.booking.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.booking.api.request.UserRequest;
import com.lin.booking.api.response.Response;
import com.lin.booking.api.response.UserResponse;
import com.lin.booking.dto.user.UserDTO;
import com.lin.booking.service.user.UserService;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.FieldError;
import com.lin.booking.util.common.FieldErrorCode;
import com.lin.booking.util.common.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public Response<UserResponse> customerLogin(@RequestBody UserRequest loginRequest, HttpServletRequest request) {
		List<FieldError> errorList = new ArrayList<>();
		Response<UserResponse> response = null;

		try {
			response = new Response<>();

			if (!CommonUtil.validList(errorList)) {
				UserDTO dto = userService.checkAuth(loginRequest.getEmail(), loginRequest.getPassword());
				if (dto != null) {
					String token = JwtUtil.generateToken(loginRequest.getEmail());
					System.out.println("login token : " + token);
					dto.setToken(token);
					dto = userService.updateToken(dto);
					UserResponse userResponse = new UserResponse(dto);

					response.setData(userResponse);

				} else {
					response.setResponseCode(FieldErrorCode.USER_LOGIN_FAIL.getCode());
					response.setResponseMessage(FieldErrorCode.USER_LOGIN_FAIL.getDesc());
				}
			} else {
				response = new Response<>(errorList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new Response<>();
			response.setResponseCode(FieldErrorCode.GENERAL.getCode());
			response.setResponseMessage(FieldErrorCode.GENERAL.getDesc());
		}

		return response;
	}
}
