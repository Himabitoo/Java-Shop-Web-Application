<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="item" scope="request" class="kensyu.ItemBean" />

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
			<h1>商品一覧</h1>
			<p>次の商品を購入しますか?</p>
			<form action="./ResultServlet" method="get">
				<table >
					<thead>
						<tr>
							<th>商品ID</th>
							<th>商品名</th>
							<th>価格</th>
							<th>在庫数</th>
							<th>購入数</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						　　<td><jsp:getProperty property="itemId" name="item"/></td>
							<td><jsp:getProperty property="itemName" name="item"/></td>
							<td><jsp:getProperty property="itemPrice" name="item"/></td>
							<td><jsp:getProperty property="itemQuantity" name="item"/></td>
							<td><%= request.getAttribute("quantity") %></td>
							<td>
							　<input type="submit" value="購入する" >
							　<input type="hidden" name="item_id" value="<jsp:getProperty property="itemId" name="item"/>" >
							　<input type="hidden" name="quantity" value="<%= request.getAttribute("quantity") %>" >
							</td>
						</tr>
					</tbody>
				</table>
			</form>

			<form action="./ShoppingServlet" method="post">
				<p><input type="submit" name="submit" value="一覧に戻る"></p>
			</form>

		</section><!-- /section(コンテンツグループ) -->

		<footer id="footer" class="">
		</footer><!-- /footer -->

	</body>
</html>