package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.BankDto;
import com.masai.dtos.BeneficiaryDto;
import com.masai.model.Bank;
import com.masai.model.Beneficiary;
import com.masai.model.SessionUser;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.BeneficiaryDao;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;
import com.masai.repository.WalletDao;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	
	@Autowired
	private BeneficiaryDao beneficiaryDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private WalletDao walletDao;

	@Override
	public Beneficiary addBeneficiary(BeneficiaryDto beneficiary, String uniqueId) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		
		Beneficiary beneficiary2 = new Beneficiary();
		
		BeanUtils.copyProperties(beneficiary, beneficiary2);
		beneficiary2.setWallet(wallet);
		beneficiary2.setStatus(false);
		Beneficiary savedBeneficiary = beneficiaryDao.save(beneficiary2);
		wallet.getBeneficiaries().add(savedBeneficiary);
		walletDao.save(wallet);
		return savedBeneficiary;
	}

	@Override
	public Bank addBankBeneficiary(BankDto bank, String uniqueId) {
		
		return null;
	}

	@Override
	public String deleteBeneficiaryDetails(String uniqueId, String mobile) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		
		Beneficiary beneficiary = beneficiaryDao.findByBeneficiaryMobile(mobile);
		beneficiaryDao.delete(beneficiary);
		wallet.getBeneficiaries().remove(beneficiary);
		walletDao.save(wallet);
		return "Deleted";
	}

	@Override
	public List<Beneficiary> getAllBeneficiary(String uniqueId) throws LoginException {
		Optional<SessionUser> sessionuserOptional = sessionDao.findByUuid(uniqueId);
		
		if(!sessionuserOptional.isPresent()) throw new LoginException("You have to login First! ");
		
		Optional<User> userOptional = userDao.findById(sessionuserOptional.get().getUserId());
		
		User user = userOptional.get();
		Wallet wallet = user.getWallet();
		
		List<Beneficiary> list = new ArrayList<>(wallet.getBeneficiaries());
		return list;
	}

	
}
