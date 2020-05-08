package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.profprogramDao;
import dbconnect.connect;
import entity.Comment;
import entity.ProfProgram;

public class profprogramDaoimpl implements profprogramDao {

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.profprogramDao#insert(entity.ProfProgram)
	 */
	public int insert(ProfProgram p) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO profprogram (specialty, class_id,class_name,credit) VALUES (?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,p.getSpecialty());
			pstmt.setString(2, p.getClass_id());
			pstmt.setString(3, p.getClass_name());
			pstmt.setInt(5, p.getCredit());
			result = pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
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
	public List<ProfProgram> searchBySpecialty(String specialty) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProfProgram> result = new ArrayList<ProfProgram>();
		try {
			String sql = "select * from profprogram where specialty = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, specialty);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProfProgram temp = new ProfProgram();
				temp.setClass_id(rs.getString("class_id"));
				temp.setClass_name(rs.getString("class_name"));
				temp.setSpecialty(specialty);
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
