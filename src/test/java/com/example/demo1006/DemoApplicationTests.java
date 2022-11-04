package com.example.demo1006;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1006.controller.BankController;
import com.example.demo1006.vo.BankReq;

@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private BankController bankController;
	
	@Test
	public void bankControllerTest() {
		BankReq req = new BankReq();
	}

}
