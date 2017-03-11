package com.hospital.servlet.diagnosisservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.DiagnosisDaoImpl;
import com.hospital.daoimpl.DoctorDaoImpl;
import com.hospital.model.Diagnosis;

public class DiagnosisAddServlet extends HttpServlet {

	public DiagnosisAddServlet() {
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
		Diagnosis diagnosis = new Diagnosis();
		DiagnosisDaoImpl diagnosisDaoImpl = new DiagnosisDaoImpl();
		
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));

		int week = Integer.parseInt(request.getParameter("week"));
	
		diagnosis.setWeek(week);
		
		diagnosis.setDoctorId(doctorId);
		
		diagnosisDaoImpl.save(diagnosis);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
