package com.masai.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BeneficiaryDto {
	
	@NotNull
	@Size(min=2,max=20,message="name length should be 2 to 20 digits")
	private String beneficiaryName;
	
	
	private String beneficiaryMobile;

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryMobile() {
		return beneficiaryMobile;
	}

	public void setBeneficiaryMobile(String beneficiaryMobile) {
		this.beneficiaryMobile = beneficiaryMobile;
	}

	public BeneficiaryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeneficiaryDto(String beneficiaryName, String beneficiaryMobile) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryMobile = beneficiaryMobile;
	}
	
	
}
