package com.masai.service;

import java.util.List;
import java.util.Set;

import javax.security.auth.login.LoginException;

import com.masai.model.PaymentMode;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;

public interface TransactionService {
	
	public Set<Transaction> getAllTransaction(String uniqueID) throws LoginException;
	
	public Set<Transaction> getAllTransactionByType(TransactionType type,String uniqueId) throws LoginException;
	
	public Set<Transaction> getAllTransactionByMode(PaymentMode mode,String uniqueId) throws LoginException;
	
	public List<Transaction> getTransactionBetweenDates(String startDate,String endDate,String uniqueId) throws LoginException;
	
}
