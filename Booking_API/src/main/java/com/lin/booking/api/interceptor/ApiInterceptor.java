package com.lin.booking.api.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lin.booking.util.common.CommonConstant;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.FieldError;
import com.lin.booking.util.common.JwtUtil;

public class ApiInterceptor extends HandlerInterceptorAdapter {

	private List<String> ignoreUrls = null;

	{
		ignoreUrls = Arrays.asList("/", "user/login");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (isIgnoreUrl(request.getRequestURI())) {
			return true;
		}

		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Missing or invalid Authorization header");
			return false;
		}

		try {
			String token = authHeader.substring(7);
			String tokenValid = JwtUtil.validateToken(token);

			if (tokenValid != null) {
				request.setAttribute("tokenValid", tokenValid);
				return true;
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Invalid or expired token");
			}

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Invalid or expired token");
			return false;
		}
		return false;
	}

	private boolean isIgnoreUrl(String url) {
		for (String ignoreUrl : ignoreUrls) {
			if (url.endsWith(ignoreUrl)) {
				return true;
			}
		}
		return false;
	}

	private void checkRequestHeaderValues(String url, HttpServletRequest request, List<FieldError> errorList) {

		String userId = request.getHeader(CommonConstant.API_REQUEST_HEADER_USER_ID);
		String token = request.getHeader(CommonConstant.API_REQUEST_HEADER_TOKEN);

		if (!CommonUtil.validString(token)) {
			errorList.add(new FieldError(001, "Token is required."));
		}

		if (!CommonUtil.validString(userId)) {
			errorList.add(new FieldError(002, "User Id is required."));
		}

		if (CommonUtil.validString(userId) && CommonUtil.validString(token) && JwtUtil.validateToken(token) == null) {
			errorList.add(new FieldError(003, "Invalid session, please login again."));
		}

	}
}