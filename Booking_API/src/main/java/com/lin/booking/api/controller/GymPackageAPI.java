package com.lin.booking.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.booking.api.request.GymPackageRequest;
import com.lin.booking.api.request.PackagePurchaseRequest;
import com.lin.booking.api.response.GymPackageResponse;
import com.lin.booking.api.response.PackagePurchaseResponse;
import com.lin.booking.api.response.Response;
import com.lin.booking.dto.gym_package.GymPackageDTO;
import com.lin.booking.dto.gym_package.UserPackageDTO;
import com.lin.booking.service.gym_package.GymPackageService;
import com.lin.booking.service.gym_package.UserPackageService;
import com.lin.booking.util.common.FieldErrorCode;
import com.lin.booking.util.common.MapperUtil;

@RestController
@RequestMapping("/gympackage")
public class GymPackageAPI {

	@Autowired
	private GymPackageService gymPackageService;

	@Autowired
	private UserPackageService userPackageService;

	@PostMapping("list")
	public Response<List<GymPackageResponse>> getGymPackageList(@RequestHeader("Authorization") String authToken,
			@RequestHeader("UserId") Long userId, @RequestBody GymPackageRequest gymPackageRequest,
			HttpServletRequest request) {
		Response<List<GymPackageResponse>> response = new Response<List<GymPackageResponse>>();
		try {
			GymPackageDTO requestDTO = new GymPackageDTO();
			requestDTO.setCountryCode(gymPackageRequest.getCountryCode());

			List<GymPackageDTO> gymPackageDTOList = gymPackageService.getPackageList(requestDTO);
			List<GymPackageResponse> responseList = MapperUtil.mapList(gymPackageDTOList, GymPackageResponse::new);

			response.setData(responseList);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response<>();
			response.setResponseCode(FieldErrorCode.GENERAL.getCode());
			response.setResponseMessage(FieldErrorCode.GENERAL.getDesc());
		}
		return response;
	}

	@PostMapping("purchase")
	public Response<PackagePurchaseResponse> purchaseGymPackage(@RequestHeader("Authorization") String authToken,
			@RequestHeader("UserId") Long userId, @RequestBody PackagePurchaseRequest purchaseRequest,
			HttpServletRequest request) {
		Response<PackagePurchaseResponse> response = new Response<PackagePurchaseResponse>();
		try {
			UserPackageDTO userPackageDTO = new UserPackageDTO();
			userPackageDTO.setUserId(userId);
			userPackageDTO.setGymPackageId(purchaseRequest.getGymPackageId());
			userPackageDTO = userPackageService.createUserPackage(userPackageDTO);
			if (userPackageDTO.getUserPackageId() != null) {
				PackagePurchaseResponse packagePurchaseResponse = new PackagePurchaseResponse(userPackageDTO);
				response.setData(packagePurchaseResponse);
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
