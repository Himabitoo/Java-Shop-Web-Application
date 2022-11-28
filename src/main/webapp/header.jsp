<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <jsp:useBean id="user_db" scope="session" class="kensyu.LoginUserBean" />
		<header id="header" class="">
			<nav>
				<ul class=navi_b>
					<li class=navi_s>ようこそ「<jsp:getProperty property="name" name="user_db"/>」さん！</li>
					<li class=navi_s><a href="/OnlineShop/LoginServlet?submit=購入履歴">購入履歴</a></li>
					<li class=navi_s><a href="/OnlineShop/LoginServlet?submit=ログアウト">ログアウト</a></li>
				</ul>
			</nav>
		</header><!-- /header -->