<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="discription" content="サイト説明">
		<meta name="keywords" content="キーワード">
		<meta name="author" content="著名">
		<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset-context/cssreset-context-min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>ログインページ</title>
	</head>

	<body>
		<header id="header" class="">
			<nav>
			</nav>
		</header><!-- /header -->

		<section>
			<h1>ショッピングサイトへようこそ</h1>
			<p>ログインIDとパスワードを入力してください。</p>

			<form action="./LoginServlet" method="post">
				<p>ログインID<input class="forminput" type="text" name="userId"></p>
				<p>パスワード<input class="forminput" type="password" name="password"></p>
				<p class="btngrp"><input type="submit" name="submit" value="ログイン">

				<% if( "login".equals(session.getAttribute("login_db"))) {%>
					<input type="submit" name="submit" value="ログアウト">
				<% }%>

				</p>
			</form>
		</section><!-- /section(コンテンツグループ) -->

		<footer id="footer" class="">
		</footer><!-- /footer -->

	</body>
</html>