package com.masai.dtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	private String adminName;
	
	private String password;
	
	private String mobile;
	
	private String post;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

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

	public Admin(Integer adminId, String adminName, String password, String mobile, String post) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.mobile = mobile;
		this.post = post;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
