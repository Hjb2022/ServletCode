<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="text-align: center; background-color: #F0F8FF; font-size: 27px">
	<table style="text-align: center; width: 100%; font-size: 27px;">
		<tr>
			<td><a href="/BookStore/AdminOrderInfoServlet">返回</a></td>
		</tr>
	</table>
	<hr>
	<form action="/BookStore/AdminAlertOrderServlet" method="post">
		<div>
			<div>
				<label>订单编号</label><input readonly="readonly" id="orderid"
					name="orderid" style="height: 35px; font-size: 27px; margin-left: 10px" value="${orderid}"/>
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>购买用户</label><input readonly="readonly" id="username"
					name="username" style="height: 35px; font-size: 27px; margin-left: 10px" value="${username}"/>
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本编号</label><input readonly="readonly" id="bookid"
					name="bookid" style="height: 35px; font-size: 27px; margin-left: 10px" value="${bookid}"/>
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本名称</label><input id="bookname"
					name="bookname" style="height: 35px; font-size: 27px; margin-left: 10px" value="${bookname}"/>
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本作者</label><input id="bookauthor"
					name="bookauthor" style="height: 35px; font-size: 27px; margin-left: 10px" value="${bookauthor} " />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本总价</label><input type="number" id="bookprice"
					name="bookprice" style="height: 35px; font-size: 27px; margin-left: 10px" value="${bookprice}" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本总数</label><input type="number" id="booknum"
					name="booknum" style="height: 35px; font-size: 27px; margin-left: 10px" value="${booknum}" />
			</div>
		</div>
		<br>
		<div>
			<button type="submit" style="font-size: 27px">修改</button>
		</div>
	</form>
</body>
</html>