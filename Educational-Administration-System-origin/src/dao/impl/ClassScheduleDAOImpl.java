package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dao.ClassScheduleDAO;
import dbconnect.connect;
import entity.ClassInfo;
import entity.ClassSchedule;
import entity.ElectiveInfo;

public class ClassScheduleDAOImpl implements ClassScheduleDAO {

	@Override
	public int inset(ClassSchedule schedule) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO classschedule (class_id, time, day, classroom) VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, schedule.getClass_id());
			pstmt.setTime(2, schedule.getTime());
			pstmt.setInt(3, schedule.getDay());
			pstmt.setString(4, schedule.getClassroom());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
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
	public List<ClassSchedule> selectByClass_id(String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassSchedule> result = new ArrayList<ClassSchedule>();
		try {
			String sql = "SELECT * FROM classschedule WHERE class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClassSchedule temp = new ClassSchedule();
				temp.setClass_id(class_id);
				temp.setClassroom(rs.getString("classroom"));
				temp.setDay(rs.getInt("day"));
				temp.setTime(rs.getTime("time"));
				result.add(temp);
			}
		}catch(SQLException e) {
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
	public List<ClassSchedule> selectByClass_idAndDay(String class_id,List<Integer> days) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassSchedule> result = new ArrayList<ClassSchedule>();
		try {
			String sql = "SELECT * FROM classschedule WHERE class_id = ? and day in (";
			String str= null;
			sql += ")";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ClassSchedule temp = new ClassSchedule();
				temp.setClass_id(class_id);
				temp.setClassroom(rs.getString("classroom"));
				temp.setDay(rs.getInt("day"));
				temp.setTime(rs.getTime("time"));
				result.add(temp);
			}
		}catch(SQLException e) {
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
