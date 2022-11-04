package com.example.demo1006.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "widget")
public class Widget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
//	IDENTITY �D��Ѹ�Ʈw�۰ʼW��(�@�w�Φb�D��!!)  --�ҥH�O�o�b��Ʈw�n��D�� AUTO_INCREMENT ����--
//	ID�Ǹ����|�^�Y�A�N��R�F�]�@��
	
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "name")
	public String name;
	
	
	
	public Widget() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
