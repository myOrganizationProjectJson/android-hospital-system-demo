package com.hospital.servlet.diagnosisservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.DiagnosisDaoImpl;
import com.hospital.daoimpl.UserDaoImpl;
import com.hospital.model.Diagnosis;
import com.hospital.model.User;

public class DiagnosisUpdateServlet extends HttpServlet {

	public DiagnosisUpdateServlet() {
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
		DiagnosisDaoImpl diagnosisDaoImpl = new DiagnosisDaoImpl();
		Diagnosis diagnosis= new Diagnosis();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		int week = Integer.parseInt(request.getParameter("week"));
		
		diagnosis.setId(id);
		diagnosis.setWeek(week);
		diagnosis.setDoctorId(doctorId);

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
