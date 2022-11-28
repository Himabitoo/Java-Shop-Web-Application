<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kensyu.ItemBean" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="discription" content="サイト説明">
		<meta name="keywords" content="キーワード">
		<meta name="author" content="著名">

		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset-context/cssreset-context-min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>商品一覧ページ</title>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<section>
			<h1>商品一覧</h1>
			<form action="./BuyItemServlet" method="get">
				<table>
					<thead>
						<tr>
							<th>商品ID</th>
							<th>商品名</th>
							<th>価格</th>
							<th>在庫数</th>
							<th>数量</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% ArrayList<ItemBean> beanList = (ArrayList<ItemBean>)request.getAttribute("itembeanList");%>
						<% for ( ItemBean bean : beanList) { %>
						<tr>
							<td><%= bean.getItemId() %></td>
							<td><%= bean.getItemName() %></td>
							<td><%= bean.getItemPrice() %></td>
							<td><%= bean.getItemQuantity() %></td>

							<% if(bean.getItemQuantity() != 0) { %>
								<td>
									<select name="<%= bean.getItemId() %>list">
									<% for(int i = 0; i <= bean.getItemQuantity(); i++ ) {%>
										<option value=<%=i%> > <%=i%> </option>
									<% }%>
									</select>
								</td>
								<td>
									<input type="submit" name="<%= bean.getItemId() %>" value="購入" >
								</td>
							<%} else {%>
								<td></td>
								<td>売り切れ</td>
							<% } %>
						</tr>
						<% } %>
					</tbody>
				</table>
				<p><input type="button" onclick="location.href='./login.jsp'" value="戻る">

				</p>
			</form>
		</section><!-- /section(コンテンツグループ) -->

		<footer id="footer" class="">
		</footer><!-- /footer -->

	</body>
</html>