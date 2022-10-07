package com.example.demo1006;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1006.entity.Bird;

@SpringBootTest
class Demo1006ApplicationTests {

	@Autowired
	private Homework1006 hom;

	@Test
	void contextLoads() {
	}

	@Test
	public void activeTest() {
		hom.fly("¦w¦w", 5);
	}
}
