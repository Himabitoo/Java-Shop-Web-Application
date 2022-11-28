public class Login {

	/**
	 * ログインチェック用(LoginDaoクラスのselectUserメソッドを実行)
	 * @param  userId 		ユーザID
	 * @param  password 	パスワード
	 * @return LoginUserBean型
	 */
	public LoginUserBean loginCheck(String userId,String password) {

		//1. LoginUserBean型の変数beanを宣言し、nullを代入する。
		LoginUserBean bean = null;

		//2. ログインID及びパスワード文字列をチェックする。
       if (userId.length() > 20  || password.length()  > 20 ) {
    	              //2-1. beanオブジェクトを戻り値として返す。
    	   				return  bean;
       }
        // 3. LoginDaoオブジェクトを生成し、ローカル変数daoへ代入する。
		LoginDao dao = new LoginDao();
		//4. daoのselectUserメソッドを利用してユーザ情報を取得し、beanへ格納する。
		bean = dao.selectUser(userId, password);
        //5. beanオブジェクトを戻り値として返す。
		return bean;
	}
}