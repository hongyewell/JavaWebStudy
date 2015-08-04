<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有商品列表</title>
</head>
<body>
	<h2>商品信息列表</h2>
	<table>
		<thead>
			<tr>
				<th>商品名称</th>
				<th>生产地</th>
				<th>数量</th>
				<th>价格</th>
				<th>图片</th>
				
			</tr>
		</thead>
		<tbody id="goods">
		</tbody>
	</table>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		var contextPath = '${pageContext.request.contextPath}';
	</script>
	
	<script type="text/javascript">
		$(function() {
			// 使用post请求用户列表数据，渲染在页面上
			$.post(contextPath+'/goods', 'json').done(function(datas) {
				
				// 将后台返回的字符串数据转换成json格式的
				datas = JSON.parse(datas);
				
				var html = '';
				for(var i = 0, len = datas.length; i < len; i++) {
					var items = datas[i];
					var pic = 'images/'+items.picture;
					var link = 'details.jsp?id='+items.id
					html += '<tr>'
							+ '<td>'+items.name+'</td>'
							+ '<td>'+items.city+'</td>'
							+ '<td>'+items.number+'</td>'
							+ '<td>'+items.price+'</td>'
							+ '<td>'
							+ "<a href ='"+link+"'>"
							+ "<img src='"+pic+"'  width=\"200\" height=\"190\" border=\"1\" />"
							+ "</a>"
							+ '</td>'
						 + '</tr>';
				}
				// 将拼接后的用户列表渲染在页面上
				$('#goods').html(html);
				
			}).fail(function(res) {
			});
			
		});	
	</script>
</body>
</html>