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
        <title>排诊表管理界面</title>
        </head>
        <body>
        <h1 align="center">排诊表管理</h1>
        <hr>
      	<%
                    String sql = "select * from diagnosis";
                    DaoUtil db = new DaoUtil();
                    Connection conn = DaoUtil.getConnection();
					Statement state = DaoUtil.getStatement(conn);
					ResultSet rs = null;
					try {
							rs = state.executeQuery("select * from diagnosis");
	} 					catch (SQLException e1) {
		e1.printStackTrace();
	}
                    rs.last();
                    int i = rs.getRow();
        %>
        <p><font size="4">医院现有排诊表总共<%=i%>条详细信息如下:</font></p>
        <center>
            <table border="1" bordercolor="blue">
                <td align="center">排诊表编号</td>
                <td align="center">时间(星期)</td>
                <td align="center">医生编号</td>
              <%
                            rs.beforeFirst();
                            while (rs.next()) {
                                int id = rs.getInt(1);
                                int week = rs.getInt(2);
                                int doctorId = rs.getInt(3);
                %>
              
                <tr>
                <td align="center" width="80"><%=id%></td>
                <td align="center" width="80"><%=week%></td>
                <td align="center" width="80"><%=doctorId%></td>
                </td>
                </tr>
                 <%}
                    %>
            </table>
            <br>
            <a href="AddDiagnosis.jsp">添加记录</a>||<a href="DelDiagnosis.jsp">删除记录</a>
        </center>
</body>
</html>
