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
//		�w�s�b�b��������U!
		if (registerDao.existsById(account)) { // existsById �^�ǥ��L��!findById �^�ǭ�!
			return null;
		}

		Register reg = new Register(account, pwd, name, age, city);
		reg.setRegTime(new Date()); // new Date() --> �t�η�e�ɶ�
//		reg.setActive(false); �]���w�]�Ofalse�ҥH�i���g Active��date type �O���L��
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
			// Set�h�����ưѼ�

			for (String str : roleList) {
				roleSet.add(str);
			}
			// �h��DB�̤w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���

			Register reg = regOp.get();
			String role = reg.getRole(); // �p�G�|���h�ӴN�Ρu,�v�Ϲj�A�Ҧp: aaa, bbb, ccc
			String[] roleArray = role.split(","); // �ΡA����
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
			// �h��DB�̤w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole(); // �p�G�|���h�ӴN�Ρu,�v�Ϲj�A�Ҧp: aaa, bbb, ccc
			String[] roleArray = role.split(","); // �ΡA����
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
