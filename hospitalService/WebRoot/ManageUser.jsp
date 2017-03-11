<%@ page language="java" import="java.util.*,com.hospital.constant.*" pageEncoding="UTF-8"%>
<%@ page import = "com.hospital.util.DaoUtil" %>
<%@page import="java.sql.ResultSet"%>
<%@page import ="java.io.IOException"%>
<%@page import ="java.io.PrintWriter"%>
<%@page import ="java.sql.Connection"%>
<%@page import ="java.sql.ResultSet"%>
<%@page import ="java.sql.Statement"%>
<%@page import ="java.sql.SQLException"%>

<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户管理界面</title>
        </head>
        <body>
        <h1 align="center">用户管理</h1>
        <hr>
      	<%
                    String sql = "select * from user";
                    DaoUtil db = new DaoUtil();
                    Connection conn = DaoUtil.getConnection();
					Statement state = DaoUtil.getStatement(conn);
					ResultSet rs = null;
					try {
							rs = state.executeQuery("select * from user");
	} 					catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
                    rs.last();
                    int i = rs.getRow();
        %>
        <p><font size="4">该管理系统现有<%=i%>名用户，他们的信息如下:</font></p>
        <center>
            <table border="1" bordercolor="blue">
            	<td align="center">编号</td>
                <td align="center">用户名</td>
                <td align="center">真实姓名</td>
              <%
                            rs.beforeFirst();
                            while (rs.next()) {
                                int Id = rs.getInt(1);
                                String name = rs.getString(2);
                                String truename = rs.getString(4);
                %>
              
                <tr>
                <td align="center" width="80"><%=Id%></td>
                <td align="center" width="80"><%=name%></td>
                <td align="center" width="80"><%=truename%></td>
            
                </td>
                </tr>
                 <%}
                    %>
            </table>
            <br>
            <a href="AddUser.jsp">添加用户</a>||<a href="DelUser.jsp">删除用户</a>
        </center>
</body>
</html>
