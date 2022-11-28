import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. セッションスコープを用意する。
		HttpSession session = request.getSession();

		//2. sessonのgetAttributeメソッドを利用して、セッションスコープからユーザ情報を取得し、ローカル変数 beanへ格納する。
		LoginUserBean bean =  (LoginUserBean)session.getAttribute("user_db");

		//3. beanのgetUserIdメソッドを利用して、ユーザIDを取得し、ローカル変数userIdへ格納する。
		String userId = bean.getUserId();
		//4. requestのgetParameterメソッドを利用して、商品ID取得し、ローカル変数itemIdへ格納する。
		String itemId = request.getParameter("item_id");
        //5. requestのgetParameterメソッドを利用して、在庫数得し、ローカル変数itemQuantityへ格納する。
		String itemQuantity = request.getParameter("quantity");

		//6データベース更新(ShoppingDaoクラスのupdateHistoryメソッドとupdateItemメソッドを実行)
		ShoppingDao shopdao = new ShoppingDao();

		try {
			//7.shopdaoのupdateHistoryメソッドを実行する。
			shopdao.updateHistory(userId, itemId, Integer.parseInt(itemQuantity));
			//8.shopdaoのupdateItemメソッドを実行する。
			shopdao.updateItem(itemId, Integer.parseInt(itemQuantity));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//9. requestのgetRequestDispatcherを使用して遷移先を result.jsp に設定する。
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		//10. rd のforwardメソッドを使用して、ページ遷移を実行する。
		rd.forward(request, response);
	}

}
