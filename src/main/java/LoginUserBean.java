import java.io.Serializable;

public class LoginUserBean implements Serializable {

	//直列化
	private static final long serialVersionUID = 1L;

	//メンバー変数
	private	String userId;
	private String password;
	private String name;

	//getterメソッド
	public String getUserId() {
		return userId;
	}
	//setterメソッド
	public void setUserId(String userId) {
		this.userId = userId;
	}

	//getterメソッド
	public String getPassword() {
		return password;
	}
	//setterメソッド
	public void setPassword(String password) {
		this.password = password;
	}

	//getterメソッド
	public String getName() {
		return name;
	}
	//setterメソッド
	public void setName(String name) {
		this.name = name;
	}
}