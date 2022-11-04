package com.example.demo1006;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo1006.entity.Bank;

@SpringBootApplication
public class HomeworkUnitTest1011 {
	private Bank bank;

	@Test
	public void getAccount(Bank bank) {
		System.out.println("123");

	}

}
