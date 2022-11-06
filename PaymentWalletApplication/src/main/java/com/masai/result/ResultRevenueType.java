package com.masai.result;

import com.masai.model.TransactionType;

public class ResultRevenueType {
	
	private TransactionType type;
	
	private Double revenue;

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

	public ResultRevenueType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultRevenueType(TransactionType type, Double revenue) {
		super();
		this.type = type;
		this.revenue = revenue;
	}

	
	
	
}
