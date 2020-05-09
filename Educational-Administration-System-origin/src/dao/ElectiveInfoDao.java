package dao;

import java.util.List;

import entity.ElectiveInfo;

public interface ElectiveInfoDao {
	public int insert(ElectiveInfo info);
	public List<ElectiveInfo> selectByStudentid(String student_id);
	public List<ElectiveInfo> selectByClassID(String class_id);
	public int selectByClass_idAndStudent_id(String student_id , String class_id);
	public int deleteById(int id);
}
