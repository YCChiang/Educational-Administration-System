package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ElectiveInfoDao;
import dbconnect.connect;
import entity.ElectiveInfo;

public class ElectiveInfoDaoImpl implements ElectiveInfoDao {

	@Override
	public int insert(ElectiveInfo info) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into classgrade (student_id ,class_id) values (?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getStudent_id());
			pstmt.setString(2, info.getClass_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<ElectiveInfo> selectByStudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ElectiveInfo> result = new ArrayList<ElectiveInfo>();
		try {
			String sql = "select * from classgrade where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ElectiveInfo temp = new ElectiveInfo();
				temp.setId(rs.getInt("id"));
				temp.setStudent_id(rs.getString(student_id));
				temp.setClass_id(rs.getString("class_id"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<ElectiveInfo> selectByClassID(String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ElectiveInfo> result = new ArrayList<ElectiveInfo>();
		try {
			String sql = "select * from classgrade where class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ElectiveInfo temp = new ElectiveInfo();
				temp.setId(rs.getInt("id"));
				temp.setStudent_id(rs.getString("student_id"));
				temp.setClass_id(rs.getString(class_id));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public ElectiveInfo selectByClass_idAndStudent_id(String student_id, String class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ElectiveInfo result = null;
		try {
			String sql = "select * from classgrade where class_id = ? and student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			pstmt.setString(2, student_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new ElectiveInfo();
				result.setId(rs.getInt("id"));
				result.setStudent_id(rs.getString(student_id));
				result.setClass_id(rs.getString(class_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int deleteById(int class_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "delete from electiveinfo where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
