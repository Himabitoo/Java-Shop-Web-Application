<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="kensyu.LoginUserBean" />
<%@ page import="java.util.ArrayList"%>
<%@ page import="kensyu.HistoryBean"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="discription" content="サイト説明">
		<meta name="keywords" content="キーワード">
		<meta name="author" content="著名">

		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset-context/cssreset-context-min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>購入確認</title>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		
		<section>
			<h1><jsp:getProperty property="name" name="user_db"/>さんの購入確認</h1>
			<% ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>)request.getAttribute("historyList"); %>
			<table>
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>購入数</th>
					</tr>
				</thead>
				<tbody>
					<% for(HistoryBean history : historyList) { %>
					<tr>
						<td><%= history.getItemId() %></td>
						<td><%= history.getItemName() %></td>
						<td><%= history.getItemByQuantity() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>
			<form action="./ShoppingServlet" method="post">
				<p><input type="submit" name="submit" value="一覧に戻る"></p>
			</form>
		</section><!-- /section(コンテンツグループ) -->

		<footer id="footer" class="">
		</footer><!-- /footer -->

	</body>
</html>