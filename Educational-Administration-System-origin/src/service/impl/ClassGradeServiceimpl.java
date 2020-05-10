package service.impl;

import java.util.List;

import dao.impl.ClassGradeDaoimpl;
import entity.ClassGrade;
import service.ClassGradeService;

public class ClassGradeServiceimpl implements ClassGradeService{
	ClassGradeDaoimpl ClassgradeDAO = new ClassGradeDaoimpl();
	@Override
	public List<ClassGrade> findbyStudentid(String student_id) {
		return ClassgradeDAO.selectByStudentid(student_id);
	}

}
