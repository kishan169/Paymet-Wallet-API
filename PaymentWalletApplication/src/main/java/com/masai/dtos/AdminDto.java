package com.masai.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminDto {
	
	@NotNull
	@Size(min=2,max=20,message="name length should be 2 to 20 digits")
	private String adminName;
	
	@NotNull
	@Size(min=6,max=16,message="Length of the password should be 6 to 16 digits")
	private String password;
	
	
	private String mobile;
	
	@NotNull
	private String post;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDto(String adminName, String password, String mobile, String post) {
		super();
		this.adminName = adminName;
		this.password = password;
		this.mobile = mobile;
		this.post = post;
	}
	
	
}
