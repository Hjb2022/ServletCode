<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
</head>
<body style="text-align: center; background-color: #F0F8FF;">
	<table
		style="text-align: center; width: 40%; font-size: 27px; margin-left: 550px">
		<tr>
			<td><a href="/BookStore/AdminBookInfoServlet">图书管理</a></td>
			<td><a href="/BookStore/AdminUserInfoServlet">用户管理</a></td>
			<td><a href="/BookStore/AdminOrderInfoServlet">订单管理</a></td>
		</tr>
	</table>
</body>
</html>