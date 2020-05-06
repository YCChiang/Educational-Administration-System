package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CommentDao;
import dbconnect.connect;
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
			return crs;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
