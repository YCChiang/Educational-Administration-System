package service;

import java.util.List;

import entity.ClassGrade;

public interface ClassGradeService {
	public List<ClassGrade>findbyStudentid(String student_id);
}
