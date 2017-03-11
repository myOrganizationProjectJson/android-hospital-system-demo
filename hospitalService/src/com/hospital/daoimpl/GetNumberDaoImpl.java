package com.hospital.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.BaseDao;
import com.hospital.model.Doctor;
import com.hospital.model.GetNumber;
import com.hospital.model.User;
import com.hospital.util.DaoUtil;

public class GetNumberDaoImpl implements BaseDao<GetNumber>{

	private Connection conn;
	private Statement stat;
	
	/*///********************/
	public GetNumber findByUserId(int userId){
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		GetNumber getNumber = new GetNumber();
		try {
			ResultSet rs = stat.executeQuery("select * from getnumber where user_id="+userId);
			while (rs.next()){
				getNumber.setId(rs.getInt(1));
				getNumber.setDate(rs.getDate(2));
				getNumber.setUserId(rs.getInt(3));
				getNumber.setDoctorId(rs.getInt(4));
			}
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return getNumber;
	}
	
	public boolean delete(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("delete from getnumber where id="+id);
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public GetNumber get(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		GetNumber getNumber = null;
		try {
			ResultSet rs = stat.executeQuery("select * from getnumber where id="+id);
			while (rs.next()){
				GetNumber temp = new GetNumber();
				temp.setId(rs.getInt(1));
				temp.setDate(rs.getDate(2));
				temp.setUserId(rs.getInt(3));
				temp.setDoctorId(rs.getInt(4));
				getNumber = temp;
			}
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getNumber;
	}

	public boolean save(GetNumber t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("insert into getNumber(date,user_id,doctor_id) values('"+
					t.getDate()+"',"+t.getUserId()+","+t.getDoctorId()+
					")");
			conn.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(GetNumber t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("update getNumber set date='"+t.getDate()+"',user_id="
					+t.getUserId()+",doctor_id='"+t.getDoctorId()+"' where id="+t.getId());
			conn.close();
			stat.close();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public List<GetNumber> getAll() {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		ArrayList<GetNumber> list = new ArrayList<GetNumber>();
		try {
			ResultSet rs = stat.executeQuery("select * from getnumber");
			while (rs.next()){
				GetNumber temp = new GetNumber();
				temp.setId(rs.getInt(1));
				temp.setId(rs.getInt(1));
				temp.setDate(rs.getDate(2));
				temp.setUserId(rs.getInt(3));
				temp.setDoctorId(rs.getInt(4));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
