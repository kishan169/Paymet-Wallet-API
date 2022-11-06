package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.BankDto;
import com.masai.model.Bank;
import com.masai.model.SessionUser;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.BankDao;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;
import com.masai.repository.WalletDao;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Bank linkBankToWallet(BankDto dto, String uniqueId) throws LoginException {
		
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Bank bank = new Bank();
		
		BeanUtils.copyProperties(dto, bank);
		
		Bank bankSaved= bankDao.save(bank);
		wallet.setBank(bankSaved);
		wallet.setStatus(true);
		walletDao.save(wallet);
		return bankSaved;
	}

	@Override
	public String deleteBankFromWallet(String uniqueId) throws LoginException {
		Optional<SessionUser> userOptional = sessionDao.findByUuid(uniqueId);
		if(!userOptional.isPresent()) throw new LoginException("You have to login First! ");
		return null;
	}

	@Override
	public Bank updateBankDetail(BankDto dto,Integer bankId, String uniqueId) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		Optional<Bank> bankOptional =  bankDao.findById(bankId);
		Bank bank = bankOptional.get();
		
		BeanUtils.copyProperties(dto, bank);
		Bank bankSaved= bankDao.save(bank);
		return bankSaved;
	}

	@Override
	public Bank viewBankDetails(String uniqueId) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		Bank bank = wallet.getBank();
		return null;
	}

}
