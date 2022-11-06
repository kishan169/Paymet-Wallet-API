package com.masai.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
	
	
	@Size(min=2,max=20,message="name length should be 2 to 20 digits")
	private String userName;
	
	@Size
	private String mobile;
	
	
	@Email
	private String email;
	
	
	@Size(min=6,max=16,message="Length of the password should be 6 to 16 digits")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String userName, String mobile, String email, String password) {
		super();
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	
}
