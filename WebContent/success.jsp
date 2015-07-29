<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商品成功</title>
</head>
<body>
	<center>
		<img src="images/add_cart_success.jpg">
		<hr>
		<%
			String id = request.getParameter("id");
			String num = request.getParameter("num");
		%>
		您成功购买了<%=num %> 件商品编号为 <%= id %>的商品；
	</center>

</body>
</html>