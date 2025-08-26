package com.lin.booking.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.booking.api.request.ClassScheduleRequest;
import com.lin.booking.api.response.ClassScheduleResponse;
import com.lin.booking.api.response.Response;
import com.lin.booking.dto.class_schedule.ClassScheduleDTO;
import com.lin.booking.service.class_schedule.ClassScheduleService;
import com.lin.booking.util.common.FieldErrorCode;
import com.lin.booking.util.common.MapperUtil;

@RestController
@RequestMapping("/class_schedule")
public class ClassScheduleAPI {

	@Autowired
	private ClassScheduleService classScheduleService;

	@PostMapping("list")
	public Response<List<ClassScheduleResponse>> getClassScheduleList(@RequestHeader("Authorization") String authToken,
			@RequestHeader("UserId") Long userId, @RequestBody ClassScheduleRequest classScheduleRequest,
			HttpServletRequest request) {
		Response<List<ClassScheduleResponse>> response = new Response<List<ClassScheduleResponse>>();
		try {
			ClassScheduleDTO requestDTO = new ClassScheduleDTO();
			requestDTO.setCountryCode(classScheduleRequest.getCountryCode());

			List<ClassScheduleDTO> classScheduleDTOList = classScheduleService.getClassScheduleList(requestDTO);
			List<ClassScheduleResponse> responseList = MapperUtil.mapList(classScheduleDTOList,
					ClassScheduleResponse::new);

			response.setData(responseList);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response<>();
			response.setResponseCode(FieldErrorCode.GENERAL.getCode());
			response.setResponseMessage(FieldErrorCode.GENERAL.getDesc());
		}
		return response;
	}

}
