package com.hospital.servlet.userservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.UserDaoImpl;
import com.hospital.model.User;
import com.hospital.util.GsonUtil;


public class UserAddServlet extends HttpServlet {

	public UserAddServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charSet=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		String trueName = (String) request.getParameter("trueName");
		User user = userDaoImpl.loginCheck(userName, password);
		if (user != null){
			out.println("fail");
		}
		else {
			user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setTrueName(trueName);
			if (userDaoImpl.save(user)){
				out.println("insert success");
			}
			else {
				out.println("insert failed");
			}
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
