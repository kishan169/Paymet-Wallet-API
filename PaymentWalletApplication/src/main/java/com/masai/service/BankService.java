package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.dtos.BankDto;
import com.masai.model.Bank;

public interface BankService {
	
	public Bank linkBankToWallet(BankDto dto,String uniqueId) throws LoginException;
	
	public String deleteBankFromWallet(String uniqueId) throws LoginException;
	
	public Bank viewBankDetails(String uniqueId) throws LoginException;
	
	public Bank updateBankDetail(BankDto dto ,Integer bankId, String uniqueId) throws LoginException;
}
