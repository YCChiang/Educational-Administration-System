package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into classselection set student_id = ? , student_name =? , class_id = ? , class_name = ? ,teacher_id = ? , teacher_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cs.getStudent_id());
			pstmt.setString(2, cs.getStudent_name());
			pstmt.setString(3, cs.getClass_id());
			pstmt.setString(4, cs.getClass_name());
			pstmt.setString(5, cs.getTeacher_id());
			pstmt.setString(6, cs.getTeacher_name());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	/* 
	 * @see dao.classselectionDao#searchbystudentid(entity.Student)
	 * 学生查看选课情况，返回一个ClassSelection数组，若没选课则返回一个null指针
	 */
	public List<ClassSelection> searchbystudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassSelection> cs = new ArrayList<ClassSelection>();;
		try {
			String sql = "select * from classselection where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			rs.last(); //获得result set的大小，用来开数组
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			while(rs.next()) {
				ClassSelection temp = new ClassSelection();
				temp.setStudent_id(rs.getString(1));
				temp.setStudent_name(rs.getString(2));
				temp.setClass_id(rs.getString(3));
				temp.setClass_name(rs.getString(4));
				temp.setTeacher_id(rs.getString(5));
				temp.setTeacher_name(rs.getString(6));
				cs.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(rs != null)
					rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cs;
	}
	
}
