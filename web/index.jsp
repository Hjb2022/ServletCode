<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>

<script type="text/javascript">
	function add(str1, str2, str3, str4) {
		var number = document.getElementById("number").value;
		var totalprice = str4 * number;
		if (number == "") {
			alert("数量不能为空！");
			return;
		} else if(number <= 0){
			alert("数量不能小于等于0！"); 
			return;
		} else {
			var url = "AddServlet?bookid=" + str1 + "&bookname="
					+ str2 + "&bookauthor=" + str3 + "&bookprice=" + totalprice
					+ "&booknum=" + number;
			window.location = url;
		}
	}
	
	function buy(str1, str2, str3, str4) {
		var number = document.getElementById("number").value;
		var totalprice = str4 * number;
		if (number == "") {
			alert("数量不能为空！");
			return;
		} else if(number <= 0){
			alert("数量不能小于等于0！"); 
			return;
		} else {
			var url = "BuyServlet?bookid=" + str1 + "&bookname="
					+ str2 + "&bookauthor=" + str3 + "&bookprice=" + totalprice
					+ "&booknum=" + number;
			window.location = url;
		}
	}
</script>
</head>
<body style="text-align: center; background-color: #F0F8FF;">
	<table
		style="text-align: center; width: 100%; font-size: 27px;">
		<tr>
			<td><a href="alertpwd.jsp">修改密码</a></td>
			<td><a href="/BookStore/SCartInfoServlet">查看购物车</a></td>
			<td><a href="/BookStore/OrderInfoServlet">查看订单</a></td>
			<td><a href="adminlogin.jsp">管理员登录</a></td>
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
				<th><input type="number" id="number" name="number"
					style="height: 35px; font-size: 27px" placeholder="请输入数量"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${booklist}">
				<tr>
					<td>${book.bookid}</td>
					<td>${book.bookname}</td>
					<td>${book.bookauthor}</td>
					<td>${book.bookprice}</td>
					<td><a href="javascript:add('${book.bookid }','${book.bookname }','${book.bookauthor }','${book.bookprice }')">加购</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="javascript:buy('${book.bookid }','${book.bookname }','${book.bookauthor }','${book.bookprice }')">购买</a>
					</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>