package com.masai.dtos;

public class BankDto {
	
	private String bankName;
	
	private String ifscCode;
	
	private String accountNumber;
	
	private String branch;
	
	private Double balance;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public BankDto(String bankName, String ifscCode, String accountNumber, String branch, Double balance) {
		super();
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.balance = balance;
	}

	public BankDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
