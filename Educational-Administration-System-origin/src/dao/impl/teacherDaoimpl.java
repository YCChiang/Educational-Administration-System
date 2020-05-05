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

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.teacherDao#modifyinfo(entity.Teacher)
	 * 更新教师信息，根据给他的teacher来完成更新信息
	 * 成功更新返回1，失败返回0
	 */
	public int modifyinfo(Teacher t) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update teacher set name = ? ,gender = ? ,department = ?,title = ? ,tel = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getName());
			pstmt.setInt(2, t.getGender());
			pstmt.setString(3, t.getDepartment());
			pstmt.setString(4, t.getTitle());
			pstmt.setString(5, t.getTel());
			pstmt.setString(6, t.getId());
			pstmt.executeQuery();
				return 1;
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}