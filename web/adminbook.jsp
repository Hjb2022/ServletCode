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
			<td><a href="adminaddbook.jsp">添加图书</a></td>
			<td><a href="/BookStore/AdminBookInfoServlet">图书管理</a></td>
			<td><a href="/BookStore/AdminUserInfoServlet">用户管理</a></td>
			<td><a href="/BookStore/AdminOrderInfoServlet">订单管理</a></td>
		</tr>
	</table>
	<hr>
	<table style="text-align: center; width: 100%; font-size: 27px">
		<thead>
			<tr>
				<th>书本编号</th>
				<th>书本名称</th>
				<th>书本作者</th>
				<th>书本价格</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${booklist}">
				<tr>
					<td>${book.bookid}</td>
					<td>${book.bookname}</td>
					<td>${book.bookauthor}</td>
					<td>${book.bookprice}</td>
					<td><a href="/BookStore/AlertBook?bookid=${book.bookid}&bookname=${book.bookname}&bookauthor=${book.bookauthor}&bookprice=${book.bookprice}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>