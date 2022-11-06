package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SessionAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer adminId;
	
	private String uniqueId;
	
	private LocalDateTime time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public SessionAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionAdmin(Integer id, Integer adminId, String uniqueId, LocalDateTime time) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.uniqueId = uniqueId;
		this.time = time;
	}
	
	
}
