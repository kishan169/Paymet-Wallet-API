package com.masai.controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.BankDto;
import com.masai.model.Bank;
import com.masai.service.BankService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/user/{id}/bank")
	public ResponseEntity<Bank> addBankToWallet(@Valid @RequestBody BankDto dto,@PathVariable("id") String uniqueId) throws LoginException{
		Bank bank = bankService.linkBankToWallet(dto, uniqueId);
		return new ResponseEntity<Bank>(bank,HttpStatus.CREATED);
	}
	
	@PatchMapping("/user/{id}/bank/{bid}")
	public ResponseEntity<Bank> updateBankToWallet(@Valid @RequestBody BankDto dto,@PathVariable("bid") Integer bankId, @PathVariable("id") String uniqueId) throws LoginException{
		Bank bank = bankService.updateBankDetail(dto, bankId, uniqueId);
		return new ResponseEntity<Bank>(bank,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}/bank/")
	public ResponseEntity<String> deleteBankToWallet(@PathVariable("id") String uniqueId) throws LoginException{
		String message = bankService.deleteBankFromWallet(uniqueId);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{id}/viewbank")
	public ResponseEntity<Bank> viewBankToWallet(@PathVariable("id") String uniqueId) throws LoginException{
		Bank message = bankService.viewBankDetails(uniqueId);
		return new ResponseEntity<Bank>(message,HttpStatus.CREATED);
	}
	
	
}
