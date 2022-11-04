package com.example.demo1006.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawReq {

	@JsonProperty("withdraw_amount")
	private String account;
	
	@JsonProperty("amount")
	private int withdrawAmount;
	
	public WithdrawReq() {
		
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(int depositAmount) {
		this.withdrawAmount = depositAmount;
	}
	
	
}
