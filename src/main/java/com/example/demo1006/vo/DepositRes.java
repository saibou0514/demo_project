package com.example.demo1006.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositRes {
	
	private String account;
	
	private int amount;
	
	@JsonProperty("msg")
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DepositRes() {
		
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
