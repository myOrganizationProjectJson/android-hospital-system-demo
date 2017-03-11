package com.hospital.servlet.doctorservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.daoimpl.DoctorDaoImpl;
import com.hospital.model.Doctor;
import com.hospital.util.GsonUtil;

public class DoctorFindServlet extends HttpServlet {

	public DoctorFindServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
		String type = request.getParameter("type");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<Doctor> list = doctorDaoImpl.getDoctorByType(type);
		String json = GsonUtil.getGson().toJson(list);
		out.print(json);
		
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
