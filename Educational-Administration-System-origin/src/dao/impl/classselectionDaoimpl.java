package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.classselectionDao;
import dbconnect.connect;
import entity.ClassSelection;

public class classselectionDaoimpl implements classselectionDao{

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.classselectionDao#insert(entity.ClassSelection)
	 * 插入选课信息，成功返回1
	 * 失败返回0
	 */
	public int insert(ClassSelection cs) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into classselection set student_id = ? , student_name =? , class_id = ? , class_name = ? ,teacher_id = ? , teacher_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cs.getStudent_id());
			pstmt.setString(2, cs.getStudent_name());
			pstmt.setString(3, cs.getClass_id());
			pstmt.setString(4, cs.getClass_name());
			pstmt.setString(5, cs.getTeacher_id());
			pstmt.setString(6, cs.getTeacher_name());
			pstmt.executeQuery();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
