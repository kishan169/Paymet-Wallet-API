package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private Double amount;
	
	private LocalDateTime transactionTime;
	
	private TransactionType type;
	
	private PaymentMode mode;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "walletId")
	private Wallet wallet;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Transaction(Integer transactionId, Double amount, LocalDateTime transactionTime, TransactionType type,
			PaymentMode mode, Wallet wallet) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionTime = transactionTime;
		this.type = type;
		this.mode = mode;
		this.wallet = wallet;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
