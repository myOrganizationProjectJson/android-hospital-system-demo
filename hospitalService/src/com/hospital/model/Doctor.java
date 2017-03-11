package com.hospital.model;

// Doctor表的对应实例
public class Doctor {
	private int id;     // 字段号
	private String name;  // 姓名
	private String info;  // 信息
	private String type;  // 科室
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
