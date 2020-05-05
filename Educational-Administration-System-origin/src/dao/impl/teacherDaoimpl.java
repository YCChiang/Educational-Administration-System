package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.teacherDao;
import dbconnect.connect;
import entity.Teacher;

public class teacherDaoimpl implements teacherDao{

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.teacherDao#searchbyteacherid(java.lang.String)
	 * 通过教师id来查找出老师的基本信息
	 * 如果查询成功返回techer指针，失败返回null指针
	 */
	public Teacher searchbyteacherid(String teacher_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher t = null;
		try {
			String sql = "select * from teacher where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				t = new Teacher();
				t.setId(rs.getString(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getInt(3));
				t.setDepartment(rs.getString(4));
				t.setTitle(rs.getString(5));
				t.setTel(rs.getString(6));
				return t;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
