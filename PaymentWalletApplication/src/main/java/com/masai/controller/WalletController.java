package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BankException;
import com.masai.exception.UserException;
import com.masai.exception.WalletException;
import com.masai.model.Bank;
import com.masai.model.Transaction;
import com.masai.service.WalletService;

@CrossOrigin(origins = "*")
@RestController
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	@GetMapping("/user/{id}/bank")
	public ResponseEntity<Bank> getBankDetails(@PathVariable("id") String uniqueId) throws LoginException{
		Bank bank =  walletService.getLinkBankAccount(uniqueId);
		return new ResponseEntity<Bank>(bank,HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}/wallet/{am}")
	public ResponseEntity<String> addBalanceToWallet(@PathVariable("id") String uniqueID ,@PathVariable("am") Double amount) throws LoginException, BankException{
		String message =  walletService.addBalancetoWallet(uniqueID, amount);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}/bank/{am}")
	public ResponseEntity<String> transferWallettoBank(@PathVariable("id") String uniqueId , @PathVariable("am") Double amount) throws LoginException{
		String message = walletService.addbalancetoBankfromWallet(uniqueId, amount);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}/mobile/{mb}/{am}")
	public ResponseEntity<Transaction> transferWallettoWallet(@PathVariable("id") String uniqueId ,@PathVariable("mb") String mobile, @PathVariable("am") Double amount) throws LoginException, UserException, WalletException{
		Transaction message = walletService.transafertoWallet(uniqueId, mobile, amount);
		return new ResponseEntity<Transaction>(message,HttpStatus.OK);
	}
}
