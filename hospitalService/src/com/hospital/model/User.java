package com.hospital.model;

// User���Ӧ��ʵ����
public class User {
	private int id;   // �ֶκ�
	private String userName;  // �û���
	private String password;  // ����
	private String trueName;  // ��ʵ����
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
