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
//	�s�W�\�I�λ���
	public void addMenu(List<Menu> menuList) {
		for(Menu item : menuList) {
		menuMap.put(item.getName(), item.getPrice());
		System.out.println("�s�W�\�I�W��: " + item.getName() + "����: " + item.getPrice());
		}
	}

	@Override
//	���o�\�I�`����
	public int getTotalPtice(Map<Menu, Integer> itemMap) {
		int totalPrice = 0;
		for (Entry<Menu, Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey(); //�\�I�W�ٴ`��
			int itemPrice = menu.getPrice(); //��~��������
			int num = item.getValue(); //����
			totalPrice += itemPrice * num; //�`����
		}
		if(totalPrice >= 500) {
			int price = (int)(totalPrice*0.9);
			System.out.println("�\�I��500���A���E��C�`���B��: " + price + "��");
			return price;
		}else {
			System.out.println("�`���B��: " + totalPrice + "��");
			return totalPrice;
		}
	}


	@Override
//	�L�X�\�I ���� ��~���� �q���`����
	public void printOrder(Map<Menu, Integer> itemMap) {
		for (Entry<Menu, Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey();
			System.out.println("�\�I" + menu.getName() + ":" 
			+ item.getValue()+"���A�@ "+(menu.getPrice()*item.getValue())+"��");
		}
		
	}

	@Override
//	���\�I�W�٧����
	public void getPriceByFoodName(List<Menu> menuList, String name) {
		for(Menu item : menuList) {
			if(name.equalsIgnoreCase(item.getName())) {
				System.out.println(item.getName()+"�����欰: "+item.getPrice()+"��");
				return;
			}
		}System.out.println("�S���W��'"+name+"'���\�I");
		
	}
	


}
