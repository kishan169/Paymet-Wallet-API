package com.masai.controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.Payment;
import com.masai.exception.WalletException;
import com.masai.model.Transaction;
import com.masai.service.PaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PutMapping("user/{id}/payment")
	public ResponseEntity<Transaction> makePaymentfromWallet(@Valid @RequestBody Payment payment ,@PathVariable("id") String uniqueId) throws LoginException, WalletException{
		Transaction transaction = paymentService.makePayment(payment, uniqueId);
		return new ResponseEntity<Transaction>(transaction,HttpStatus.ACCEPTED);
	}
}
