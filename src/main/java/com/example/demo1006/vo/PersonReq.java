package com.example.demo1006.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonReq {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("age")
	private  int age;
	
	@JsonProperty("name")
	private  String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
