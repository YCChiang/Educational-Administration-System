package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.classgradeDao;
import dbconnect.connect;

import entity.ClassGrade;

public class classgradeDaoimpl implements classgradeDao{
	@Override
	/*
	 * return value:
	 * 	1: 插入成功
	 * 	0: 插入失败
	 */
	public int insert(ClassGrade grade) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into classgrade(student_id ,class_id ,grade ,rank) values (?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade.getStudent_id());
			pstmt.setString(2, grade.getClass_id());
			pstmt.setFloat(3, grade.getGrade());
			pstmt.setInt(4, grade.getRank());
			pstmt.executeQuery();
			return 1;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
