package com.example.demo1006.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawRes {
	
	private String account;

	private int amount;	
	
	@JsonProperty("msg")
	private String message;
	
	public WithdrawRes() {
		
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
