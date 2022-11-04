package com.example.demo1006.vo;

import java.util.List;
import java.util.Map;

import com.example.demo1006.entity.Bank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositReq {
	
	@JsonProperty("account")
	private String account;
	
	@JsonProperty("amount")
	private int depositAmount;
	
	
	private Bank bank;
	private List<String> list;
	private Map<String, Integer> map;
	
	
	public DepositReq() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	

}
