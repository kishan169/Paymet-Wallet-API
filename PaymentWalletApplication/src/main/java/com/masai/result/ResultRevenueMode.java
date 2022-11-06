package com.masai.result;

import com.masai.model.PaymentMode;

public class ResultRevenueMode {
	
	private PaymentMode mode;
	
	private Long amount;

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}



	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public ResultRevenueMode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultRevenueMode(PaymentMode mode, Long amount) {
		super();
		this.mode = mode;
		this.amount = amount;
	}
	
	
}
