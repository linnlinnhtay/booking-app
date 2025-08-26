package com.lin.booking.service.user;

import com.lin.booking.dto.user.UserDTO;

public interface UserService {

	UserDTO checkAuth(String email, String password);

	UserDTO updateToken(UserDTO userDTO);

}
