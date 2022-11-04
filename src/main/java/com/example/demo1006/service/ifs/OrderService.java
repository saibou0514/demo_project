package com.example.demo1006.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.demo1006.entity.Menu;

public interface OrderService {
	
	public void addMenu(List<Menu> menuList);
	
	public void getPriceByFoodName(List<Menu> menuList, String name);
	
	public int getTotalPtice(Map<Menu, Integer> itemMap);
	
	public void printOrder(Map<Menu, Integer> itemMap);




	
	
}
