<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="text-align: center; background-color: #F0F8FF; font-size: 27px">
	<table style="text-align: center; width: 100%; font-size: 27px;">
		<tr>
			<td><a href="/BookStore/AdminUserInfoServlet">返回</a></td>
		</tr>
	</table>
	<hr>
	<form action="/BookStore/AdminAlertUserServlet" method="post">
		<div>
			<div>
				<label>用户名</label><input readonly="readonly" id="username"
					name="username" style="height: 35px; font-size: 27px; margin-left: 10px" value="${username }"/>
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>密码</label><input id="password"
					name="password" style="height: 35px; font-size: 27px; margin-left: 10px" value="${password }"/>
			</div>
		</div>
		<br>
		<div>
			<button type="submit" style="font-size: 27px">修改</button>
		</div>
	</form>
</body>
</html>