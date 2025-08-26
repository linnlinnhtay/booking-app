package com.lin.booking.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.user.UserDAO;
import com.lin.booking.dto.user.UserDTO;
import com.lin.booking.entity.user.User;
import com.lin.booking.util.common.CommonUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public UserDTO checkAuth(String email, String password) {
		UserDTO dto = null;
		User entity = userDAO.validUser(email, password);
		if (entity != null) {
			dto = new UserDTO(entity);
		}
		return dto;
	}

	@Override
	public UserDTO updateToken(UserDTO userDTO) {

		User user = null;
		if (CommonUtil.validLong(userDTO.getUserId())) {
			user = userDAO.get(userDTO.getUserId());
			user.setToken(userDTO.getToken());
			user.setUpdatedTime(new Date());
		}

		userDAO.update(user);

		return new UserDTO(user);
	}

}
