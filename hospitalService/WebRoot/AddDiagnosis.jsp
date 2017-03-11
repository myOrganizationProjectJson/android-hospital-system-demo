<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加排诊表信息界面</title>
    
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
    <form action="servlet/DiagnosisAddServlet" method="post">
    <h3 align="center">添加排诊表信息</h3>
  <tr>
      <th scope="row" >排诊时间</th>
      <td>
	  	<select name="week">
	 <option value="1">星期一</option>
		 <option value="2">星期二</option>
		 <option value="3">星期三</option>
		 <option value="4">星期四</option>
		  <option value="5">星期五</option>
		   <option value="6">星期六</option>
		    <option value="7">星期日</option>
    	</select>	  </td>
    </tr>
<p>医生编号：<input name="doctorId" type="text" /></p>
<p><input name="" type="submit" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></p>

</form>
  </body>
</html>
