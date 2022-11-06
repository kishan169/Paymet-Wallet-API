package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtos.LoginDto;
import com.masai.exception.UserException;
import com.masai.model.SessionUser;
import com.masai.model.User;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public String loginAccount(LoginDto dto) throws UserException, LoginException {
		
		Optional<User> useroptional =  userDao.findByMobile(dto.getMobile());
		
		if(!useroptional.isPresent()) throw new UserException("You have to create Account ");
		
		Optional<SessionUser> sessionUser =  sessionDao.findByUserId(useroptional.get().getUserId());
		
		if(sessionUser.isPresent()) throw new LoginException("User is already login!");
		
		if(dto.getMobile().equals(useroptional.get().getMobile()) &&
				dto.getPassword().equals(useroptional.get().getPassword())){
			
			SessionUser session = new SessionUser();
			session.setTimestamp(LocalDateTime.now());
			session.setUserId(useroptional.get().getUserId());
			String key =  RandomString.make(6);
			session.setUuid(key);
			
			SessionUser loginUser =  sessionDao.save(session);
			
			return loginUser.toString();
		}else
			throw new LoginException("Mobile and password didn't match!");
		
	}

	@Override
	public String logoutAccount(String uniqueId) throws LoginException {
		
		Optional<SessionUser> sessionUser =  sessionDao.findByUuid(uniqueId);
		
		if(!sessionUser.isPresent()) throw new LoginException("User is not logged in");
		
		sessionDao.delete(sessionUser.get());
		
		return "Deleted";
	}

}
