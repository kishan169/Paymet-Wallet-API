package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, Integer>{
	
	public Beneficiary findByBeneficiaryMobile(String mobile);
}
