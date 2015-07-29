<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.ItemsDAO" %>
<%@ page import="entity.Items" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/lhgcore.js"></script>
<script type="text/javascript" src="js/lhgdialog.js"></script>
  <script type="text/javascript">
      function selflog_show(id)
      { 
         var num =  document.getElementById("number").value; 
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/CartServlet?id='+id+'&num='+num+'&action=add', cover:true});
      }
      function add()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num<100)
         {
            document.getElementById("number").value = ++num;
         }
      }
      function sub()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
      }
     
    </script>
<style type="text/css">
 	hr{
	     border-color:FF7F00; 
	   }
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	    div #cart
	   {
	     margin:0px auto;
	     text-align:right; 
	   }
	   span{
	     padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
	   }
	   a{
	      text-decoration: none; 
	   }
	</style>
</head>
<body>
	<h1>商品详情</h1>
	<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
	<hr>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<%
					ItemsDAO itemDao  = new ItemsDAO();
					Items item = itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
					if (item != null)
					{
				%>
				
				<td width="70%" valign="top">
				<table>
						<tr>
							<td rowspan="5"><img src="images/<%=item.getPicture()%>"width="200" height="160" /></td>
						</tr>
						<tr>
							<td><B><%=item.getName() %></B></td>
						</tr>
						<tr>
							<td>产地：<%=item.getCity()%></td>
						</tr>
						<tr>
							<td>数量：<%=item.getNumber() %></td>
						</tr>
						<tr>
							<td>价格：<%=item.getPrice() %>￥</td>
						</tr>
						<tr>
							<td>购买数量：<span id="sub" onclick="sub();">-</span><input
								type="text" id="number" name="number" value="1" size="2" /><span
								id="add" onclick="add();">+</span></td>
						</tr>
				</table>
				<div id="cart">
						<img src="images/buy_now.png"><a
							href="javascript:selflog_show(<%=item.getId()%>)"><img
							src="images/in_cart.png"></a><a
							href="CartServlet?action=show"><img
							src="images/view_cart.jpg" /></a>
					</div>
				</td>
				<%
					}
				%>
				
				<%
					String list = "";
				//从客户端获取Cookies集合
					Cookie[] cookies = request.getCookies();
					//遍历
					if(cookies!=null&&cookies.length>0)
					{
						for(Cookie c:cookies)
						{
							if(c.getName().equals("ListViewCookie"))
							{
								list = c.getValue();
							}
						}
					list +=  request.getParameter("id")+",";
					//如果浏览记录超过1000条，清零.
					String[] arr= list.split(",");
					if(arr!=null&&arr.length>0)
					{
						if(arr.length>=1000)
						{
							list="";
						}
					}
					Cookie cookie = new Cookie("ListViewCookie",list);
					response.addCookie(cookie);
				%>
				<!-- 您浏览过的商品 -->
				<td width="30%" bgcolor="#CCCCCC" align="center">
					<h1>您浏览过的商品</h1>
					<!-- 循环开始 -->
					<%
						ArrayList<Items> itemlist = itemDao.getViewList(list);
						if(itemlist!=null&&itemlist.size()>0)
						{
							for(Items i: itemlist)
							{
						
					%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=i.getId() %>"><img src="images/<%=i.getPicture() %>" width="200" height="160"/></a>
							</dt>
							<dd class="dd_name"><%=i.getName() %></dd>
							<dd class="dd_city">产地：<%=i.getCity() %></dd>
							<dd class="dd_city">价格：<%=i.getPrice() %></dd>
						</dl>
					</div>
					<% 
							}
					}     
						}
					%>
					<!-- 循环结束 -->
				</td>
			</tr>
		</table>
	</center>

</body>
</html>