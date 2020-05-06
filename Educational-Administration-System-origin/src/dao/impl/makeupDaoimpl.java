package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.makeupDao;
import dbconnect.connect;
import entity.Makeup;
import entity.Student;

public class makeupDaoimpl implements makeupDao {

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.makeupDao#insert(Makeup)
	 * 插入补考记录
	 * 成功返回1，失败返回0
	 */
	public int insert(Makeup M) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into makeup set student_id = ? , student_name =? , class_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, M.getStudent_id());
			pstmt.setString(2, M.getStudent_name());
			pstmt.setString(3, M.getClass_id());
			pstmt.executeQuery();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.makeupDao#searchbystudentid(Student)
	 * 通过学生ID来查看此人的补考记录，查询成功返回makeup数组，若没有记录返回null
	 */
	public Makeup [] searchbystudentid(Student S) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from makeup where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, S.getId());
			rs = pstmt.executeQuery();
			rs.last(); //获得resultset的大小，用来开数组
			int size = rs.getRow();
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			Makeup[] M = new Makeup[size];
			for(int i = 0 ; i< size ;i++)
				M[i] = new Makeup();
			int pos = 0 ;
			while(rs.next()) {
				M[pos].setStudent_id(rs.getString(1));
				M[pos].setStudent_name(rs.getString(2));
				M[pos].setClass_id(rs.getString(3));
				pos++;
			}
			return M;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
