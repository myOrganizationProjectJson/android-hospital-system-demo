<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>删除用户信息界面</title>
    </head>
        <form action="servlet/UserDeleteServlet"" method="post">
            <h3 align="center">删除用户</h3>
            <p align="right"> <a href="ManageUser.jsp">返回用户管理首页</a></p>
            <hr>
        <center>请输入要删除的用户的编号：<input type="text" name="userId"><br>
        <input type="submit" value="确认删除"><input type="reset" value="重新输入"></center>
        </form>
    </body>
</html>
