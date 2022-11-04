package com.example.demo1006.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1006.constants.RegisterRtnCode;
import com.example.demo1006.entity.Register;
import com.example.demo1006.repository.RegisterDao;
import com.example.demo1006.service.ifs.RegisterService;
import com.example.demo1006.vo.RegisterRes;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
//		已存在帳號不能註冊!
		if (registerDao.existsById(account)) { // existsById 回傳布林值!findById 回傳值!
			return null;
		}

		Register reg = new Register(account, pwd, name, age, city);
		reg.setRegTime(new Date()); // new Date() --> 系統當前時間
//		reg.setActive(false); 因為預設是false所以可不寫 Active的date type 是布林值
		reg.setRole("General");
		return registerDao.save(reg);

	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			return new RegisterRes(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();
			// Set去除重複參數

			for (String str : roleList) {
				roleSet.add(str);
			}
			// 去除DB裡已存在的值和參數的值，兩者的重複部分

			Register reg = regOp.get();
			String role = reg.getRole(); // 如果會有多個就用「,」區隔，例如: aaa, bbb, ccc
			String[] roleArray = role.split(","); // 用，分割
			for (String item : roleArray) {
				String str = item.trim();
				roleSet.add(str);
			}
//			System.out.println(roleSet.toString());
//			StringBuffer newStrBuf = new StringBuffer();
//			for(String item : roleSet) {
//				newStrBuf.append(item.trim());
//			}
			String newStr = roleSet.toString().substring(1, roleSet.toString().length() - 1);

			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRoleSet(String account, Set<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();
			// 去除DB裡已存在的值和參數的值，兩者的重複部分
			Register reg = regOp.get();
			String role = reg.getRole(); // 如果會有多個就用「,」區隔，例如: aaa, bbb, ccc
			String[] roleArray = role.split(","); // 用，分割
			for (String item : roleArray) {
				String str = item.trim();
				roleSet.add(str);
			}
			String newStr = roleSet.toString().substring(1, roleSet.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			RegisterRes res = new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
			return res;
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

}
