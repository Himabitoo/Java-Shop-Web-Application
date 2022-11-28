<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset-context/cssreset-context-min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<header id="header" class="">
			<nav>
			</nav>
	</header>
	
	<section>
		<p>ユーザーIDを入力してください</p>
		
		<form action="./UserServlet" method="post">
			<p><input class="forminput" type="text" name="userId"></p>
			<p clss="btngrp"><input type="submit" value="検索"></p>
		</form>
	</section>
</body>
</html>