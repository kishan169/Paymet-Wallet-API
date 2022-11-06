package com.masai.result;

import com.masai.model.TransactionType;

public class ResultSetType {
	
	private TransactionType type;
	
	private Long count;

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public ResultSetType(TransactionType type, Long count) {
		super();
		this.type = type;
		this.count = count;
	}

	

	
	
	
	
}
