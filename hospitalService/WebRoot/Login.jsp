<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="css/style.css" type="text/css"></link>
  <SCRIPT language=JavaScript>
	// 表单提交客户端检测
	function doSubmit(){
		if (document.myform.loginname.value==""){
			alert("用户名不能为空！");
			document.myform.loginname.focus();
			return false;
		}
		if (document.myform.loginpwd.value==""){
			alert("密码不能为空！");
			document.myform.loginpwd.focus();
			return false;
		}
		document.myform.submit();
	}
	<%
	int fail = 0;
	if(request.getAttribute("fail")!=null){
		fail = Integer.valueOf(request.getAttribute("fail").toString());
		if(fail==1){
	%>
		alert("请输入正确的用户名和密码");
	<%
		}
	}
	%>
</SCRIPT>

  </head>

<body id="login" onload=javascript:window.myform.loginname.focus() >
  <form action="servlet/Login" name="myform" method="post" id="loginForm">
	<h3>医院预约挂号系统后台登录界面</h3>
	<label for="userName"><span>用户名：</span><input id="username" name="username" type="text" /></label>
	<label for="passWord"><span>密码：</span><input id="loginpwd" name="password" type="password" /></label>
	<label id="submit"><input name="button1" type="submit" class="bt" value="登录" onclick="return doSubmit()"/>
	<input type="button" class="bt" value="关闭" onclick="window.close();"/>
	</label>
</form>
<p id="siteCopyRight"></p>
</body>
</html>
