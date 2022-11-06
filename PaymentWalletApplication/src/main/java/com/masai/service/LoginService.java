package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.dtos.LoginDto;
import com.masai.exception.UserException;

public interface LoginService {
	
	public String loginAccount(LoginDto dto) throws UserException, LoginException;
	
	public String logoutAccount(String uniqueId) throws LoginException;
}
