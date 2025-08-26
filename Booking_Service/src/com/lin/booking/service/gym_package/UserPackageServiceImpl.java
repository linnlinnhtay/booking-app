package com.lin.booking.service.gym_package;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.gym_package.GymPackageDAO;
import com.lin.booking.dao.gym_package.UserPackageDAO;
import com.lin.booking.dao.user.UserDAO;
import com.lin.booking.dto.gym_package.UserPackageDTO;
import com.lin.booking.entity.gym_package.GymPackage;
import com.lin.booking.entity.gym_package.UserPackage;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.enumeration.CommonStatus;

@Service("userPackageService")
@Transactional
public class UserPackageServiceImpl implements UserPackageService {

	@Autowired
	UserPackageDAO userPackageDAO;

	@Autowired
	GymPackageDAO gymPackageDAO;

	@Autowired
	UserDAO userDAO;

	@Override
	public UserPackageDTO createUserPackage(UserPackageDTO userPackageDTO) {
		try {
			if (userPackageDTO != null && userPackageDTO.getUserId() != null
					&& userPackageDTO.getGymPackageId() != null) {
				UserPackage userPackage = new UserPackage();

				userPackage.setUser(userDAO.get(userPackageDTO.getUserId()));
				GymPackage gymPackage = gymPackageDAO.get(userPackageDTO.getGymPackageId());
				userPackage.setGymPackage(gymPackage);

				Date currentDate = Calendar.getInstance().getTime();
				userPackage.setCreatedTime(currentDate);

				if (CommonUtil.validInteger(gymPackage.getExpiryDays())) {
					userPackage.setExpiryDate(CommonUtil.addDayToDate(currentDate, gymPackage.getExpiryDays()));
				}
				userPackage.setPurchaseDate(new Date());
				userPackage.setRemainingCredits(gymPackage.getCredits());
				userPackage.setStatus(CommonStatus.ACTIVE.getCode());

				Long userPackageId = userPackageDAO.saveWithId(userPackage);
				if (CommonUtil.validLong(userPackageId)) {
					userPackage = userPackageDAO.get(userPackageId);
					return new UserPackageDTO(userPackage);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserPackageDTO getUserPackageByUser(Long userId) {
		if (userId != null) {
			UserPackage userPackage = userPackageDAO.get(userId);
			if (userPackage != null) {
				return new UserPackageDTO(userPackage);
			}
		}
		return null;
	}

}
