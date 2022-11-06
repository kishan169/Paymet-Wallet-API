package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private String ifscCode;
	
	@NotNull
	private String accountNumber;
	
	@NotNull
	private String branch;
	
	private Double balance;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="walletId")
	private Wallet wallet;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

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

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Bank(Integer bankId, String bankName, String ifscCode, String accountNumber, String branch, Double balance,
			Wallet wallet) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.balance = balance;
		this.wallet = wallet;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
