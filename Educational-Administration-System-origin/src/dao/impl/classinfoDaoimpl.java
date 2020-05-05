package dao.impl;
import java.sql.*;

import dao.classinfoDao;
import dbconnect.connect;
import entity.ClassInfo;

public class classinfoDaoimpl implements classinfoDao{

	@Override
	/*
	 * 存储课程信息
	 * @see dao.classinfoDao#save(entity.ClassInfo)
	 * 成功返回1 ， 失败返回0
	 */
	public int save(ClassInfo info) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into classinfo values(?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getName());
			pstmt.setInt(3, info.getHour());
			pstmt.setInt(4, info.getCapacity());
			pstmt.setString(5,info.getTeacher_id());
			pstmt.setString(6,info.getTeacher_name());
			pstmt.setInt(7,info.getCredit());
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
	 通过教师id来查找所教授课程
	 成功返回一个ClassInfo数组
	 数组若为空则没有所教授课程，非空为课程数组
	 */
	public ClassInfo[] selectbyteacherid(String teacher_id) {
		// TODO Auto-generated method stub
		Connection con = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from classinfo where teacher_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			rs = pstmt.executeQuery();
			rs.last(); //获得resultset的大小，用来开数组
			int size = rs.getRow();
			rs.beforeFirst(); //回到最开始的位置
			//System.out.println(size);
			ClassInfo[] crs = new ClassInfo[size];
			for(int i = 0 ; i< size ;i++)
				crs[i] = new ClassInfo();
			int pos = 0 ;
			while(rs.next()) {
				crs[pos].setId(rs.getString(1));
				crs[pos].setName(rs.getString(2));
				crs[pos].setHour(rs.getInt(3));
				crs[pos].setCapacity(rs.getInt(4));
				crs[pos].setTeacher_id(rs.getString(5));
				crs[pos].setTeacher_name(rs.getString(6));
				crs[pos].setCredit(rs.getInt(7));
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
