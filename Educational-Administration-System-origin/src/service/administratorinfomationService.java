package service;

import entity.Student;
import entity.Teacher;

public interface administratorinfomationService {
	public int modifyStudent(Student info);
	public int modfiyTeacher(Teacher info);
	public int addStudent(Student info);
	public int addTeacher(Teacher info);
}
