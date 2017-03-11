package com.hospital.model;

// User表对应的实体类
public class User {
	private int id;   // 字段号
	private String userName;  // 用户名
	private String password;  // 密码
	private String trueName;  // 真实姓名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
}
