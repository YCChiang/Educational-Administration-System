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
				user.setname(rs.getString(0));
				user.setpassword(rs.getString(1));
				user.settype(rs.getString(2));
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

	@Override
	public User login(String name, String password, String type) {
		// TODO Auto-generated method stub
		User uu = null;
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where type = ? and name = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, name);
			pstmt.setString(3,password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uu = new User();
				uu.setname(name);
				uu.setpassword(password);
				uu.settype(type);
				return uu;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return uu;
	}

}
