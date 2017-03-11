<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户信息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="servlet/UserAddServlet" method="post">
    <h3 align="center">添加用户信息</h3>
<p>用户姓名：<input name="userName" type="text" /></p>
<p>密码：<input name="password" type="password" /></p>
<p>真实姓名：<input name="trueName" type="text" /></p>
<p><input name="" type="submit" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></p>

</form>
  </body>
</html>
