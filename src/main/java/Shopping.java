import java.sql.SQLException;
import java.util.ArrayList;

public class Shopping {

	/**
	 * 商品一覧を取得する(ShoppingDaoクラスのselectItemメソッドを実行)
	 * @param  無し
	 * @return ArrayList<ItemBean>型
	 * @throws SQLException
	 */
	public ArrayList<ItemBean> getItem() {

		//1. ShoppingDaoクラスのインスタンスを生成し、ローカル変数sdaoへ格納する
		ShoppingDao sdao = new ShoppingDao();
		//2. ArrayList<ItemBean>型のitemListを宣言し、nullを代入する。(戻り値用の変数を用意する。)
		ArrayList<ItemBean> itemList = null;
		//3. sdaoのselectItemメソッドを実行し、結果をitemListへ格納する。
		itemList = sdao.selectItem();
		//4. itemListを戻り値として返す。
		return itemList;
	}

	/**
	 * 商品一覧を取得する(ShoppingDaoクラスのselectItemメソッド(引数あり)を実行)
	 * @param  itemId 商品ID
	 * @return ItemBean
	 * @throws SQLException
	 */
	public ItemBean getItem(String itemId){

		//1. ShoppingDaoクラスのインスタンスを生成し、ローカル変数sdaoへ格納する
		ShoppingDao sdao = new ShoppingDao();
		//2. ItemBean型のbeanを宣言し、nullを代入する。(戻り値用の変数を用意する。)
		ItemBean bean = null;
		//3. sdaoのselectItemメソッドを実行し、結果をbeanに代入する。
		bean = sdao.selectItem(itemId);
		//4. beanを戻り値として返す。
		return bean;

	}

	/**
	 * 購入履歴を取得する(ShoppingDaoクラスのgetHistoryメソッドを実行)
	 * @param  userId ユーザID
	 * @return ArrayList<HistoryBean>
	 * @throws SQLException
	 */
	public ArrayList<HistoryBean> getHistory(String userId){
		//1.  ShoppingDaoクラスのインスタンスを生成し、ローカル変数sdaoへ格納する
		ShoppingDao sdao = new ShoppingDao();
		//2.  ArrayList<HistoryBean>型のローカル変数hbByListを宣言し、nullを代入する。(戻り値用の変数を宣言する。)
		ArrayList<HistoryBean> hbByList = null;
		//3. sdaoのgetHistoryメソッドを実行し、結果をhbByListへ格納する。
		hbByList = sdao.getHistory(userId);
		//4. hbByListを戻り値として返す。
		return hbByList;
	}
}