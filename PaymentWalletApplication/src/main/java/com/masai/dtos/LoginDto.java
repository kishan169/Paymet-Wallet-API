package com.masai.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDto {
	
	
	private String mobile;
	
	@NotNull
	@Size(min=6,max=16,message="Length of the password should be 6 to 16 digits")
	private String password;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
