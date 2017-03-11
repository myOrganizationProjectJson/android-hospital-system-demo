package com.hospital.servlet.getnumberservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.GetNumberDaoImpl;
import com.hospital.daoimpl.UserDaoImpl;
import com.hospital.model.GetNumber;
import com.hospital.model.User;

public class GetNumbeUpdateServlet extends HttpServlet {

	public GetNumbeUpdateServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charSet=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		GetNumberDaoImpl getNumberDaoImpl = new GetNumberDaoImpl();
		GetNumber getNumber= new GetNumber();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int id =Integer.parseInt(request.getParameter("id"));
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		String dateS = request.getParameter("date");
		
		Date.valueOf(dateS); 
		getNumber.setId(id);
		getNumber.setUserId(userId);
		getNumber.setDoctorId(doctorId);
	
		getNumberDaoImpl.update(getNumber);

		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
