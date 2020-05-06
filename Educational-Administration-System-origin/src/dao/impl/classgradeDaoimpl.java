package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.classgradeDao;
import dbconnect.connect;

import entity.ClassGrade;
import entity.Student;

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

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.classgradeDao#searchbystudentid(entity.Student)
	 * 返回ClassGrade数组，若为空返回null
	 */
	public ClassGrade[] searchbystudentid(Student s) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from classgrade where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getId());
			rs = pstmt.executeQuery();
			rs.last(); //获得resultset的大小，用来开数组
			int size = rs.getRow();
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			ClassGrade[] cg = new ClassGrade[size];
			for(int i = 0 ; i< size ;i++)
				cg[i] = new ClassGrade();
			int pos = 0 ;
			while(rs.next()) {
				cg[pos].setStudent_id(rs.getString(1));
				cg[pos].setClass_id(rs.getString(2));
				cg[pos].setGrade(rs.getFloat(3));
				cg[pos].setRank(rs.getInt(4));
				pos++;
			}
			return cg;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
