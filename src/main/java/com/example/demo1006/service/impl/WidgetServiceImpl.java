package com.example.demo1006.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Widget;
import com.example.demo1006.repository.WidgetDao;
import com.example.demo1006.service.ifs.WidgetService;

@Service
public class WidgetServiceImpl implements WidgetService{

	@Autowired
	public WidgetDao widgetDao;
	
	
	@Override
	public Widget save() {
		Widget widget = new Widget();
		widget.setName("AAA");
		return widgetDao.save(widget);
	}

}
