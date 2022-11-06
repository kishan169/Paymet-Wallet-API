package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.UserDto;
import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createNewUser(@Valid @RequestBody UserDto dto) throws UserException{
		User user = userService.createNewUser(dto);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@PatchMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable("id") Integer uniqueId,@Valid @RequestBody UserDto dto){
		User user = userService.updateUserDetails(uniqueId, dto);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	

}
