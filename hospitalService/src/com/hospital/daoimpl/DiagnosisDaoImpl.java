package com.hospital.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.BaseDao;
import com.hospital.model.Diagnosis;
import com.hospital.model.User;
import com.hospital.util.DaoUtil;

public class DiagnosisDaoImpl implements BaseDao<Diagnosis>{
	private Connection conn;
	private Statement stat;

	public boolean delete(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("delete from diagnosis where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Diagnosis get(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		Diagnosis diagnosis = null;
		try {
			ResultSet rs = stat.executeQuery("select * from diagnosis where id="+id);
			while (rs.next()){
				Diagnosis temp = new Diagnosis();
				temp.setId(rs.getInt(1));
				temp.setWeek(rs.getInt(2));
				temp.setDoctorId(rs.getInt(3));
				diagnosis = temp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diagnosis;
	}

	public boolean save(Diagnosis t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("insert into diagnosis(week,doctor_id) values('"+
					t.getWeek()+"','"+t.getDoctorId()+"')");
			conn.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Diagnosis t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("update diagnosis set week="+t.getWeek()+",doctor_id="+t.getDoctorId());
			conn.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Diagnosis> getAll() {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		List<Diagnosis> list = new ArrayList<Diagnosis>();
		try {
			ResultSet rs = stat.executeQuery("select * from diagnosis");
			while (rs.next()){
				Diagnosis temp = new Diagnosis();
				temp.setId(rs.getInt(1));
				temp.setWeek(rs.getInt(2));
				temp.setDoctorId(rs.getInt(3));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
