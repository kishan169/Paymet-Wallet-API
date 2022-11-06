package com.masai.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.SessionDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.UserDao;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sessionDao;

	@Override
	public Set<Transaction> getAllTransaction(String uniqueID) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueID);
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		return wallet.getTransactions();
	}

	@Override
	public Set<Transaction> getAllTransactionByType(TransactionType type, String uniqueId) throws LoginException {
		Set<Transaction> transactions = this.getAllTransaction(uniqueId);
		return transactions.stream().filter(t->t.getType().equals(type)).collect(Collectors.toSet());
	}

	@Override
	public Set<Transaction> getAllTransactionByMode(PaymentMode mode, String uniqueId) throws LoginException {
		Set<Transaction> transactions = this.getAllTransaction(uniqueId);
		return transactions.stream().filter(t->t.getMode().equals(mode)).collect(Collectors.toSet());
	}

	@Override
	public List<Transaction> getTransactionBetweenDates(String startDate, String endDate, String uniqueId) throws LoginException {
		Set<Transaction> transactions = this.getAllTransaction(uniqueId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate start = LocalDate.parse(startDate, formatter);
		LocalDate end = LocalDate.parse(endDate, formatter);
		List<Transaction> transaction = new ArrayList<>(transactions);
		List<Transaction> trans = new ArrayList<>();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for(int i = 0 ; i<transaction.size() ; i++) {
			String str1 =  transaction.get(i).getTransactionTime().format(formatter2);
			LocalDate temp = LocalDate.parse(str1, formatter);
			if ((temp.isAfter(start) && temp.isBefore(end)) || temp.equals(start) || temp.equals(end)) {
				trans.add(transaction.get(i));
			}
		}
		return trans;
	}

	
}
