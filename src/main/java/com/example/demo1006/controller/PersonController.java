package com.example.demo1006.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1006.entity.Person;
import com.example.demo1006.service.ifs.PersonService;
import com.example.demo1006.vo.PersonReq;
import com.example.demo1006.vo.PersonRes;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService  personService;
	
	@PostMapping(value = "/api/getPersonInfo")
	public List<Person> getPersonInfo() {
		List<Person> personList = personService.getPersonInfo();
		return personList;
	}
	
	@PostMapping(value = "/api/getPersonId")
	public Person getPersonId(@RequestBody PersonReq req) {
		return personService.getPersonId(req.getId());
	}
	
	@PostMapping(value = "/api/getPersonByAge")
	public List<Person> getPersonInfoByAgeLargerThan(@RequestBody PersonReq req){
		
		List<Person> personList = personService.getPersonInfoByAgeLargerThan(req.getAge());
		List<Person> list = new ArrayList<>();
		list.addAll(personService.getPersonInfoByAgeLargerThan(req.getAge()));
		return personList;
	}
	
	@PostMapping(value = "/api/getPersonByNameAndAge")
	public List<Person> getPersonByNameAndAge(@RequestBody PersonReq req){
		
		return personService.getPersonByNameAndAgeGreaterThan(req.getName(), req.getAge());
		
	}

}
