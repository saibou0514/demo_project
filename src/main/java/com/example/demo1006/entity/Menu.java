package com.example.demo1006.entity;

public class Menu {
	private String name;
	public int price;

	public Menu() {

	}

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
