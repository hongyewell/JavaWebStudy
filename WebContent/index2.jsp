<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.ItemsDAO" %>
<%@ page import="entity.Items" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品展示</title>
<style type="text/css">
   div dd
	   {
	      margin:2px;
	      text-align:center;
	      font-size:11pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  </head>
</head>
<body>
	<h1>商品展示 </h1>
	<br>
	<h2> <%=session.getAttribute("username") %> 欢迎你～</h2>
	<hr>
	<center>
	<table width="750" height="60" cellspacing="0" border="0">
		<tr>
		<td>	
	<!-- 商品循环开始 -->
	<%
		ItemsDAO itemsDao = new ItemsDAO();
		ArrayList<Items> list = itemsDao.getAllItems();
		if(list != null && list.size()>0)
		{
			for(int i = 0; i < list.size(); i++)
			{
			Items item = list.get(i);
	%>
	
	<div style="border:1px solid; margin-top:5px; width:200px;height:250px ">
		
		
		<a href = details.jsp?id=<%=item.getId() %>><img src="images/<%=item.getPicture()%>" width="200" height="190" /></a>
		
		<br>
		<div style="text-align:center">
		<%=item.getName() %>
		<br>
		产地：<%=item.getCity() %>
		<br>
		<%=item.getPrice()%>元
		</div>
	</div>	
	<!-- 商品循环结束 -->	
	<% 
			} 
		}
	%>
		</td>	
		</tr>
	</table>
	</center>



</body>
</html>