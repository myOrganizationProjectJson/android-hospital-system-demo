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
	// ���ύ�ͻ��˼��
	function doSubmit(){
		if (document.myform.loginname.value==""){
			alert("�û�������Ϊ�գ�");
			document.myform.loginname.focus();
			return false;
		}
		if (document.myform.loginpwd.value==""){
			alert("���벻��Ϊ�գ�");
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
		alert("��������ȷ���û���������");
	<%
		}
	}
	%>
</SCRIPT>

  </head>

<body id="login" onload=javascript:window.myform.loginname.focus() >
  <form action="servlet/Login" name="myform" method="post" id="loginForm">
	<h3>ҽԺԤԼ�Һ�ϵͳ��̨��¼����</h3>
	<label for="userName"><span>�û�����</span><input id="username" name="username" type="text" /></label>
	<label for="passWord"><span>���룺</span><input id="loginpwd" name="password" type="password" /></label>
	<label id="submit"><input name="button1" type="submit" class="bt" value="��¼" onclick="return doSubmit()"/>
	<input type="button" class="bt" value="�ر�" onclick="window.close();"/>
	</label>
</form>
<p id="siteCopyRight"></p>
</body>
</html>
