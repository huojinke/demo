<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>存款</td>
			<td>日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.password }</td>
			<td>${user.qian }</td>
			<td>${user.date }</td>
			<td>
				<a href="selectById?id=${user.id}">修改</a>
				<a href="delete?id=${user.id}">删除</a>
			</td>
		</tr>	
		</c:forEach>	
		<a href="add.jsp">添加用户</a>
	</table>

</body>
</html>