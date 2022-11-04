package com.example.demo1006.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1006.entity.Widget;
import com.example.demo1006.service.ifs.WidgetService;

@RestController
public class WidgetController {
	
	@Autowired
	private WidgetService widgetService;
	
	@PostMapping(value = "/api/saveWidget")
	public Widget save() {
		return widgetService.save();
		
	}

}
