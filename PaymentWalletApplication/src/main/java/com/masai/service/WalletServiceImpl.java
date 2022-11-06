package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BankException;
import com.masai.exception.UserException;
import com.masai.exception.WalletException;
import com.masai.model.Bank;
import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.BankDao;
import com.masai.repository.SessionDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.UserDao;
import com.masai.repository.WalletDao;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private TransactionDao transactionDao;

	@Override
	public String addBalancetoWallet(String uniqueId, Double amount) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Bank bank = wallet.getBank();
		
		if(bank==null) {
			throw new LoginException("bank Account is not linked to the wallet");
		}
		
		if(amount>bank.getBalance()) {
			throw new LoginException("bank has not enough money to transfer in wallet");
		}
		
		Double moneyB = bank.getBalance()+wallet.getBalance()+amount;
		bank.setBalance(bank.getBalance()-amount);
		wallet.setBalance(wallet.getBalance()+ amount);
		
		Bank ban = bankDao.save(bank);
		Wallet wall = walletDao.save(wallet);
		
		return "Wallet balance is : " + wallet.getBalance()+".";
	}

	@Override
	public String addbalancetoBankfromWallet(String uniqueId, Double amount) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Bank bank = wallet.getBank();
		
		if(bank==null) {
			throw new LoginException("bank Account is not linked to the wallet");
		}
		
		if(amount>wallet.getBalance()) {
			throw new LoginException("bank has not enough money to transfer in wallet");
		}
		
		Double moneyB = bank.getBalance()+wallet.getBalance()+amount;
		bank.setBalance(bank.getBalance()+amount);
		wallet.setBalance(wallet.getBalance()-amount);
		
		Bank ban = bankDao.save(bank);
		Wallet wall = walletDao.save(wallet);
		
		return "Wallet balance is : " + wallet.getBalance()+".";
	}

	@Override
	public Transaction transafertoWallet(String uniqueId,String mobile, Double amount) throws LoginException, UserException, WalletException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> receiver =  userDao.findByMobile(mobile);
		
		if(!receiver.isPresent()) throw new UserException("User is not register with these mobile Number");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Wallet receiverWallet = receiver.get().getWallet();
		
		if(amount>wallet.getBalance()) throw new WalletException("add balance to wallet");
		
		wallet.setBalance(wallet.getBalance()-amount);
		receiverWallet.setBalance(receiverWallet.getBalance()+amount);
		
		walletDao.save(wallet);
		walletDao.save(receiverWallet);
		
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setType(TransactionType.Wallet_To_Wallet);
		transaction.setMode(PaymentMode.Direct_Transfer);
		transaction.setTransactionTime(LocalDateTime.now());
		transaction.setWallet(wallet);
		
		Transaction updatedTransaction = transactionDao.save(transaction);
		
		wallet.getTransactions().add(updatedTransaction);
		walletDao.save(wallet);
		return updatedTransaction;
	}

	@Override
	public Bank getLinkBankAccount(String uniqueId) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Bank bank = wallet.getBank();
		return bank;
	}

	
	
	
}
