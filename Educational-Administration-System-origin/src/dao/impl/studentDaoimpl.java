package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.studentDao;
import dbconnect.connect;
import entity.Student;

public class studentDaoimpl implements studentDao {

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * 更新学生信息，根据给他的Student来完成更新信息
	 * 成功更新返回1，失败返回0
	 */
	public int modifyinfo(Student s) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update student set name = ? ,gender = ? ,department = ?,specialy = ? ,classinfo = ?,age = ?,address = ?,tel = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getGender());
			pstmt.setString(3, s.getDepartment());
			pstmt.setString(4, s.getSpecialty());
			pstmt.setString(5, s.getClassinfo());
			pstmt.setInt(6, s.getAge());
			pstmt.setString(7, s.getAddress());
			pstmt.setString(8, s.getTel());
			pstmt.setString(9, s.getId());
			pstmt.executeQuery();
			con.close();
			return 1;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.studentDao#searchbystudentid(java.lang.String)
	 * 按照学生id来查找基本信息，若查找到返回student对象
	 * 为查找到返回null
	 */
	public Student searchbystudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student s = null;
		try {
			String sql = "select * from student where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setGender(rs.getInt(3));
				s.setDepartment(rs.getString(4));
				s.setSpecialty(rs.getString(5));
				s.setClassinfo(rs.getString(6));
				s.setAge(rs.getInt(7));
				s.setAddress(rs.getString(8));
				s.setAddress(rs.getString(9));
				return s;
			}
			rs.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
