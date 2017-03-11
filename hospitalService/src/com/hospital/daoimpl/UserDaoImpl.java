package com.hospital.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.BaseDao;
import com.hospital.model.GetNumber;
import com.hospital.model.User;
import com.hospital.util.DaoUtil;


public class UserDaoImpl implements BaseDao<User>{
	private Connection conn;
	private Statement stat;
	public boolean delete(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("delete from user where id="+id);
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User get(int id) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		User user = null;
		try {
			ResultSet rs = stat.executeQuery("select * from user where id="+id);
			while (rs.next()){
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setTrueName(rs.getString(4));
				user = temp;
			}
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean save(User t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("insert into user(username,password,truename) values('"+
					t.getUserName()+"','"+t.getPassword()+"','"+t.getTrueName()+
					"')");
			conn.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(User t) {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		try {
			stat.executeUpdate("update user set username='"+t.getUserName()+"',password='"
					+t.getPassword()+"',truename='"+t.getTrueName()+"' where id="+t.getId());
			conn.close();
			stat.close();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<User> getAll() {
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		ArrayList<User> list = new ArrayList<User>();
		try {
			ResultSet rs = stat.executeQuery("select * from user");
			while (rs.next()){
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setTrueName(rs.getString(4));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public User loginCheck(String userName, String password){
		conn = DaoUtil.getConnection();
		stat = DaoUtil.getStatement(conn);
		User user = null;
		try {
			ResultSet rs = stat.executeQuery("select * from user where username='"+userName+"' AND password='"+password+"'");
			while (rs.next()){
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setTrueName(rs.getString(4));
				user = temp;
			}
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
