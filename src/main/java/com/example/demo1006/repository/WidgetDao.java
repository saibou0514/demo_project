package com.example.demo1006.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1006.entity.Widget;

@Repository
public interface WidgetDao extends JpaRepository<Widget, Integer>{
	

}
