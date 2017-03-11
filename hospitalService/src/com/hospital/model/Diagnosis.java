package com.hospital.model;

// 排诊表对应的实体类
public class Diagnosis {
	private int id;  // 字段名
	private int week;  // 星期
	private int doctorId;  // 医生Id
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
