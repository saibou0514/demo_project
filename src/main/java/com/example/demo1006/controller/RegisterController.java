package com.example.demo1006.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1006.constants.RegisterRtnCode;
import com.example.demo1006.entity.Register;
import com.example.demo1006.service.ifs.RegisterService;
import com.example.demo1006.vo.AddRoleListReq;
import com.example.demo1006.vo.AddRoleSetReq;
import com.example.demo1006.vo.RegisterReq;
import com.example.demo1006.vo.RegisterRes;

@RestController
public class RegisterController {

	@Autowired
	public RegisterService registerService;

	@PostMapping(value = "/api/register")
	public RegisterRes register(@RequestBody RegisterReq req) {
		RegisterRes checkresult = checkParam(req);
		if (checkresult != null) {
			return checkresult;
		}
		Register reg = registerService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());
		if (reg == null) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}
		return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
	}

	@PostMapping(value = "/api/checkParam")
	private RegisterRes checkParam(RegisterReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new RegisterRes(RegisterRtnCode.PWD_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getName())) {
			return new RegisterRes(RegisterRtnCode.NAME_REQUIRED.getMessage());
		}
		return null;
	}
	
	@PostMapping(value = "/api/active_account")
	public RegisterRes activeAccount(@RequestBody RegisterReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		return registerService.activeAccount(req.getAccount());
	}
	
	@PostMapping(value = "/api/add_role_list")
	public RegisterRes addRoleList(@RequestBody AddRoleListReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		if(req.getRoleList().isEmpty()) {
			return new RegisterRes(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}
		return registerService.addRole(req.getAccount(), req.getRoleList());
	}
	
	
	@PostMapping(value = "/api/add_role_set")
	public RegisterRes addRoleSet(@RequestBody AddRoleSetReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if(req.getRoleSet() == null || req.getRoleSet().isEmpty()) {
		if(CollectionUtils.isEmpty(req.getRoleSet())) {
			return new RegisterRes(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}
		return registerService.addRoleSet(req.getAccount(), req.getRoleSet());
	}
	
	
}
