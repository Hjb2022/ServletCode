<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="text-align: center; background-color: #F0F8FF; font-size: 27px">
	<table style="text-align: center; width: 100%; font-size: 27px;">
		<tr>
			<td><a href="/BookStore/AdminBookInfoServlet">返回</a></td>
		</tr>
	</table>
	<hr>
	<form action="/BookStore/AdminAddBookServlet" method="post">
		<div>
			<div>
				<label>书本名称</label><input id="bookname"
					name="bookname" style="height: 35px; font-size: 27px; margin-left: 10px" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本作者</label><input id="bookauthor"
					name="bookauthor" style="height: 35px; font-size: 27px; margin-left: 10px" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>书本价格</label><input type="number" id="bookprice"
					name="bookprice" style="height: 35px; font-size: 27px; margin-left: 10px" />
			</div>
		</div>
		<br>
		<div>
			<button type="submit" style="font-size: 27px">添加</button>
		</div>
	</form>
</body>
</html>