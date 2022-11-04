package com.example.demo1006.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Bank;
import com.example.demo1006.entity.Person;
import com.example.demo1006.repository.BankDao;
import com.example.demo1006.service.ifs.BankService;
import com.example.demo1006.vo.WithdrawRes;


@Service
public class BankServiceIpml implements BankService{
	
	@Autowired
	private BankDao bankDao;
	
	
	@Override
	public Bank createAccount(String account) { //建立帳號
		Bank bank = new Bank();
		bank.setAccount(account);
		return bankDao.save(bank);
	}

	@Override
	public Bank getAmount(String account) { //顯示帳號+餘額
		return bankDao.findById(account).orElse(new Bank());
	}

	@Override
	public Bank deposit(String account, int depositAmount) { //存款
		Optional<Bank> bankOp = bankDao.findById(account);
		if(depositAmount < 0) {
			return new Bank();
		}
		return bankOp.orElse(new Bank());
	}

	@Override
	public WithdrawRes withdraw(String account, int withdrawAmount) { //提款
		Optional<Bank> bankOp = bankDao.findById(account);
		int initAmount = 0;
		WithdrawRes res = new WithdrawRes();
		
		if(bankOp.isPresent()) {
			bankOp.get();
			
			if(withdrawAmount > initAmount || withdrawAmount < 0) {
				res.setMessage("餘額不足或提領金額有誤，請重新操作。");
				return res;
			}
		
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(initAmount + withdrawAmount);
		res.setAccount(account);
		res.setAmount(initAmount - withdrawAmount); 
		res.setMessage("Successful");
		return res;
		}else {
			res.setMessage("錯");
		}
		return res;
	}

	@Transactional
//	用意:當對資料庫操作多筆資料增刪改時，為確保變更資料不會因為中途出錯導致全部丟失或是新增不完全而做的保護措施
//	效果:整筆成功 or 整筆失敗
//	--常用在多筆資料--
	
	@Override
	public void deletAccount(String account) throws Exception {
		bankDao.deleteById(account);
		System.out.println("成功刪除帳號");
		throw new RuntimeException("Error!");
		
		
	}
	
//	@Transactional
	@Override
	public void deleteByName(String name) {
		bankDao.deleteByName(name);
		System.out.println("成功刪除帳號");
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void getAmount(Bank bank) {
//		String aa = bank.getAccount();
//		aa = "ds6548531";
//		int mm = bank.getAmount();
//		mm = 123561316;
//		System.out.println("帳號: " + aa + " ,餘額: " + mm);
//	}
//
//	@Override
//	public void deposit(Bank bank, int depositAmount) {
//		int mm = bank.getAmount();
//		depositAmount = mm + 1000;
//		System.out.println("存款後餘額: " + depositAmount);
//	}
//
//	@Override
//	public void withdraw(Bank bank, int withdrawAmount) {
//		int mm = bank.getAmount();
//		withdrawAmount = mm - 1000;
//		System.out.println("提款後餘額: " + withdrawAmount);
//	}
//	
//	@Override
//	public Bank getAmount(String account) {
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(1000);
//		return bank;
//	}

}
