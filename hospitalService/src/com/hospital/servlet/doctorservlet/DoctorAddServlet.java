package com.hospital.servlet.doctorservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.constant.MyConstant;
import com.hospital.daoimpl.DoctorDaoImpl;
import com.hospital.model.Doctor;
import com.hospital.util.DaoUtil;



public class DoctorAddServlet extends HttpServlet {

	public DoctorAddServlet() {
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
		Doctor doctor = new Doctor();
		DoctorDaoImpl doctordaoimpl = new DoctorDaoImpl();
		
		String name = (String) request.getParameter("name");
		String info = (String) request.getParameter("info");
		String type = (String) request.getParameter("type");
		
		doctor.setName(name);
		doctor.setInfo(info);
		doctor.setType(type);
		
		doctordaoimpl.save(doctor);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
