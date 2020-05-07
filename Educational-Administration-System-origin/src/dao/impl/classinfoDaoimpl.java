package dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.classinfoDao;
import dbconnect.connect;
import entity.ClassInfo;
import entity.ClassSelection;

public class classinfoDaoimpl implements classinfoDao{

	@Override
	/*
	 * 存储课程信息
	 * @see dao.classinfoDao#save(entity.ClassInfo)
	 * 成功返回1 ， 失败返回0
	 */
	public int insert(ClassInfo info) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into classinfo values(?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getName());
			pstmt.setInt(3, info.getHour());
			pstmt.setInt(4, info.getCapacity());
			pstmt.setString(5,info.getTeacher_id());
			pstmt.setString(6,info.getTeacher_name());
			pstmt.setInt(7,info.getCredit());
			pstmt.executeQuery();
			return 1;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	/*
	 通过教师id来查找所教授课程
	 成功返回一个ClassInfo数组
	 数组若为空则没有所教授课程，非空为课程数组
	 */
	public List<ClassInfo> selectByTeacherid(String teacher_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where teacher_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setTeacher_id(rs.getString("teacher_id"));
				temp.setTeacher_name(rs.getString("teacher_name"));
				temp.setCredit(rs.getInt("credit"));
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
		return result;
	}

	@Override
	public List<ClassInfo> selectByClass_name(String class_name) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where class_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setTeacher_id(rs.getString("teacher_id"));
				temp.setTeacher_name(rs.getString("teacher_name"));
				temp.setCredit(rs.getInt("credit"));
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
		return result;
	}

	@Override
	public ClassInfo selectByClass_id(String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassInfo result = null;
		try {
			String sql = "select * from classinfo where class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new ClassInfo();
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setHour(rs.getInt("hour"));
				result.setCapacity(rs.getInt("capacity"));
				result.setTeacher_id(rs.getString("teacher_id"));
				result.setTeacher_name(rs.getString("teacher_name"));
				result.setCredit(rs.getInt("credit"));
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
		return result;
	}
	
}
