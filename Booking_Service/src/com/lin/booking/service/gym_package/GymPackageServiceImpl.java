package com.lin.booking.service.gym_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.gym_package.GymPackageDAO;
import com.lin.booking.dto.gym_package.GymPackageDTO;
import com.lin.booking.entity.gym_package.GymPackage;
import com.lin.booking.util.common.MapperUtil;

@Service("gymPackageService")
@Transactional
public class GymPackageServiceImpl implements GymPackageService {

	@Autowired
	GymPackageDAO gymPackageDAO;

	@Override
	public List<GymPackageDTO> getPackageList(GymPackageDTO requestDTO) {
		List<GymPackage> gymPackageList = gymPackageDAO.getPackageList(requestDTO);
		return MapperUtil.mapList(gymPackageList, GymPackageDTO::new);
	}

}
