package dao;

import entity.ClassGrade;
import entity.Student;
public interface classgradeDao {

	public ClassGrade[] searchbystudentid(Student s);
	public int insert(ClassGrade grade);
}
