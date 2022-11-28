import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. Shoppingクラスのインスタンスを作成する。
		Shopping shopping = new Shopping();

		//2. ShoppingクラスのgetItemメソッドを実行し、ローカル変数 shopping へ格納する。
		ArrayList<ItemBean> itembeanList = shopping.getItem();

		//3. requestのsetAttributeメソッドを利用し、リクエストスコープに商品情報を設定する。
		request.setAttribute("itembeanList", itembeanList);

		//4. requestのgetRequestDispatcherを使用して遷移先を itemList.jsp に設定する。
		RequestDispatcher rd = request.getRequestDispatcher("/itemList.jsp");

		//5 rd のforwardメソッドを使用して、ページ遷移を実行する。
		rd.forward(request, response);
	}

}