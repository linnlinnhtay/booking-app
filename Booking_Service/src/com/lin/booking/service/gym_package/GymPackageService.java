package com.lin.booking.service.gym_package;

import java.util.List;

import com.lin.booking.dto.gym_package.GymPackageDTO;

public interface GymPackageService {

	List<GymPackageDTO> getPackageList(GymPackageDTO requestDTO);

}
