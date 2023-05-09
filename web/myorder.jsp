<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>
<body style="text-align: center; background-color: #F0F8FF;">
	<table style="text-align: center; width: 100%; font-size: 27px;">
		<tr>
			<td><a href="index.jsp">返回首页</a></td>
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
				<th>购买数量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${orderlist}">
				<tr>
					<td>${order.bookid}</td>
					<td>${order.bookname}</td>
					<td>${order.bookauthor}</td>
					<td>${order.bookprice}</td>
					<td>${order.booknum}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>