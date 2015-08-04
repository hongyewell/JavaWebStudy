<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图片上传</title>
</head>
<body>
	<h1>图片上传</h1>
	<form action="<%=request.getContextPath() %>/imgUpload" method="post" enctype="multipart/form-data">
	上传图片：<input type="file" name="myfile1">
	<br>
	<br>
		<input type="submit" value="提交">${result}
	</form>

</body>
</html>