package dao;

import entity.ClassSelection;
import entity.Student;

public interface classselectionDao {
	public int insert(ClassSelection cs);//插入选课信息
	public ClassSelection[] searchbystudentid(String student_id);//学生查看个人选课情况
}
