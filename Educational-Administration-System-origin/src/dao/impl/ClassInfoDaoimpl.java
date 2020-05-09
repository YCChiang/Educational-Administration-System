package dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.ClassInfoDao;
import dbconnect.connect;
import entity.ClassInfo;

public class ClassInfoDaoimpl implements ClassInfoDao{

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
		int result = 0;
		try {
			String sql = "INSERT INTO classinfo (id, name, hour, capacity, year, start_week, end_week, teacher_id, teacher_name, credit) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getName());
			pstmt.setInt(3, info.getHour());
			pstmt.setInt(4, info.getCapacity());
			pstmt.setString(5, info.getYear());
			pstmt.setInt(6, info.getStart_week());
			pstmt.setInt(7, info.getEnd_week());
			pstmt.setString(8,info.getTeacher_id());
			pstmt.setString(9,info.getTeacher_name());
			pstmt.setInt(10,info.getCredit());
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
	public List<ClassInfo> selectByName(String class_name) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where class_name = %?%";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setYear(rs.getString("year"));
				temp.setStart_week(rs.getInt("start_week"));
				temp.setEnd_week(rs.getInt("end_week"));
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
	public ClassInfo selectById(String class_id) {
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
				result.setYear(rs.getString("year"));
				result.setStart_week(rs.getInt("start_week"));
				result.setEnd_week(rs.getInt("end_week"));
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
	public int update(ClassInfo info) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update classinfo set name = ? ,hour = ? ,capacity = ?,teacher_id = ? ,teacher_name = ?,credit = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getName());
			pstmt.setInt(2, info.getHour());
			pstmt.setInt(3, info.getCapacity());
			pstmt.setString(4, info.getTeacher_id());
			pstmt.setString(5, info.getTeacher_name());
			pstmt.setInt(6, info.getCredit());
			pstmt.setString(7, info.getId());
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
	public List<ClassInfo> selectAll() {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setYear(rs.getString("year"));
				temp.setStart_week(rs.getInt("start_week"));
				temp.setEnd_week(rs.getInt("end_week"));
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
	public List<ClassInfo> selectByYear(String year) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where year = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setYear(rs.getString("year"));
				temp.setStart_week(rs.getInt("start_week"));
				temp.setEnd_week(rs.getInt("end_week"));
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
	public List<ClassInfo> selectByNameAndYear(String class_name, String year) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where year = ? and class_name = %?%";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setYear(rs.getString("year"));
				temp.setStart_week(rs.getInt("start_week"));
				temp.setEnd_week(rs.getInt("end_week"));
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
	public List<ClassInfo> selectByTeacheridAndYear(String teacher_id, String year) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassInfo> result = new ArrayList<ClassInfo>();
		try {
			String sql = "select * from classinfo where year = ? and teacher_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassInfo temp = new ClassInfo();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setHour(rs.getInt("hour"));
				temp.setCapacity(rs.getInt("capacity"));
				temp.setYear(rs.getString("year"));
				temp.setStart_week(rs.getInt("start_week"));
				temp.setEnd_week(rs.getInt("end_week"));
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
}
