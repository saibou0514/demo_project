package com.example.demo1006.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1006.entity.Bank;
import com.example.demo1006.entity.Widget;

@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	
@Transactional
public void deleteByName(String name);
	
	
//	<entity ���O�W�� , �D�ظ�ƫ��A>
//	dao�ΨӰ���ƳB�z
}
