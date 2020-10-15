<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update">
	用户名：<input type="text" name="name" value="${user.name }">
	密码：<input  type="password" name="password" value="${user.password }">
	存款：<input  type="text" name="qian" value="${user.qian }">	
	日期：<input  type="date" name="date" value="${user.date }">	
	<input  type="hidden" name="id" value="${user.id }">
	<input type="submit">
	</form>

</body>
</html>