<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>注册页面</title>
		<style>
			#myForm{
				background-color: #eaeaea;
				font-family: arial,sans-serif;
				width: 400px;
			}
			label{
				float: left;
				width: 120px;clear: left;
				text-align: right;
				padding-right: 10px;
				margin-top: 10px;
			}
			input{
				margin-top: 10px;
			}
			#submit{
				margin-left: 130px;
				padding-bottom: 10px;
			}
		</style>
	</head>
	<body>
		<h1>欢迎注册~</h1>
		<form action="${pageContext.request.contextPath }/addUser" method="post" id="myForm">
			<div>
				<label for="username">Username:</label>
				<input type="text" name="username" id="username"/>
			</div>
			
			<div>
				<label for="password">Password:</label>				
				<input type="text" name="password" id="password"/>
			</div>
			<div id="submit">
				<input type="submit" value="提交" />
			</div>
			
		</form>
	</body>
</html>
