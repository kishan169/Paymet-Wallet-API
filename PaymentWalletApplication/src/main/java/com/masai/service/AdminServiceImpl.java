package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.Admin;
import com.masai.dtos.AdminDto;
import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.repository.AdminDao;
import com.masai.repository.SessionDao;
import com.masai.repository.TransactionDao;
import com.masai.result.ResultRevenueMode;
import com.masai.result.ResultRevenueType;
import com.masai.result.ResultSetMode;
import com.masai.result.ResultSetType;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public Admin createAdminDetails(AdminDto dto) {
		Admin admin = new Admin();
		admin.setAdminName(dto.getAdminName());
		admin.setMobile(dto.getMobile());
		admin.setPassword(dto.getPassword());
		admin.setPost(dto.getPost());
		Admin savedAdmin =  adminDao.save(admin);
		return savedAdmin;
	}

	@Override
	public List<Transaction> getAllTransactionByType(TransactionType type) {
		Set<Transaction> trans = transactionDao.findByType(type);
		List<Transaction> transactions = new ArrayList<>(trans);
		return transactions;
	}

	@Override
	public List<Transaction> getAllTransactionByMode(PaymentMode mode) {
		Set<Transaction> trans = transactionDao.findByMode(mode);
		List<Transaction> transactions = new ArrayList<>(trans);
		return transactions;
	}

	@Override
	public List<SessionUser> getAllActiveUser() {
		List<SessionUser> users = sessionDao.findAll();
		return users;
	}

	@Override
	public Transaction updateTransaction(Integer transactionId, Transaction transaction) {
		Optional<Transaction> transactionOptional =  transactionDao.findById(transactionId);
		Transaction trans = transactionDao.save(transaction);
		return trans;
	}

	@Override
	public List<Object[]> getCustomTransaction() {
		return transactionDao.findByNameTime();
	}

	@Override
	public List<ResultSetType> findMonthlyTransactionByType() {
		List<Object[]> list =  transactionDao.findMonthlyTransactionByType();
		
		List<ResultSetType> result = new ArrayList<>();
		
		for(int i = 0 ; i<list.size() ; i++) {
			TransactionType type = (TransactionType) list.get(i)[0];
			Long number = (Long) list.get(i)[1];
			ResultSetType rst = new ResultSetType(type,number);
			result.add(rst);
		}
		return result;
	}

	@Override
	public List<ResultSetMode> findMonthlyTransactionByMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResultRevenueType> findMonthlyRevenueByType() {
		List<Object[]> list = transactionDao.findTotalRevenueByType();
		
		List<ResultRevenueType> result = new ArrayList<>();
		
		for(int i = 0 ; i<list.size() ; i++) {
			TransactionType type = (TransactionType) list.get(i)[0];
			Double number = (Double) list.get(i)[1];
			ResultRevenueType rst = new ResultRevenueType(type, number);
			result.add(rst);
		}
		return null;
	}

	@Override
	public List<ResultRevenueMode> findMonthlyRevenueByMode() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
