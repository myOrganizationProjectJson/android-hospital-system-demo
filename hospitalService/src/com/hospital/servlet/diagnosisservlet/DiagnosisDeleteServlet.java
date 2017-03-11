package com.hospital.servlet.diagnosisservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.DiagnosisDaoImpl;
import com.hospital.daoimpl.DoctorDaoImpl;

public class DiagnosisDeleteServlet extends HttpServlet {

	public DiagnosisDeleteServlet() {
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
		
		int dianosisId = Integer.parseInt(request.getParameter("dianosisId"));
		DiagnosisDaoImpl diagnosisDaoImpl = new DiagnosisDaoImpl();
		diagnosisDaoImpl.delete(dianosisId);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int dianosisId = Integer.parseInt(request.getParameter("dianosisId"));
		DiagnosisDaoImpl diagnosisDaoImpl = new DiagnosisDaoImpl();
		diagnosisDaoImpl.delete(dianosisId);
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
