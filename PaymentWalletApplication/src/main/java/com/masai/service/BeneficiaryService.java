package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.dtos.BankDto;
import com.masai.dtos.BeneficiaryDto;
import com.masai.model.Bank;
import com.masai.model.Beneficiary;

public interface BeneficiaryService {
	
	public Beneficiary addBeneficiary(BeneficiaryDto beneficiary,String uniqueId) throws LoginException;
	
	public Bank addBankBeneficiary(BankDto bank,String uniqueId);
	
	public String deleteBeneficiaryDetails(String uniqueId, String mobile) throws LoginException;
	
	public List<Beneficiary> getAllBeneficiary(String uniqueId) throws LoginException; 
}
