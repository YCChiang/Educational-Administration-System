package dao;

import entity.ClassGrade;
import entity.Student;
public interface classgradeDao {
	public int save(ClassGrade grade);
	public ClassGrade[] searchbystudentid(Student s);
}
