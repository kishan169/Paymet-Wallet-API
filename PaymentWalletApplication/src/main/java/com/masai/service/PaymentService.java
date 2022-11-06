package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.dtos.Payment;
import com.masai.exception.WalletException;
import com.masai.model.Transaction;

public interface PaymentService {
	
	public Transaction makePayment(Payment payment,String uniqueId) throws LoginException, WalletException;
}
