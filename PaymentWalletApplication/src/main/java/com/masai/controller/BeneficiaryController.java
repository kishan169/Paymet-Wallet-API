package com.masai.controller;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.BeneficiaryDto;
import com.masai.model.Beneficiary;
import com.masai.service.BeneficiaryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class BeneficiaryController {
	
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@PostMapping("/user/{id}/beneficiary")
	public ResponseEntity<Beneficiary> addBeneficiaryToWallet(@PathVariable("id") String uniqueId,@Valid @RequestBody BeneficiaryDto dto) throws LoginException{
		Beneficiary beneficiary =  beneficiaryService.addBeneficiary(dto, uniqueId);
		return new ResponseEntity<Beneficiary>(beneficiary,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}/beneficiary/{mo}")
	public ResponseEntity<String> deleteBeneficiaryByMobile(@PathVariable("id") String uniqueId , @PathVariable("mo") String mobile) throws LoginException{
		String message = beneficiaryService.deleteBeneficiaryDetails(uniqueId, mobile);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/beneficiary")
	public ResponseEntity<List<Beneficiary>> getAllBeneficiary(String uniqueId) throws LoginException{
		List<Beneficiary> beneficiaries =  beneficiaryService.getAllBeneficiary(uniqueId);
		return new ResponseEntity<List<Beneficiary>>(beneficiaries,HttpStatus.OK);
	}
}
