package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.Payment;
import com.masai.exception.WalletException;
import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.SessionDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.UserDao;
import com.masai.repository.WalletDao;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Override
	public Transaction makePayment(Payment payment, String uniqueId) throws LoginException, WalletException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		Wallet wallet = userOptional.get().getWallet();
		
		if(payment.getAmount()>wallet.getBalance()) throw new WalletException("Not enough balance in wallet!");
		
		Transaction transaction = new Transaction();
		transaction.setAmount(payment.getAmount());
		transaction.setType(payment.getType());
		transaction.setMode(payment.getMode());
		transaction.setTransactionTime(LocalDateTime.now());
		transaction.setWallet(wallet);
		
		Transaction updatedTransaction = transactionDao.save(transaction);
		wallet.getTransactions().add(updatedTransaction);
		walletDao.save(wallet);
		return updatedTransaction;
	}
	
	
}
