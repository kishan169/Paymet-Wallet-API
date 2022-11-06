package com.masai.service;

import com.masai.dtos.UserDto;
import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {
	
	public User createNewUser(UserDto dto) throws UserException;
	
	public User updateUserDetails(Integer userId, UserDto dto);
}
