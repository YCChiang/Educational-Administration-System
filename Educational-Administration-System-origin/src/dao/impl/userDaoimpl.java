package dao.impl;
import dao.*;
import dbconnect.connect;
import entity.User;
import java.sql.*;
public class userDaoimpl implements userDao{
	@Override
	public int insert(User user) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO user (name, password, type) VALUES (?, ?, ?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getname());
			pstmt.setString(2, user.getpassword());
			pstmt.setString(3, user.gettype());
			pstmt.executeQuery();
			pstmt.close();
			con.close();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public User searchByName(String name) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from user where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setname(rs.getString("name"));
				user.setpassword(rs.getString("password"));
				user.settype(rs.getString("type"));
			}
			pstmt.close();
			rs.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return user;
	}
}
