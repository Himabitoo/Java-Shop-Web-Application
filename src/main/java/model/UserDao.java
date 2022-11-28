package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	private String DB_USER = "root";
	private String DB_PWD = "password";
	
	public UserEntity getUserData(String tmpId) {
		
		UserEntity ue = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/abc",
					this.DB_USER,
					this.DB_PWD);
			
			String sql = "SELECT * FROM user_info WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, tmpId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ue = new UserEntity();
				ue.setId(rs.getString("id"));
				ue.setPwd(rs.getString("pass"));
				ue.setName(rs.getString("name"));
			}
			
			con.close();
			ps.close();
			rs.close();
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		return ue;
	}

}
