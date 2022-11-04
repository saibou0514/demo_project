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
	public Bank createAccount(String account) { //�إ߱b��
		Bank bank = new Bank();
		bank.setAccount(account);
		return bankDao.save(bank);
	}

	@Override
	public Bank getAmount(String account) { //��ܱb��+�l�B
		return bankDao.findById(account).orElse(new Bank());
	}

	@Override
	public Bank deposit(String account, int depositAmount) { //�s��
		Optional<Bank> bankOp = bankDao.findById(account);
		if(depositAmount < 0) {
			return new Bank();
		}
		return bankOp.orElse(new Bank());
	}

	@Override
	public WithdrawRes withdraw(String account, int withdrawAmount) { //����
		Optional<Bank> bankOp = bankDao.findById(account);
		int initAmount = 0;
		WithdrawRes res = new WithdrawRes();
		
		if(bankOp.isPresent()) {
			bankOp.get();
			
			if(withdrawAmount > initAmount || withdrawAmount < 0) {
				res.setMessage("�l�B�����δ�����B���~�A�Э��s�ާ@�C");
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
			res.setMessage("��");
		}
		return res;
	}

	@Transactional
//	�ηN:����Ʈw�ާ@�h����ƼW�R��ɡA���T�O�ܧ��Ƥ��|�]�����~�X���ɭP�����ᥢ�άO�s�W�������Ӱ����O�@���I
//	�ĪG:�㵧���\ or �㵧����
//	--�`�Φb�h�����--
	
	@Override
	public void deletAccount(String account) throws Exception {
		bankDao.deleteById(account);
		System.out.println("���\�R���b��");
		throw new RuntimeException("Error!");
		
		
	}
	
//	@Transactional
	@Override
	public void deleteByName(String name) {
		bankDao.deleteByName(name);
		System.out.println("���\�R���b��");
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void getAmount(Bank bank) {
//		String aa = bank.getAccount();
//		aa = "ds6548531";
//		int mm = bank.getAmount();
//		mm = 123561316;
//		System.out.println("�b��: " + aa + " ,�l�B: " + mm);
//	}
//
//	@Override
//	public void deposit(Bank bank, int depositAmount) {
//		int mm = bank.getAmount();
//		depositAmount = mm + 1000;
//		System.out.println("�s�ګ�l�B: " + depositAmount);
//	}
//
//	@Override
//	public void withdraw(Bank bank, int withdrawAmount) {
//		int mm = bank.getAmount();
//		withdrawAmount = mm - 1000;
//		System.out.println("���ګ�l�B: " + withdrawAmount);
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
