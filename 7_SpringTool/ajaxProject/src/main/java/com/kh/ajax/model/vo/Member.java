package com.kh.ajax.model.vo;

public class Member {
	private String userName;
	private String userId;
	private String userPwd;
	private int age;
	private String phone;
	
	public Member() {
		super();
	}
	
	public Member(String userName, String userId, String userPwd, int age, String phone) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.age = age;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", age=" + age
				+ ", phone=" + phone + "]";
	}
	
}
