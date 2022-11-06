package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SessionUser;

public interface SessionDao extends JpaRepository<SessionUser, Integer>{
	
	public Optional<SessionUser> findByUuid(String uniqueId);
	
	public Optional<SessionUser> findByUserId(Integer userId);
	
}
