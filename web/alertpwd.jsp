<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="text-align: center; background-color: #F0F8FF; font-size: 27px">
	<table style="text-align: center; width: 40%; font-size: 27px;  margin-left: 1100px">
		<tr>
			<td><a href="index.jsp">返回首页</a></td>
		</tr>
	</table>
	<hr>
	<form action="/BookStore/AlertPwdServlet" method="post">
		<div>
			<div>
				<label>原密码</label><input type="password" id="password1"
					name="password1" style="height: 30px" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>新密码</label><input type="password" id="password2"
					name="password2" style="height: 30px" />
			</div>
		</div>
		<br>
		<div>
			<button type="submit">修改</button>
		</div>
	</form>
</body>
</html>