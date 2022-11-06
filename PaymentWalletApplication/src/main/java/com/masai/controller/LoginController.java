package com.masai.controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.LoginDto;
import com.masai.exception.UserException;
import com.masai.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/user/login")
	public ResponseEntity<String> loginToAccount(@Valid @RequestBody LoginDto dto) throws LoginException, UserException{
		String message =  loginService.loginAccount(dto);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user/logout")
	public ResponseEntity<String> logoutToAccount(String uniqueId) throws LoginException, UserException{
		String message =  loginService.logoutAccount(uniqueId);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
}
