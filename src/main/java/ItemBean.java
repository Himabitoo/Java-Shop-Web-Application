import java.io.Serializable;

public class ItemBean implements Serializable{

	//直列化
	private static final long serialVersionUID = 1L;

	//メンバー変数
	private String itemId;
	private String itemName;
	private int    itemPrice;
	private int    itemQuantity;

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
	public int getItemPrice() {
		return itemPrice;
	}
	//setterメソッド
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	//getterメソッド
	public int getItemQuantity() {
		return itemQuantity;
	}
	//setterメソッド
	public void setItemQuantity(int itemquantity) {
		this.itemQuantity = itemquantity;
	}
}
