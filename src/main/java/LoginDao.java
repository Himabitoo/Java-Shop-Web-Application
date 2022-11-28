import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private Connection con = null;
	private ResultSet  rs  = null;
	private PreparedStatement ps = null;
	private LoginUserBean bean = null;

	/**
	 * ユーザ名を取得する
	 * @param  id	ログインID
	 * @param  pass	パスワード
	 * @return LoginUserBean型
	 * @throws SQLException
	 */
	public LoginUserBean selectUser(String userId,String password) {

		try {

			// 1. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");

			// 3. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("select name from user_info where id = ? and pass = ?");

			//4. psのsetStringメソッドを利用してユーザIDを設定する。
			ps.setString(1, userId);
			//5.  psのsetStringメソッドを利用してパスワードを設定する。
			ps.setString(2, password);

			// 6. psのexecuteQueryメソッドを使用し、SQLを実行する。実行結果をメンバ変数rsへ代入する。
			rs = ps.executeQuery();

			//7. rsから実行結果を取り出す。（rs.next()を実行し、falseになるまで繰り返す。）
			while(rs.next()) {
				// 検索結果が存在する場合はbeanに値をセット（結果が1件しか返らないことを想定）
				//7-1. LoginUserBeanクラスのインスタンスを生成し、メンバ変数beanへ代入する。
				bean = new LoginUserBean();
				//7-2. beanのsetUserIdメソッドを使用し、ユーザIDを設定する。
				bean.setUserId(userId);
				// 7-3. beanのsetNameメソッドを使用し、ユーザ名を設定する。
				bean.setName(rs.getString("name"));
			}

		// 8. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {

			//8-1.  JDBCドライバが見つからなかった場合
			//コンソールへ
			ce.printStackTrace();

		} catch(SQLException se){

			// 8-1. 例外を表示する
			se.printStackTrace();


		}finally{

			// 9-1. データベースとの接続を解除する。
			this.close();
		}
        //10. ユーザ情報（bean）を返す。
		return bean;
	}

	/**
	 * データベースとの接続を解除
	 */
	public void close() {

		try {

			// 1. データベース(con)との接続を解除する
			if(con != null) {
				//1-1. conのcloseメソッドを実行する。
				con.close();
			}
			// 2. データベース(ps)との接続を解除する
			if(ps != null) {
				//2-1. psのcloseメソッドを実行する。
				ps.close();
			}

			//3. データベース(rs)との接続を解除する
			if(rs != null) {
				//3-1. conのcloseメソッドを実行する。
				rs.close();
			}

			//4. 例外処理(SQLException se)
			} catch (SQLException se) {
				// 4-1. seのprintStackTraceメソッドを実行する。
				se.printStackTrace();
			}
	}
}
