package com.example.demo1006.service.ifs;

import com.example.demo1006.entity.Bank;
import com.example.demo1006.vo.WithdrawRes;

public interface BankService {
	
	public Bank getAmount(String account);
	
	public Bank deposit(String account, int depositAmount);
	
	public WithdrawRes withdraw(String account, int withdrawAmount);
	
	public Bank createAccount(String account);

	public void deletAccount(String account) throws Exception;
	
	public void deleteByName(String name);
}