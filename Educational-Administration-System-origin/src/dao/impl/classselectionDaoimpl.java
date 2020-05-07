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
	public List<ClassSelection> selectByStudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassSelection> cs = new ArrayList<ClassSelection>();;
		try {
			String sql = "select * from classselection where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassSelection temp = new ClassSelection();
				temp.setStudent_id(rs.getString("student_id"));
				temp.setStudent_name(rs.getString("student_name"));
				temp.setClass_id(rs.getString("class_id"));
				temp.setClass_name(rs.getString("class_name"));
				temp.setTeacher_id(rs.getString("teacher_id"));
				temp.setTeacher_name(rs.getString("teacher_name"));
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
	
	@Override
	public List<ClassSelection> selectByClassID(String class_id){
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassSelection> cs = new ArrayList<ClassSelection>();
		try {
			String sql = "select * from classselection where class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassSelection temp = new ClassSelection();
				temp.setStudent_id(rs.getString("student_id"));
				temp.setStudent_name(rs.getString("student_name"));
				temp.setClass_id(rs.getString("class_id"));
				temp.setClass_name(rs.getString("class_name"));
				temp.setTeacher_id(rs.getString("teacher_id"));
				temp.setTeacher_name(rs.getString("teacher_name"));
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
