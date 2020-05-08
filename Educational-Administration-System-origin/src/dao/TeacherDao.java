package dao;

import entity.Teacher;

public interface TeacherDao {
	public Teacher searchByTeacherid(String teacher_id);
	public int modify(Teacher t);
	public int insert(Teacher t);
}
