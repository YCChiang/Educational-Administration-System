package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClassGradeDao;
import dbconnect.connect;

import entity.ClassGrade;

public class ClassGradeDaoimpl implements ClassGradeDao{
	@Override
	/*
	 * return value:
	 * 	1: 插入成功
	 * 	0: 插入失败
	 */
	public int insert(ClassGrade info) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into classgrade (student_id ,class_id ,grade ,rank, makeup) values (?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getStudent_id());
			pstmt.setString(2, info.getClass_id());
			pstmt.setFloat(3, info.getGrade());
			pstmt.setInt(4, info.getRank());
			pstmt.setString(5, info.getMakeup());
			result = pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();
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
	public List<ClassGrade> selectByStudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassGrade> result = new ArrayList<ClassGrade>();
		try {
			String sql = "select * from classgrade where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassGrade temp = new ClassGrade();
				temp.setId(rs.getInt("id"));
				temp.setStudent_id(rs.getString("student_id"));
				temp.setClass_id(rs.getString("class_id"));
				temp.setGrade(rs.getFloat("grade"));
				temp.setRank(rs.getInt("rank"));
				temp.setMakeup(rs.getString("makeup"));
				result.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();		
				if(rs != null)
					rs.close();
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
	public List<ClassGrade> selectByClassID(String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassGrade> result = new ArrayList<ClassGrade>();
		try {
			String sql = "select * from classgrade where class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassGrade temp = new ClassGrade();
				temp.setId(rs.getInt("id"));
				temp.setStudent_id(rs.getString("student_id"));
				temp.setClass_id(class_id);
				temp.setGrade(rs.getFloat("grade"));
				temp.setRank(rs.getInt("rank"));
				temp.setMakeup(rs.getString("makeup"));
				result.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();		
				if(rs != null)
					rs.close();
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
	public ClassGrade selectByStudentidandClassID(String student_id, String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassGrade temp = null;
		try {
			String sql = "select * from classgrade where student_id = ? and class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				temp = new ClassGrade();
				temp.setId(rs.getInt("id"));
				temp.setStudent_id(rs.getString("student_id"));
				temp.setClass_id(rs.getString("class_id"));
				temp.setGrade(rs.getFloat("grade"));
				temp.setRank(rs.getInt("rank"));
				temp.setMakeup(rs.getString("makeup"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null)
					pstmt.close();		
				if(rs != null)
					rs.close();
				if(con != null)
					con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}



}
