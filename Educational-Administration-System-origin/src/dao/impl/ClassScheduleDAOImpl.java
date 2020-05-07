package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.ClassScheduleDAO;
import dbconnect.connect;
import entity.ClassSchedule;
import entity.ClassSelection;

public class ClassScheduleDAOImpl implements ClassScheduleDAO {

	@Override
	public int inset(ClassSchedule classSchedule) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO classschedule (id, class_id, time, start_week, end_week, year, classroom) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, classSchedule.getId());
			pstmt.setString(2, classSchedule.getClass_id());
			pstmt.setTime(3, classSchedule.getTime());
			pstmt.setInt(4, classSchedule.getStart_week());
			pstmt.setInt(5, classSchedule.getEnd_week());
			pstmt.setString(6, classSchedule.getYear());
			pstmt.setString(7, classSchedule.getClassroom());
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
	public List<ClassSchedule> selectByClass_id(String class_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
