package com.example.demo1006.constants;

public enum RegisterRtnCode {
//	基本列舉
	SUCCESSFUL("200", "SUCCESSFULLLL"),
	ACCOUNT_REQUIRED("400", "Account is required! 帳號為空"),
	PWD_REQUIRED("400", "Pwd is required! 密碼為空"),
	NAME_REQUIRED("400", "Name is required! 名字為空"),
	ACCOUNT_EXISTED("403", "Account existed! 靜止，帳號已存在"),
	FAILURE("500", "Account 失敗"),
	ADD_ROLE_FAILURE("400", "新增腳色失敗"),
	ROLE_LIST_IS_EMPTY("400", "Role list is empty!");
	
	private String code;
	private String message;
	
//	建構方法用在上面的列舉
	private RegisterRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
