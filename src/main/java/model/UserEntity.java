package model;

public class UserEntity {
	
	private String id;
	private String pwd;
	private String name;
	
	public UserEntity() {
		this.id="";
		this.pwd="";
		this.name="";
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String ID) {
		this.id = ID;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	public void setPwd(String Pwd) {
		this.pwd = Pwd;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
}
