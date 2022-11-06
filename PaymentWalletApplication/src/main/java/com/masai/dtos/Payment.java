package com.masai.dtos;

import javax.validation.constraints.NotNull;

import com.masai.model.PaymentMode;
import com.masai.model.TransactionType;

public class Payment {
	
	private TransactionType type;
	
	@NotNull
	private Double amount;
	
	private PaymentMode mode;

	
	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(TransactionType type, Double amount, PaymentMode mode) {
		super();
		this.type = type;
		this.amount = amount;
		this.mode = mode;
	}

	
	
	
}
