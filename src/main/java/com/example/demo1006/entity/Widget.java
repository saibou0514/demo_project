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
//	IDENTITY 主鍵由資料庫自動增長(一定用在主鍵!!)  --所以記得在資料庫要把主鍵 AUTO_INCREMENT 打勾--
//	ID序號不會回頭，就算刪了也一樣
	
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
