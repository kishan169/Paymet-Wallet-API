package com.masai.result;

import com.masai.model.PaymentMode;

public class ResultSetMode {
	
	private PaymentMode mode;
	
	private Long count;

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public ResultSetMode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultSetMode(PaymentMode mode, Long count) {
		super();
		this.mode = mode;
		this.count = count;
	}
	
	
}
