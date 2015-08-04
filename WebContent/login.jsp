<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<style type="text/css">
.error {
		color: red;
	}

</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<div class="rain">
    <div class="border start">
        
        <form action="LoginServlet" method="post">
			<label for="email">username</label>
			<input type="text" name="username" placeholder="username" />
			<label for="pass">password</label>
			<input type="password" name="password" placeholder="password">
			<input type="submit" value="login">	
			<a href = "register.jsp">register</a>		
		</form>
		
		<span class="error">${error }</span>
    </div>
</div>
	
		
	
</body>
</html>