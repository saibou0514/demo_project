package com.example.demo1006.service.ifs;

import java.util.List;

import com.example.demo1006.entity.Person;

public interface PersonService {

	public List<Person> getPersonInfo();
	
	public Person getPersonId(String id);
	
	public List<Person> getPersonInfoByAgeLargerThan(int age);
	
	public List<Person> getPersonByNameAndAgeGreaterThan(String name, int age);


}
