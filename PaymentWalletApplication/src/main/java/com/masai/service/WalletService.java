package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.exception.BankException;
import com.masai.exception.UserException;
import com.masai.exception.WalletException;
import com.masai.model.Bank;
import com.masai.model.Transaction;

public interface WalletService {
	
	public Bank getLinkBankAccount(String uniqueId) throws LoginException;
	
	public String addBalancetoWallet(String uniqueId, Double amount) throws LoginException, BankException;
	
	public String addbalancetoBankfromWallet(String uniqueId , Double amount) throws LoginException;
	
	public Transaction transafertoWallet(String uniqueId,String mobile ,Double amount) throws LoginException, UserException, WalletException;
}
