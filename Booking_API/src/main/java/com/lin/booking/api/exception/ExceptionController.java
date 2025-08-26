package com.lin.booking.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lin.booking.api.response.Response;

@ControllerAdvice
public class ExceptionController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<Response> customException(HttpServletRequest request, InvalidRequestException ex) {
		Response response = new Response<>();
		response.setResponseCode(ex.getResponseCode());
		response.setResponseMessage(ex.getResponseMessage());
		if (ex.getError() != null && ex.getError().size() > 0) {
			response.setError(ex.getError());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
