package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CommentDao;
import dbconnect.connect;
import entity.ClassInfo;
import entity.Comment;

public class commentDaoimpl implements CommentDao {

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.CommentDao#searchcommentbyteacherid(java.lang.String)
	 * 输入教师id， 返回一个Comment数组
	 * 若查询失败，则返回的是null指针
	 */
	public Comment[] searchcommentbyteacherid(String teacher_id) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from comment where teacher_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			rs = pstmt.executeQuery();
			rs.last(); //获得resultset的大小，用来开数组
			int size = rs.getRow();
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			Comment[] crs = new Comment[size];
			for(int i = 0 ; i< size ;i++)
				crs[i] = new Comment();
			int pos = 0 ;
			while(rs.next()) {
				crs[pos].setClass_id(rs.getString(1));
				crs[pos].setClass_name(rs.getString(2));
				crs[pos].setTeacher_id(rs.getString(3));
				crs[pos].setTeacher_name(rs.getString(4));
				crs[pos].setContent(rs.getString(5));
				pos++;
			}
			rs.close();
			con.close();
			return crs;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see dao.CommentDao#insert(entity.Comment)
	 * 插入评教
	 */
	public int insert(Comment c) {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO comment (class_id, class_name, teacher_id ,teacher_name ,content) VALUES (?, ?, ? ,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getClass_id());
			pstmt.setString(2, c.getClass_name());
			pstmt.setString(3, c.getTeacher_id());
			pstmt.setString(4, c.getTeacher_name());
			pstmt.setString(5, c.getContent());
			pstmt.executeQuery();
			pstmt.close();
			con.close();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int modify(Comment c) {
	/*	Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update comment set name = ? ,gender = ? ,department = ?,specialy = ? ,classinfo = ?,age = ?,address = ?,tel = ? where id = ?";
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
		}*/
		return 0;
	}

	@Override
	public List<Comment> searchall() {
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> result = new ArrayList<Comment>();
		try {
			String sql = "select * from comment ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comment temp = new Comment();
				temp.setClass_id(rs.getString(1));
				temp.setClass_name(rs.getString(2));
				temp.setTeacher_id(rs.getString(3));
				temp.setTeacher_name(rs.getString(4));
				temp.setContent(rs.getString(5));
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
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(rs != null)
					rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
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
