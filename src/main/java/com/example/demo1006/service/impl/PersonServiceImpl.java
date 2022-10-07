package com.example.demo1006.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Person;
import com.example.demo1006.service.ifs.PersonService;
@Service
public class PersonServiceImpl implements PersonService{

	@Override
	public Person getPersonInfo(String id) {
		Person person = new Person();
		person.setId(id);
		person.setName("²^®ða¦w¦w");
		person.setAge(22);
		person.setCity("Tainan");
		return person;
	}

}
