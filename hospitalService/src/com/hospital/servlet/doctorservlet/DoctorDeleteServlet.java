package com.hospital.servlet.doctorservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.DoctorDaoImpl;


public class DoctorDeleteServlet extends HttpServlet {

	public DoctorDeleteServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
		doctorDaoImpl.delete(doctorId);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
		doctorDaoImpl.delete(doctorId);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
