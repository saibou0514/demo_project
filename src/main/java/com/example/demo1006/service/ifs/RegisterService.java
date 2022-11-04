package com.example.demo1006.service.ifs;

import java.util.List;
import java.util.Set;

import com.example.demo1006.entity.Register;
import com.example.demo1006.vo.RegisterRes;

public interface RegisterService {
	
	public Register register(String account, String pwd, String name, int age, String city);//�s�W�b��
	
	public RegisterRes activeAccount(String account);//�E���b��
	
	public RegisterRes addRole(String account, List<String> roleList);//�s�W�}��

	public RegisterRes addRoleSet(String account, Set<String> roleList);
}
