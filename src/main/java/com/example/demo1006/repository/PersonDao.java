package com.example.demo1006.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1006.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, String>{ //繼承
	
	public List<Person> findByAgeGreaterThan(int age); //方法名稱規則 詳細在 PPT.02 P39
//	類似自訂，但命名規則要依照
	
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
	
}
