package dao;

import entity.Student;

public interface studentDao {
	public int modifyinfo(Student s);
	public Student searchbystudentid(String student_id);
}
