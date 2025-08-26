package com.lin.booking.service.gym_package;

import com.lin.booking.dto.gym_package.UserPackageDTO;

public interface UserPackageService {

	UserPackageDTO createUserPackage(UserPackageDTO userPackageDTO);
	
	UserPackageDTO getUserPackageByUser(Long userId);

}
