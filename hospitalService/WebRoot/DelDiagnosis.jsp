<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>删除排诊表信息界面</title>
    </head>
        <form action="servlet/DiagnosisDeleteServlet"" method="post">
            <h3 align="center">删除出诊表信息</h3>
            <hr>
        <center>请输入要删除的出诊表数据的编号：<input type="text" name="dianosisId"><br>
        <input type="submit" value="确认删除"><input type="reset" value="重新输入"></center>
        </form>
    </body>
</html>
