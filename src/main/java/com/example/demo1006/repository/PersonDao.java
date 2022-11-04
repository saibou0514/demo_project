package com.example.demo1006.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1006.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, String>{ //�~��
	
	public List<Person> findByAgeGreaterThan(int age); //��k�W�ٳW�h �ԲӦb PPT.02 P39
//	�����ۭq�A���R�W�W�h�n�̷�
	
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
	
}
