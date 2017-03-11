package com.hospital.servlet.getnumberservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.GetNumberDaoImpl;
import com.hospital.model.GetNumber;
import com.hospital.model.User;

public class GetNumberAddServlet extends HttpServlet {

	public GetNumberAddServlet() {
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
		GetNumberDaoImpl getNumberDaoImpl = new GetNumberDaoImpl();
		int userId = Integer.parseInt(request.getParameter("userId"));
		int doctorId = Integer.parseInt( request.getParameter("doctorId"));
		java.util.Date d = new java.util.Date();
		Date date = new Date(d.getYear(), d.getMonth(), d.getDay());
		GetNumber getnumber = new GetNumber();
		getnumber.setDate(date);
		getnumber.setDoctorId(doctorId);
		getnumber.setUserId(userId);
		getNumberDaoImpl.save(getnumber);
		
	
		}
	


	public void init() throws ServletException {
		// Put your code here
	}

}
