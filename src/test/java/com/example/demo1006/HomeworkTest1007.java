package com.example.demo1006;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1006.entity.Menu;
import com.example.demo1006.service.ifs.OrderService;

@SpringBootTest
public class HomeworkTest1007 {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void addMenuTest() {
		List<Menu> menuList = new ArrayList<>();
		menuList.add(new Menu("beef", 100));
		menuList.add(new Menu("prok", 90));
		menuList.add(new Menu("chicken", 80));
		orderService.addMenu(menuList);
	}
	

	@Test
	public void printOrder() {
		Map<Menu, Integer> menuOrder = new HashMap<>();
		menuOrder.put(new Menu("beef", 100), 2);
		menuOrder.put(new Menu("prok", 90), 3);
		menuOrder.put(new Menu("chicken", 80), 4);
		orderService.printOrder(menuOrder);
		orderService.getTotalPtice(menuOrder);
	}
	
	@Test
	public void getPriceByFoodName() {
		List<Menu> menuList = new ArrayList<Menu>();
		menuList.add(new Menu("beef", 100));
		menuList.add(new Menu("pork", 90));
		menuList.add(new Menu("chicken", 80));
		orderService.getPriceByFoodName(menuList, "chicken");
	}
	
	

}
