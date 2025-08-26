package com.lin.booking.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.booking.api.request.BookingRequest;
import com.lin.booking.api.response.BookingResponse;
import com.lin.booking.api.response.Response;
import com.lin.booking.dto.booking.BookingDTO;
import com.lin.booking.dto.class_schedule.ClassScheduleDTO;
import com.lin.booking.dto.gym_package.UserPackageDTO;
import com.lin.booking.service.booking.BookingService;
import com.lin.booking.service.class_schedule.ClassScheduleService;
import com.lin.booking.service.gym_package.UserPackageService;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.FieldError;
import com.lin.booking.util.common.FieldErrorCode;

@RestController
@RequestMapping("booking")
public class BookingAPI {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private ClassScheduleService classScheduleService;

	@Autowired
	private UserPackageService userPackageService;

	@PostMapping("create")
	public Response<BookingResponse> createBooking(@RequestHeader("Authorization") String authToken,
			@RequestHeader("UserId") Long userId, @RequestBody BookingRequest bookingRequest,
			HttpServletRequest request) {
		Response<BookingResponse> response = new Response<BookingResponse>();
		try {
			List<FieldError> errorCodeList = new ArrayList<FieldError>();

			BookingDTO bookingDTO = new BookingDTO();
			bookingDTO.setUserPackageId(bookingRequest.getUserPackageId());
			bookingDTO.setClassScheduleId(bookingRequest.getClassScheduleId());

			checkAvailableBooking(userId, errorCodeList, bookingDTO);

			if (!CommonUtil.validList(errorCodeList) && bookingDTO.getUserPackageId() != null) {

				bookingDTO = bookingService.createBooking(bookingDTO);
				BookingResponse bookingResponse = new BookingResponse(bookingDTO);
				response.setData(bookingResponse);

			} else {
				response.setError(errorCodeList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response<>();
			response.setResponseCode(FieldErrorCode.GENERAL.getCode());
			response.setResponseMessage(FieldErrorCode.GENERAL.getDesc());
		}
		return response;
	}

	private void checkAvailableBooking(Long userId, List<FieldError> errorCodeList, BookingDTO bookingDTO) {

		List<BookingDTO> bookingList = bookingService.searchBookingList(bookingDTO);
		ClassScheduleDTO classScheduleDTO = classScheduleService.getClassScheduleById(bookingDTO.getClassScheduleId());
		if (bookingList != null && classScheduleDTO != null && bookingList.size() >= classScheduleDTO.getMaxPerson()) {
			errorCodeList.add(new FieldError(FieldErrorCode.MAX_PERSON_LIMIT.getCode(),
					FieldErrorCode.MAX_PERSON_LIMIT.getDesc()));
		}

		// overlap class time validation for multiple class for user
		// class end time check to avoid finished class
		// wait list to booked
		// credit check for user's remaining credits
		// package expired date check

		if (new Date().after(classScheduleDTO.getEndTimeVal())) {
			errorCodeList.add(
					new FieldError(FieldErrorCode.CLASS_FINISHED.getCode(), FieldErrorCode.CLASS_FINISHED.getDesc()));
		}

		List<BookingDTO> userBookings = bookingService.searchBookingListByUser(userId);
		for (BookingDTO userBookingDTO : userBookings) {
			if (classScheduleDTO.getStartTimeVal().before(userBookingDTO.getClassScheduleEndTimeVal())
					&& classScheduleDTO.getEndTimeVal().after(userBookingDTO.getClassScheduleStartTimeVal())) {
				errorCodeList.add(new FieldError(FieldErrorCode.BOOKING_OVERLAP.getCode(),
						FieldErrorCode.BOOKING_OVERLAP.getDesc()));

				break;
			}
		}

		UserPackageDTO userPackageDTO = userPackageService.getUserPackageByUser(userId);
		if (userPackageDTO != null && new Date().after(userPackageDTO.getExpiryDateVal())) {
			errorCodeList.add(new FieldError(FieldErrorCode.USER_PACKAGE_EXPIRED.getCode(),
					FieldErrorCode.USER_PACKAGE_EXPIRED.getDesc()));
		}

		if (userPackageDTO.getRemainingCredits().compareTo(classScheduleDTO.getRequiredCredits()) <= 0) {

			errorCodeList.add(new FieldError(FieldErrorCode.NOT_ENOUGH_CREDITS.getCode(),
					FieldErrorCode.NOT_ENOUGH_CREDITS.getDesc()));
		}

	}

}
