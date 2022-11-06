package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	
	private String beneficiaryName;
	
	private String beneficiaryMobile;
	
	private Boolean status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="walletId")
	private Wallet wallet;

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Beneficiary(Integer beneficiaryId, String beneficiaryName, String beneficiaryMobile, Boolean status,
			Wallet wallet) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryMobile = beneficiaryMobile;
		this.status = status;
		this.wallet = wallet;
	}

	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
