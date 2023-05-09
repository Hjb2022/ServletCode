<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
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
	<hr>
	<table style="text-align: center; width: 100%; font-size: 27px">
		<thead>
			<tr>
				<th>订单编号</th>
				<th>购买用户</th>
				<th>书本编号</th>
				<th>书本名称</th>
				<th>书本作者</th>
				<th>书本总价</th>
				<th>书本总数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${orderlist}">
				<tr>
					<td>${order.orderid}</td>
					<td>${order.username}</td>
					<td>${order.bookid}</td>
					<td>${order.bookname}</td>
					<td>${order.bookauthor}</td>
					<td>${order.bookprice}</td>
					<td>${order.booknum}</td>
					<td><a
						href="/BookStore/AlertOrder?orderid=${order.orderid}&username=${order.username}&bookid=${order.bookid}&bookname=${order.bookname}&bookauthor=${order.bookauthor}&bookprice=${order.bookprice}&booknum=${order.booknum}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>