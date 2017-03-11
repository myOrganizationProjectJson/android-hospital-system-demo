package com.hospital.model;

import java.util.Date;

// 挂号表对应的实体类
public class GetNumber {
	private int id;   // 字段号
	private String date;  // 时间
	private int userId; // 用户Id
	private int doctorId;  // 一声Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
}
