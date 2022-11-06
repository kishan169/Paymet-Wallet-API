package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SessionUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;
	
	private String uuid;
	
	private Integer userId;
	
	private LocalDateTime timestamp;

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public SessionUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionUser(Integer sessionId, String uuid, Integer userId, LocalDateTime timestamp) {
		super();
		this.sessionId = sessionId;
		this.uuid = uuid;
		this.userId = userId;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "SessionUser [sessionId=" + sessionId + ", uuid=" + uuid + ", userId=" + userId + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
}
