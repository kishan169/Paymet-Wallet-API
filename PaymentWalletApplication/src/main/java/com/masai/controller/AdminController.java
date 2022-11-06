package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dtos.Admin;
import com.masai.dtos.AdminDto;
import com.masai.model.PaymentMode;
import com.masai.model.SessionUser;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.result.ResultRevenueType;
import com.masai.result.ResultSetType;
import com.masai.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody AdminDto dto){
		Admin admin = adminService.createAdminDetails(dto);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
	@GetMapping("/admin/custom")
	public ResponseEntity<List<Object[]>> getAllCustom(){
		List<Object[]> transactions = adminService.getCustomTransaction();
		return new ResponseEntity<List<Object[]>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/admin/type/{tp}")
	public ResponseEntity<List<Transaction>> getAllTransctionBYType(@PathVariable("tp") TransactionType type){
		List<Transaction> transactions = adminService.getAllTransactionByType(type);
		return new ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/admin/type/monthly/{tp}")
	public ResponseEntity<List<ResultSetType>> getMonnthlyTransctionBYType(){
		List<ResultSetType> transactions = adminService.findMonthlyTransactionByType();
		return new ResponseEntity<List<ResultSetType>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/admin/type/monthly/revenue/type")
	public ResponseEntity<List<ResultRevenueType>> getMonnthlyTransctionBYTypeRevenue(){
		List<ResultRevenueType> transactions = adminService.findMonthlyRevenueByType();
		return new ResponseEntity<List<ResultRevenueType>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/admin/mode/{tp}")
	public ResponseEntity<List<Transaction>> getAllTransctionBYMode(@PathVariable("tp") PaymentMode mode){
		List<Transaction> transactions = adminService.getAllTransactionByMode(mode);
		return new ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);
	}
	
	@GetMapping("/admin/users")
	public ResponseEntity<List<SessionUser>> getAllAtiveUser(){
		List<SessionUser> transactions = adminService.getAllActiveUser();
		return new ResponseEntity<List<SessionUser>>(transactions,HttpStatus.OK);
	}
}
