<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
</head>
<body>
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
			<tbody id="users">
				
			</tbody>
		</table>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			var contextPath = '${pageContext.request.contextPath}';
		</script>
		
		<script type="text/javascript">
			$(function(){
				$.post(contextPath+'/users','json').done(function (datas){
					datas = JSON.parse(datas);
					
					var html = '';
					for (var i = 0, len = datas.length; i<len; i++){
						var user = datas[i];
						
						html += '<tr>'
								+'<td>'+user.id+'</td>'
								+'<td>'+user.username+'</td>'
								+'<td>'+user.password+'</td>'
							 + '</tr>';
					}
					$("#users").html(html);
					
				}).fail(function(res){
					
				});
			});
		</script>
	</body>
</html>