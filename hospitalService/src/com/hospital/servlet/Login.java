package com.hospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.constant.MyConstant;
import com.hospital.model.User;
import com.hospital.util.DaoUtil;

public class Login extends HttpServlet {


	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if (username.equals(MyConstant.userName)){
			if (password.equals(MyConstant.password)){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../mainFram.jsp");
				requestDispatcher.forward(request, response);
				
			}
			else {
				PrintWriter pw = response.getWriter();
				pw.println("<script>alert('您输入的密码有误!')</script>");
				pw.println("<script>window.location.href='../Login.jsp';</script>");
				pw.flush();
				pw.close();
			}
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('您输入的帐号有误!')</script>");
			pw.println("<script>window.location.href='../Login.jsp';</script>");
			pw.flush();
			pw.close();
		}
		
			
		
		
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
