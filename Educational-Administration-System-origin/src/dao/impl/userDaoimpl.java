package dao.impl;
import dao.*;
import dbconnect.connect;
import entity.user;
import java.sql.*;
public class userDaoimpl implements userDao{

	@Override
	public user login(String name, String password, String type) {
		// TODO Auto-generated method stub
		user uu = null;
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
				uu = new user();
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
