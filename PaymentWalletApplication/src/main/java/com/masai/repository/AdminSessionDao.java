package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SessionAdmin;

public interface AdminSessionDao extends JpaRepository<SessionAdmin	, Integer>{

}
