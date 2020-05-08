package dao;

import entity.Student;

public interface studentDao {
	public int modify(Student s);
	public Student searchByStudentid(String student_id);
	public int insert(Student s);
}
