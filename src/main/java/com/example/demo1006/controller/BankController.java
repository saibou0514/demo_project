package com.example.demo1006.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1006.entity.Bank;
import com.example.demo1006.service.ifs.BankService;
import com.example.demo1006.vo.BankReq;
import com.example.demo1006.vo.BankRes;
import com.example.demo1006.vo.DepositReq;
import com.example.demo1006.vo.DepositRes;
import com.example.demo1006.vo.WithdrawReq;
import com.example.demo1006.vo.WithdrawRes;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;

	@PostMapping(value = "/api/createAccount") 
	public Bank createAccount(@RequestBody BankReq bankReq){
		return bankService.createAccount(bankReq.getAccount());
		
	}
	
	
	
	@PostMapping(value = "/api/getAmount") 
	public BankRes getAmount(@RequestBody BankReq request){
		BankRes res = new BankRes();
		if(!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Amount is empty!帳號不得為空!");
			return res;
//			資料庫有勾主鍵其實可以不用寫這段，差別是有寫不用進資料庫才判斷
		}
		Bank bank = bankService.getAmount(request.getAccount());
		if(bank == null) {
			res.setMessage("no no,錯誤!");
			return res;
		}
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("新增成功");
		return res;
	}

	
	@PostMapping(value = "/api/deposit") 
	public DepositRes deposit(@RequestBody DepositReq depositReq) {
		DepositRes res = new DepositRes();
		if(!StringUtils.hasText(depositReq.getAccount())) {
			res.setMessage("Amount is empty!");
			return res;
		}
		if(depositReq.getDepositAmount() < 0) {
			res.setMessage("Amount is negtive!");
			return res;
		}
		
		Bank bank = bankService.deposit(depositReq.getAccount(), depositReq.getDepositAmount());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("Successful");
		return res;
	}
	

	@PostMapping(value = "/api/withdraw") 
	public WithdrawRes withdraw(WithdrawReq withdrawReq) { //  映對 mapping
		WithdrawRes res = new WithdrawRes();
		if(!StringUtils.hasText(withdrawReq.getAccount())) {
			res.setMessage("Account is empty!");
			return res;
		}
		if(withdrawReq.getWithdrawAmount() < 0) {
			res.setMessage("Amount is negative!");
			return res;
		}
		return bankService.withdraw(withdrawReq.getAccount(), withdrawReq.getWithdrawAmount());
	}
	
	
	@PostMapping(value = "/api/get")
	public void getAmount(@RequestParam Map<String, String> parameters) {
		System.out.println(parameters.get("id"));
		System.out.println(parameters.get("sId"));
		
	}
	
	@PostMapping(value = "/api/deletAccount")
	public void deletAccount(String account) throws Exception {
		bankService.deletAccount(account);
	}
	
	@PostMapping(value = "/api/deleteByName")
	public void deleteByName(@RequestBody BankReq req)  {
		bankService.deleteByName(req.getName());
	}
}
