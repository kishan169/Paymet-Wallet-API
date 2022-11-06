package com.masai.service;

import java.util.List;

import com.masai.dtos.Admin;
import com.masai.dtos.AdminDto;
import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.result.ResultRevenueMode;
import com.masai.result.ResultRevenueType;
import com.masai.result.ResultSetMode;
import com.masai.result.ResultSetType;

public interface AdminService {
	
	public Admin createAdminDetails(AdminDto dto);
	
	public List<Transaction> getAllTransactionByType(TransactionType type);
	
	public List<Transaction> getAllTransactionByMode(PaymentMode mode);
	
	public List<SessionUser> getAllActiveUser();
	
	public Transaction updateTransaction(Integer transactionId, Transaction transaction);
	
	public List<Object[]> getCustomTransaction();
	
	public List<ResultSetType> findMonthlyTransactionByType();
	
	public List<ResultSetMode> findMonthlyTransactionByMode();
	
	public List<ResultRevenueType> findMonthlyRevenueByType();
	
	public List<ResultRevenueMode> findMonthlyRevenueByMode();
}
