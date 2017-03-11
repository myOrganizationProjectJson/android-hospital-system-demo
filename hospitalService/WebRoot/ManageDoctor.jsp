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
        <title>医生管理界面</title>
        </head>
        <body>
        <h1 align="center">医生管理</h1>
        <hr>
      	<%
                    String sql = "select * from doctor";
                    DaoUtil db = new DaoUtil();
                    Connection conn = DaoUtil.getConnection();
					Statement state = DaoUtil.getStatement(conn);
					ResultSet rs = null;
					try {
							rs = state.executeQuery("select * from doctor");
	} 					catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
                    rs.last();
                    int i = rs.getRow();
        %>
        <p><font size="4">医院现有注册医生<%=i%>名的信息如下:</font></p>
        <center>
            <table border="1" bordercolor="blue">
                <td align="center" >医生编号</td>
                <td align="center">姓名</td>
                <td align="center" width=200>信息</td>
                <td align="center">科室</td>
              <%
                            rs.beforeFirst();
                            while (rs.next()) {
                                int Id = rs.getInt(1);
                                String name = rs.getString(2);
                                String info = rs.getString(3);
                                String type=rs.getString(4);
                %>
              
                <tr>
                <td align="center" width="80"><%=Id%></td>
                <td align="center" width="80"><%=name%></td>
                <td align="center" width="80"><%=info%></td>
                <td align="center" width="80"><%=type%></td>
                </td>
                </tr>
                 <%}
                    %>
            </table>
            <br>
            <a href="AddDoctor.jsp">添加医生</a>||<a href="DelDoctor.jsp">删除医生</a>
        </center>
</body>
</html>
