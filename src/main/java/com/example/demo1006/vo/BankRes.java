package com.example.demo1006.vo;

public class BankRes {
	
	private String account;
	private int amount;
	private String message;
	
	public BankRes() {
		
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
	
//	public Bank getAmount(String account) {
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(1000);
//		return bank;
//	}


}
