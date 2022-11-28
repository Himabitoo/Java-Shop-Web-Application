import java.io.Serializable;

public class HistoryBean implements Serializable{

	//直列化
	private static final long serialVersionUID = 1L;

	//メンバー変数
	private String itemId;
	private String itemName;
	private int	   itemByQuantity;

	//getterメソッド
	public String getItemId() {
		return itemId;
	}
	//setterメソッド
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	//getterメソッド
	public String getItemName() {
		return itemName;
	}
	//setterメソッド
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//getterメソッド
	public int getItemByQuantity() {
		return itemByQuantity;
	}
	//setterメソッド
	public void setItemByQuantity(int itemByQuantity) {
		this.itemByQuantity = itemByQuantity;
	}

}
