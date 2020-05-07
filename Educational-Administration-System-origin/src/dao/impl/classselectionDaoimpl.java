package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.classselectionDao;
import dbconnect.connect;
import entity.ClassSelection;
import entity.Student;

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

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.classselectionDao#searchbystudentid(entity.Student)
	 * 学生查看选课情况，返回一个ClassSelection数组，若没选课则返回一个null指针
	 */
	public ClassSelection[] searchbystudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from classselection where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			rs.last(); //获得resultset的大小，用来开数组
			int size = rs.getRow();
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			ClassSelection[] cs = new ClassSelection[size];
			for(int i = 0 ; i< size ;i++)
				cs[i] = new ClassSelection();
			int pos = 0 ;
			while(rs.next()) {
				cs[pos].setStudent_id(rs.getString(1));
				cs[pos].setStudent_name(rs.getString(2));
				cs[pos].setClass_id(rs.getString(3));
				cs[pos].setClass_name(rs.getString(4));
				cs[pos].setTeacher_id(rs.getString(5));
				cs[pos].setTeacher_name(rs.getString(6));
				pos++;
			}
			return cs;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
