package dao;

import java.util.List;

import entity.ClassSelection;

public interface classselectionDao {
	public int insert(ClassSelection cs);//插入选课信息
	public List<ClassSelection> searchbystudentid(String student_id);//学生查看个人选课情况
}
