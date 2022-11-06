package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Bank;

public interface BankDao extends JpaRepository<Bank, Integer>{

}
