package com.hospital.model;

import java.util.Date;

// �Һű��Ӧ��ʵ����
public class GetNumber {
	private int id;   // �ֶκ�
	private Date date;  // ʱ��
	private int userId; // �û�Id
	private int doctorId;  // ҽ��Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
