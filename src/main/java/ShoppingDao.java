import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingDao {

	private Connection con = null;
	private ResultSet  rs  = null;
	private PreparedStatement ps = null;

	/**
	 * 全ての商品一覧を取得する
	 * @param  なし
	 * @return ArrayList<ItemBean>型
	 * @throws SQLException
	 */
	public ArrayList<ItemBean> selectItem(){

		//1. ArrayListクラスのインスタンスを生成し、ローカル変数beanList変数へ代入する。
		ArrayList<ItemBean> beanList = new ArrayList<ItemBean>();

		try {

			//2. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			//3. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");
			// 4. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("select b.item_id, b.item_name ,b.price,a.quantity from stock_info a, item_info b where a.item_id = b.item_id");

			//5. psのexecuteQueryメソッドを使用し、SQLを実行する。実行結果をメンバ変数rsへ代入する。
			rs = ps.executeQuery();

			//6. rsから実行結果を取り出す。（rs.next()を実行し、falseになるまで繰り返す。）
			while(rs.next()) {

				// 6-1. LoginUserBeanクラスのインスタンスを生成し、ローカル変数beanへ代入する。
				ItemBean bean = new ItemBean();

				// 6-2. rsのgetStringメソッドを利用し、商品IDを取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemId(rs.getString("item_id"));
				// 6-3. rsのgetStringメソッドを利用し、商品名を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemName(rs.getString("item_name"));
				// 6-4. rsのgetIntメソッドを利用し、価格を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemPrice(rs.getInt("price"));
				// 6-5. rsのgetIntメソッドを利用し、商品数を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemQuantity(rs.getInt("quantity"));
				// 6-6. beanListのaddメソッドを利用し、beanを追加する。
				beanList.add(bean);
			}

		//7. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {
			// 7-1. 例外メッセージ（[Error] ClassNotFoundException）を表示する
			System.out.println("[Error] ClassNotFoundException");

		//8. 例外処理(SQLException)
		} catch (SQLException se) {
			// 8-1. 例外メッセージ（[Error] SQLException）を表示する
			System.out.println("[Error] SQLException");

		//9. 終了処理
		}finally{
			// 9-1. データベースとの接続を解除する。（closeメソッドを実行させる。）
			this.close();
		}
		//10. 商品リスト（beanList）を返す。
		return beanList;
	}

	/**
	 * 商品IDから商品一覧を取得する
	 * @param  itemId　商品ID
	 * @return ItemBean型
	 * @throws SQLException
	 */
	public ItemBean selectItem( String itemId) {

		// 1. ItemBeanクラスのインスタンスを生成し、ローカル変数beanへ代入する。
		ItemBean bean = new ItemBean();

		try {

			// 2. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");
			// 4. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("select b.item_name, b.price ,a.quantity from stock_info a, item_info b where a.item_id = b.item_id and a.item_id = ?");

			// 5. psのsetStringメソッドを利用してSQL文の「？」の部分に商品IDを設定する。
			ps.setString(1, itemId);

			// 6. psのexecuteQueryメソッドを使用し、SQLを実行する。実行結果をメンバ変数rsへ代入する。
			rs = ps.executeQuery();

			//7. rsから実行結果を取り出す。（rs.next()を実行し、falseになるまで繰り返す。）
			while(rs.next()) {

				//  7-1. beanのsetItemIdを利用して商品IDを設定する。
				bean.setItemId(itemId);

				// 7-2. rsのgetStringメソッドを利用し、商品名を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemName(rs.getString("item_name"));

				//7-3. rsのgetIntメソッドを利用し、価格を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemPrice(rs.getInt("price"));

				//7-4. rsのgetIntメソッドを利用し、商品数を取得する。そしてbeanオブジェクトへ格納する。
				bean.setItemQuantity(rs.getInt("quantity"));

			}

		//8. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {
			// 8-1. 例外メッセージ（[Error] ClassNotFoundException）を表示する
			System.out.println("[Error] ClassNotFoundException");

		//9. 例外処理(SQLException)
		} catch (SQLException se) {
			// 9-1. 例外メッセージ（[Error] SQLException）を表示する
			System.out.println("[Error] SQLException");

		//10. 終了処理
		}finally{
			// 10-1. データベースとの接続を解除する。（closeメソッドを実行させる。）
			this.close();
		}
	  //11. 商品情報（bean）を返す。
		return bean;
	}

	/**
	 * 購入履歴のリストを取得
	 * @param  userId　ユーザID
	 * @return ArrayList<HistoryBean>
	 * @throws SQLException
	 */
	public ArrayList<HistoryBean> getHistory( String userId) {

		//1. ArrayListクラスのインスタンスを生成し、ローカル変数hbListへ代入する。
		ArrayList<HistoryBean> hbList = new ArrayList<HistoryBean>();

		try {

			//2. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");

			// 4. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("select a.item_id, b.item_name, a.quantity from history_info a , item_info b where a.id = ? and a.item_id = b.item_id");

			//5. psのsetStringメソッドを利用してSQL文の「？」の部分にユーザIDを設定する。
			ps.setString(1, userId);

			// 6. psのexecuteQueryメソッドを使用し、SQLを実行する。実行結果をメンバ変数rsへ代入する。
			rs = ps.executeQuery();

			//7. rsから実行結果を取り出す。（rs.next()を実行し、falseになるまで繰り返す。）
			while(rs.next()) {

				// 7-1. HistoryBeanクラスのインスタンスを生成し、ローカル変数hbへ代入する。
				HistoryBean hb = new HistoryBean();

				// 7-2. rsのgetStringメソッドを利用し、商品IDを取得する。そしてHistoryBeanオブジェクトのitemIdへ格納する。
				hb.setItemId(rs.getString("item_id"));

				// 7-3. rsのgetStringメソッドを利用し、商品名を取得する。そしてHistoryBeanオブジェクトのitemNameへ格納する。
				hb.setItemName(rs.getString("item_name"));

				//  7-4. rsのgetIntメソッドを利用し、商品購入数を取得する。そしてHistoryBeanオブジェクトのutemByQuantityへ格納する。
				hb.setItemByQuantity(rs.getInt("quantity"));

				//7-5. hbListのaddメソッドを利用し、hbを追加する。
				hbList.add(hb);

			}

		//8. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {

		// 8-1. 例外メッセージ（[Error] ClassNotFoundException）を表示する
		System.out.println("[Error] ClassNotFoundException");

		//9. 例外処理(SQLException)
		} catch (SQLException se) {

			// 9-1. 例外メッセージ（[Error] SQLException）を表示する。
			System.out.println("[Error] SQLException");

		//9. 終了処理
		}finally{

			// 9-1. データベースとの接続を解除する。（closeメソッドを実行させる。）
			this.close();
		}
		//10. 商品購入履歴リスト（hbList）を返す。
		return hbList;
	}


	/**
	 * データベースの在庫を更新
	 * @param  itemId　		商品ID
	 * @param  itemQuantity　在庫数
	 * @return 無し
	 * @throws SQLException
	 */
	public void updateItem( String itemId , int itemQuantity) throws SQLException{

		try {

			// 1. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");
			// 3. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("update stock_info set quantity = quantity - ? where item_id = ?");

			//4. psのsetIntメソッドを利用して在庫数を設定する。
			ps.setInt(1, itemQuantity);
			//5. psのsetStringメソッドを利用して商品IDを設定する。
			ps.setString(2, itemId);

			// 6. psのexecuteUpdateメソッドを使用し、SQLを実行する。
			ps.executeUpdate();

		//7. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {

			//7-1. 例外メッセージ（[Error] ClassNotFoundException）を表示する
			System.out.println("[Error] ClassNotFoundException");

		//8. 例外処理(SQLException)
		} catch (SQLException se) {

			// 8-1. 例外メッセージ（[Error] SQLException）を表示する。
			System.out.println("[Error] SQLException");

		//9. 終了処理
		}finally{

			// 9-1. データベースとの接続を解除する。（closeメソッドを実行させる。）
			this.close();
		}
	}

	/**
	 * 購入履歴テーブルを更新
	 * @param  userId　		ユーザID
	 * @param  itemId　		商品ID
	 * @param  itemQuantity　在庫数
	 * @return 無し
	 * @throws SQLException
	 */
	public void updateHistory( String userId , String itemId , int itemQuantity) throws SQLException{

		try {

			// 1. ClassクラスのforNameメソッドを使用し、JDBCドライバをロードする。
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DriverManagerクラスのgetConnectionメソッドを使用し、Connectionオブジェクトを生成し、メンバ変数conへ代入する。
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false",
											  "root",
											  "root");
			// 3. conのprepareStatementメソッドを利用し、SQL文を生成する。そしてメンバ変数psへ代入する。
			ps = con.prepareStatement("insert into history_info (id, item_id, quantity) values (?, ?, ?)");

			// 4 psのsetStringメソッドを利用してユーザIDを設定する。
			ps.setString(1, userId);
			//5  psのsetStringメソッドを利用して商品IDを設定する。
			ps.setString(2, itemId);
			//6. psのsetIntメソッドを利用して在庫数を設定する。
			ps.setInt(3, itemQuantity);

			// 7. psのexecuteUpdateメソッドを使用し、SQLを実行する。
			ps.executeUpdate();

			//8. 例外処理(ClassNotFoundException)
		} catch(ClassNotFoundException ce) {
			// 8-1. 例外メッセージ（[Error] ClassNotFoundException）を表示する。
			System.out.println("[Error] ClassNotFoundException");

			//9. 例外処理(SQLException)
		} catch (SQLException se) {
			// 9-1. 例外メッセージ（[Error] SQLException）を表示する。
			System.out.println("[Error] SQLException");

			//10. 終了処理
		}finally{
			//10-1. データベースとの接続を解除する。（closeメソッドを実行させる。）
			this.close();
		}
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