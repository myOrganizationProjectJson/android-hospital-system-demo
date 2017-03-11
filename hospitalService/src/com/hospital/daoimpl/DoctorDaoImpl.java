package com.hospital.daoimpl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.BaseDao;
import com.hospital.model.Diagnosis;
import com.hospital.model.Doctor;
import com.hospital.model.User;
import com.hospital.util.DaoUtil;

// Doctor数据库操作的实现类
public class DoctorDaoImpl implements BaseDao<Doctor>{

	private Connection conn;
	private Statement stat;
	/////////////////////////////////////////////////////////
	/*******************************************************/
	public List<Doctor> getDoctorByType(String type) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		System.out.print(type);
		try {
			type = new String(type.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		try {
			ResultSet rs = stat.executeQuery("select * from doctor where type='" + type + "'");
			while (rs.next()){
				Doctor temp = new Doctor();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setInfo(rs.getString(3));
				temp.setType(rs.getString(4));
				list.add(temp);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean delete(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("delete from doctor where id="+id);
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Doctor get(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		Doctor doctor = null;
		try {
			ResultSet rs = stat.executeQuery("select * from doctor where id="+id);
			while (rs.next()){
				Doctor temp = new Doctor();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setInfo(rs.getString(3));
				temp.setType(rs.getString(4));
				doctor = temp;
			}
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctor;
	}

	public boolean save(Doctor t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("insert into doctor(name,info,type) values('"+
					t.getName()+"','"+t.getInfo()+"','"+t.getType()+
					"')");
			conn.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Doctor t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("update doctor set name='"+t.getName()+"',info='"
					+t.getInfo()+"',type='"+t.getType()+"' where id="+t.getId());
			conn.close();
			stat.close();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public List<Doctor> getAll() {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		try {
			ResultSet rs = stat.executeQuery("select * from doctor");
			while (rs.next()){
				Doctor temp = new Doctor();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setInfo(rs.getString(3));
				temp.setType(rs.getString(4));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
