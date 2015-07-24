<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
	
		<form action="LoginServlet" method="post">
		
			<input type="text" name="username" placeholder="用户名" /><br><br>
			<input type="password" name="password" placeholder="密码">
			<input type="submit" value="登录">
		</form>
	
</body>
</html>