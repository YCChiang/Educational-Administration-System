package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.StudentDao;
import dbconnect.connect;
import entity.Student;

public class StudentDaoimpl implements StudentDao {

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * 更新学生信息，根据给他的Student来完成更新信息
	 * 成功更新返回1，失败返回0
	 */
	public int modify(Student s) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update student set name = ? ,gender = ? ,department = ?,specialy = ? ,class = ?,age = ?, admission_time = ?, address = ?, tel = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getGender());
			pstmt.setString(3, s.getDepartment());
			pstmt.setString(4, s.getSpecialty());
			pstmt.setString(5, s.getClassinfo());
			pstmt.setInt(6, s.getAge());
			pstmt.setInt(7, s.getAdmission_time());
			pstmt.setString(8, s.getAddress());
			pstmt.setString(9, s.getTel());
			pstmt.setString(10,s.getId());
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
	 * (non-Javadoc)
	 * @see dao.studentDao#searchbystudentid(java.lang.String)
	 * 按照学生id来查找基本信息，若查找到返回student对象
	 * 为查找到返回null
	 */
	public Student searchByStudentid(String student_id) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student s = null;
		try {
			String sql = "select * from student where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {// id, name, gender, department, specialty, class, age, admission_time, address, tel
				s = new Student();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getInt("gender"));
				s.setDepartment(rs.getString("department"));
				s.setSpecialty(rs.getString("specialty"));
				s.setClassinfo(rs.getString("class"));
				s.setAge(rs.getInt("age"));
				s.setAddress(rs.getString("address"));
				s.setTel(rs.getString("tel"));
				s.setAdmission_time(rs.getInt("admission_time"));
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
		return s;
	}

	@Override
	public int insert(Student s) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO student (id, name, gender, department, specialty, class, age, admission_time, address, tel) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setInt(3, s.getGender());
			pstmt.setString(4, s.getDepartment());
			pstmt.setString(5, s.getSpecialty());
			pstmt.setString(6, s.getClassinfo());
			pstmt.setInt(7, s.getAge());
			pstmt.setInt(8, s.getAdmission_time());
			pstmt.setString(9, s.getAddress());
			pstmt.setString(10, s.getTel());
			result = pstmt.executeUpdate();
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

}
