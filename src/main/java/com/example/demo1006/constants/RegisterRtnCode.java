package com.example.demo1006.constants;

public enum RegisterRtnCode {
//	�򥻦C�|
	SUCCESSFUL("200", "SUCCESSFULLLL"),
	ACCOUNT_REQUIRED("400", "Account is required! �b������"),
	PWD_REQUIRED("400", "Pwd is required! �K�X����"),
	NAME_REQUIRED("400", "Name is required! �W�r����"),
	ACCOUNT_EXISTED("403", "Account existed! �R��A�b���w�s�b"),
	FAILURE("500", "Account ����"),
	ADD_ROLE_FAILURE("400", "�s�W�}�⥢��"),
	ROLE_LIST_IS_EMPTY("400", "Role list is empty!");
	
	private String code;
	private String message;
	
//	�غc��k�Φb�W�����C�|
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
