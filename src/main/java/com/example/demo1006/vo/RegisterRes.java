package com.example.demo1006.vo;

import com.example.demo1006.entity.Register;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRes {
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JsonProperty("register_info")
	private Register register;
	
	private String message;

	public RegisterRes() {
		
	}

	public RegisterRes(Register register, String message) {
		this.register = register;
		this.message = message;
	}
	
	public RegisterRes(String message) {
		this.message = message;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
