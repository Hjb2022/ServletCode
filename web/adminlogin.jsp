<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<script type="text/javascript">
	function checkform(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username == "" || password == ""){
			alert("用户名或密码不能为空！");
			return false;
		}
	}
</script>
</head>
<body style="text-align: center; background-color: #F0F8FF; font-size: 27px">
<br><br><br>
	<form action="/BookStore/AdminLoginServlet" method="post" onsubmit="return checkform()">
		<div>
			<div>
				<label>用户名</label> <input type="text" id="adminname" name="adminname" style="height: 30px" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<label>密码</label> <input type="password" id="password" name="password" style="height: 30px" />
			</div>
		</div>
		<br>
		<div>
			<div>
				<div>
					<button type="submit" style="font-size: 27px">登录</button>
					<button type="reset" style="font-size: 27px">重置</button>
				</div>
				<br>
				<div>
					<a href="login.jsp">跳转至用户登录</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>