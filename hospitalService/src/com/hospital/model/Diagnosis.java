package com.hospital.model;

// ������Ӧ��ʵ����
public class Diagnosis {
	private int id;  // �ֶ���
	private int week;  // ����
	private int doctorId;  // ҽ��Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
}
