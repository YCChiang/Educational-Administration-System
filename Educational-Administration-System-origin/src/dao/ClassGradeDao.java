package dao;

import java.util.List;

import entity.ClassGrade;

public interface ClassGradeDao {
	public int insert(ClassGrade cs);
	public List<ClassGrade> selectByStudentid(String student_id);
	public List<ClassGrade> selectByClassID(String class_id);
	public ClassGrade selectByStudentidandClassID(String student_id ,String class_id);
}
