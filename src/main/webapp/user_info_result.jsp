<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserEntity" %>
<% UserEntity ue = (UserEntity)request.getAttribute("UEObj"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>結果表示画面</title>
</head>
<body>
	<h2>検索結果</h2>

	<%if(ue != null){ %>

	<table>
		<tr>
			<th>NAME：</th><td><%= ue.getName() %></td>
		</tr>
		<tr>
			<th>ユーザUSER_ID：</th><td><%= ue.getId() %></td>
		</tr>
		<tr>
			<th>PASSWORD：</th><td><%=ue.getPwd() %></td>
		</tr>
	</table>
	<%}else{ %>
	<table>
		<tr><td>[ERROR]ユーザIDが見つかりませんでした</td></tr>
	</table>
	<%} %>
	<form>
		<input type="button" onclick="location.href='./search.jsp'" value="戻る">
	</form>
</body>
</html>