package com.masai.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.UserDto;
import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.model.Wallet;
import com.masai.repository.UserDao;
import com.masai.repository.WalletDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private WalletDao walletDao;

	@Override
	public User createNewUser(UserDto dto) throws UserException {
		
		Optional<User> optionalUser = userDao.findByMobile(dto.getMobile());
		
		if(optionalUser.isPresent()) throw new UserException("User is already exist with these mobile Number");
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		
		Wallet wallet = new Wallet();
		wallet.setBalance(0.0);
		Wallet wall =  walletDao.save(wallet);
		
		user.setWallet(wallet);
		User savedUser = userDao.save(user);
		
		return savedUser;
	}

	@Override
	public User updateUserDetails(Integer userId, UserDto dto) {
		Optional<User> userOptional = userDao.findById(userId);
		
		User user = userOptional.get();
		
		BeanUtils.copyProperties(dto, user);
		User savedUser = userDao.save(user);
		return savedUser;
	}
}
