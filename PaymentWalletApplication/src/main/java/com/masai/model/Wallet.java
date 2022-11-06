package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer walletId;
	
	public Double balance;
	
	public Boolean status;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="bankId")
	public Bank bank;
	
	@JsonIgnore
	@OneToMany(mappedBy = "wallet")
	public Set<Transaction> transactions = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "wallet")
	public Set<Beneficiary> beneficiaries = new HashSet<>();

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Wallet(Integer walletId, Double balance, Bank bank, Set<Transaction> transactions,
			Set<Beneficiary> beneficiaries) {
		super();
		this.walletId = walletId;
		this.balance = balance;
		this.bank = bank;
		this.transactions = transactions;
		this.beneficiaries = beneficiaries;
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
