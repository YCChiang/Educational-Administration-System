package dao;

import java.util.List;

import entity.ClassSelection;

public interface classselectionDao {
	public int insert(ClassSelection cs);
	public List<ClassSelection> selectByStudentid(String student_id);
	public List<ClassSelection> selectByClassID(String class_id);
}
