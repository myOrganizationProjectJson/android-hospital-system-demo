package com.hospital.servlet.getnumberservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.GetNumberDaoImpl;


public class GetNumberDeleteServlet extends HttpServlet {

	public GetNumberDeleteServlet() {
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
		int id = Integer.parseInt(request.getParameter("getNumberId"));
		GetNumberDaoImpl getNumberDaoImpl = new GetNumberDaoImpl();
		getNumberDaoImpl.delete(id);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
