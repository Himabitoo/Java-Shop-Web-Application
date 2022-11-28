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
		<title>エラーページ</title>
	</head>

	<body>
		<header id="header" class="">
			<nav>
			</nav>
		</header><!-- /header -->
		
		<section>
			<h1>ログインエラー</h1>
			<p>入力されたらユーザーは存在しません</p>

			<form action="" method="get">
				<p><input type="button" onclick="location.href='./login.jsp'" value="戻る">
				</p>
			</form>
		</section><!-- /section(コンテンツグループ) -->

		<footer id="footer" class="">
		</footer><!-- /footer -->

	</body>
</html>