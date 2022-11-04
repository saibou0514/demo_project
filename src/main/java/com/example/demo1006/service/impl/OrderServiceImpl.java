package com.example.demo1006.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Menu;
import com.example.demo1006.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private Map<String,Integer> menuMap = new HashMap<>();

	@Override
//	穝糤繺翴の基
	public void addMenu(List<Menu> menuList) {
		for(Menu item : menuList) {
		menuMap.put(item.getName(), item.getPrice());
		System.out.println("穝糤繺翴嘿: " + item.getName() + "基: " + item.getPrice());
		}
	}

	@Override
//	眔繺翴羆基
	public int getTotalPtice(Map<Menu, Integer> itemMap) {
		int totalPrice = 0;
		for (Entry<Menu, Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey(); //繺翴嘿碻吏
			int itemPrice = menu.getPrice(); //虫珇兜基
			int num = item.getValue(); //计
			totalPrice += itemPrice * num; //羆基
		}
		if(totalPrice >= 500) {
			int price = (int)(totalPrice*0.9);
			System.out.println("繺翴骸500じゴч羆肂: " + price + "じ");
			return price;
		}else {
			System.out.println("羆肂: " + totalPrice + "じ");
			return totalPrice;
		}
	}


	@Override
//	繺翴 计 虫珇基 璹虫羆基
	public void printOrder(Map<Menu, Integer> itemMap) {
		for (Entry<Menu, Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey();
			System.out.println("繺翴" + menu.getName() + ":" 
			+ item.getValue()+" "+(menu.getPrice()*item.getValue())+"じ");
		}
		
	}

	@Override
//	ノ繺翴嘿т基
	public void getPriceByFoodName(List<Menu> menuList, String name) {
		for(Menu item : menuList) {
			if(name.equalsIgnoreCase(item.getName())) {
				System.out.println(item.getName()+"基: "+item.getPrice()+"じ");
				return;
			}
		}System.out.println("⊿Τ'"+name+"'繺翴");
		
	}
	


}
