package com.example.demo1006;

import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Active;
import com.example.demo1006.entity.Bird;
@Service
public class Homework1006 implements Active {
	
	@Override
	public Bird fly(String name, int age) {
		Bird bird = new Bird();
		bird.setName(name);
		bird.setAge(age);
		System.out.println(name + "¥¿¦b­¸~");
		System.out.println("age: " + bird.getAge());

		return bird;
	}

}
