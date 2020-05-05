package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.classgradeDao;
import dbconnect.connect;

public class classgradeDaoimpl implements classgradeDao{

	@Override
	public boolean Enterresults(String student_id, String class_id, int grade, int rank) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into classgrade(student_id ,class_id ,grade ,rank) values (?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);
			pstmt.setInt(3, grade);
			pstmt.setInt(4, rank);
			pstmt.executeQuery();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
