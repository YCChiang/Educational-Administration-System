package service.impl;

import java.util.List;

import dao.impl.classinfoDaoimpl;
import dao.impl.classselectionDaoimpl;

import entity.ClassSelection;
import service.ClassSelectionService;

public class ClassSelectionServiceImpl implements ClassSelectionService {
	classselectionDaoimpl csDAO = new classselectionDaoimpl();
	classinfoDaoimpl ciDAO = new classinfoDaoimpl();
	
	public int save(ClassSelection cs) {
		
		return csDAO.insert(cs);
	}
	
	public List<ClassSelection> findByStudent_id(String student_id){
		return csDAO.selectByStudentid(student_id);
	}
	
	public List<ClassSelection> findByClass_id(String class_id) {
		return csDAO.selectByClassID(class_id);
	}
}
