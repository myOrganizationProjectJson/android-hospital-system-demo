package com.hospital.servlet.getnumberservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hospital.daoimpl.GetNumberDaoImpl;
import com.hospital.model.GetNumber;
import com.hospital.util.GsonUtil;

public class GetNumberFindServlet extends HttpServlet {

	public GetNumberFindServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		GetNumberDaoImpl getNumberDaoImpl = new GetNumberDaoImpl();
		int userId = Integer.parseInt(request.getParameter("userId"));
		GetNumber getNumber = getNumberDaoImpl.findByUserId(userId);
		
		out.print(GsonUtil.getGson().toJson(getNumber));
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
