import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. requestのsetCharacterEncodingメソッドを使用してHTTPリスエストの文字コードを設定する。
		request.setCharacterEncoding("UTF-8");

		// 2. requestのgetParameterメソッドを利用して押されたボタンの情報を取得し、ローカル変数 btn へ格納する。
		String btn = request.getParameter("submit");

		//3. 遷移のためのリクエスト・ディスパッチャーを用意する。
		RequestDispatcher rd;

		//4. セッションスコープを用意する。
		HttpSession session = request.getSession();

		//5. 押されたボタン情報によって、処理を分岐する。
		//条件：[ btn が "ログイン"である ]
		if("ログイン".equals(btn)) {

			//5-1. ユーザIdとパスワードを取得
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

			//5-2. Loginクラスインスタンスを作成する
			Login login = new Login();

			//5-3 ログインチェック実施
			//LoginクラスのloginCheckメソッドを実行し、ローカル変数 bean へ格納する。
			LoginUserBean bean = login.loginCheck(userId, password);

			//5-4 ログインチェック判定
			//条件：[ bean が nullではない ]
			if(bean != null) {
				//5-4-1 sessionのsetAttributeメソッドを利用し、セッションスコープにユーザ情報を設定する。
				session.setAttribute("user_db", bean);
				session.setAttribute("login_db", "login");
				//5-4-2 requestのgetRequestDispatcherを使用して遷移先を ShoppingServlet に設定する。
				rd = request.getRequestDispatcher("/ShoppingServlet");
			}else{
				//5-4-3 requestのgetRequestDispatcherを使用して遷移先を loginNg.jsp に設定する。
				rd = request.getRequestDispatcher("/loginNG.jsp");
			}

			//5-5 rd のforwardメソッドを使用して、ページ遷移を実行する。
			rd.forward(request, response);

		//処理２：ログアウトボタンが押された場合
		}else if("ログアウト".equals(btn)){

			//5-6.  sessionのremoveAttributeメソッドを利用し、セッションスコープの情報を削除
			session.removeAttribute("login_db");
			session.removeAttribute("user_db");

			//5-7 requestのgetRequestDispatcherを使用して遷移先を login.jsp に設定する。
			rd = request.getRequestDispatcher("./login.jsp");
			//5-8 rd のforwardメソッドを使用して、ページ遷移を実行する。
			rd.forward(request, response);

		//条件3：[ btn が "購入履歴"である ]
		}else if("購入履歴".equals(btn) ){

			// 5-9.  sessionのgetAttributeメソッドを利用し、セッションスコープからユーザ情報を取得し、ローカル変数 lubへ格納する。
			LoginUserBean lub = (LoginUserBean)session.getAttribute("user_db");
			//5-10 ローカル変数 lubのgetUserIdメソッドを利用し、ログインID情報を取得し、ローカル変数userIdへ格納する。
			String userId =lub.getUserId();

			//5-11 クラスインスタンスを作成する。
			Shopping shopping = new Shopping();
			//5-12 shoppingのgetHistoryメソッドを利用し、購入履歴取得処理を実行する。
			ArrayList<HistoryBean> bean = shopping.getHistory(userId);

			//リスエストスコープへ情報を登録
			request.setAttribute("historyList", bean);

			//画面遷移設定(history.jsp)
			rd = request.getRequestDispatcher("/history.jsp");
			//  5-15 rd のforwardメソッドを使用して、ページ遷移を実行する。
			rd.forward(request, response);
		}
	}
}