<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/admin.css" type="text/css"></link>
  
  <link rel="stylesheet" href="css/basic.css" type="text/css"></link>
  <link rel="stylesheet" href="css/left.css" type="text/css"></link></head>
  
  <body style="background-color:#9999cc; color:#ffffff">
	<!-- ���νṹ -->
		<div id="PARENT" style="background-color:#9999cc; color:#ffffff">
			<ul id="nav">
				<li><a href="ManageDoctor.jsp" target=rightframe1>����ҽ��</a></li>
			</ul>
			
			<ul id="nav">
				<li><a href="ManageUser.jsp" target=rightframe1>�����û�</a></li>
			</ul>
			
			<ul id="nav">
				<li><a href="ManageDiagnosis.jsp" target=rightframe1>���������</a></li>
			</ul>
			
			<ul id="nav">
				<li><a href="ManageGetNumber.jsp" target=rightframe1>����Һű�</a></li>
			</ul>
			
			

			
        </div>
	</body>
</html>
