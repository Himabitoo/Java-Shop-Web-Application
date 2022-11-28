import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;
import model.UserEntity;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//②転送処理
		ServletContext con = request.getServletContext();
		RequestDispatcher rd = con.getRequestDispatcher("/user_info_result.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		this.userId = request.getParameter("userId");
		
		UserDao dao = new UserDao();
		
		try {
			
			UserEntity ue = dao.getUserData(this.userId);
			
			if(ue != null) {
				request.setAttribute("UEobj", ue);
			}
			
			ServletContext con = request.getServletContext();
			RequestDispatcher rd = con.getRequestDispatcher("/user_info_result.jsp");
			rd.forward(request, response);
			
		}
		catch(ArithmeticException e){
			System.out.print(this.userId + "ユーザーは存在しません。");
		}
		
		
	}

}
