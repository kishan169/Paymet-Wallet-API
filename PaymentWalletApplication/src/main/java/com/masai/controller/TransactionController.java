package com.masai.controller;


import java.util.List;
import java.util.Set;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.PaymentMode;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.service.TransactionService;

@CrossOrigin(origins = "*")
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/user/{id}/transactions")
	public ResponseEntity<Set<Transaction>> getAllTransaction(@PathVariable("id") String uniqueId) throws LoginException{
		Set<Transaction> transactions = transactionService.getAllTransaction(uniqueId);
		return new ResponseEntity<Set<Transaction>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/transactions/type/{tp}")
	public ResponseEntity<Set<Transaction>> getAllTransactionbyType(@PathVariable("id") String uniqueId ,@PathVariable("tp") TransactionType type) throws LoginException{
		Set<Transaction> transactions = transactionService.getAllTransactionByType(type, uniqueId);
		return new ResponseEntity<Set<Transaction>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/transactions/mode/{tp}")
	public ResponseEntity<Set<Transaction>> getAllTransactionbyMode(@PathVariable("id") String uniqueId ,@PathVariable("tp") PaymentMode mode) throws LoginException{
		Set<Transaction> transactions = transactionService.getAllTransactionByMode(mode, uniqueId);
		return new ResponseEntity<Set<Transaction>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/transactions/date/{sd}/{ed}")
	public ResponseEntity<List<Transaction>> getAllTransactionbetweenDates(@PathVariable("id") String uniqueId ,@PathVariable("sd") String startDate,@PathVariable("ed") String endDate) throws LoginException{
		List<Transaction> transactions = transactionService.getTransactionBetweenDates(startDate, endDate, uniqueId);
		return new ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);
	}
}
