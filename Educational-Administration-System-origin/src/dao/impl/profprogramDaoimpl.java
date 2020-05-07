package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.profprogramDao;
import dbconnect.connect;
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
		try {
			String sql = "INSERT INTO profprogram (id, specialty, class_id,class_name,credit) VALUES (?, ?, ?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2,p.getSpecialty());
			pstmt.setString(3, p.getClass_id());
			pstmt.setString(4, p.getClass_name());
			pstmt.setInt(5, p.getCredit());
			pstmt.executeQuery();
			pstmt.close();
			con.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
