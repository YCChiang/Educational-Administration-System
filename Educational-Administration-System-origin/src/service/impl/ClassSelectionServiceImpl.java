package service.impl;

import java.util.List;

import dao.impl.classinfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;

import entity.ElectiveInfo;
import service.ElectiveInfoService;

public class ClassSelectionServiceImpl implements ElectiveInfoService {
	ElectiveInfoDaoImpl csDAO = new ElectiveInfoDaoImpl();
	classinfoDaoimpl ciDAO = new classinfoDaoimpl();
	
	public int save(ElectiveInfo cs) {
		
		return csDAO.insert(cs);
	}
	
	public List<ElectiveInfo> findByStudent_id(String student_id){
		return csDAO.selectByStudentid(student_id);
	}
	
	public List<ElectiveInfo> findByClass_id(String class_id) {
		return csDAO.selectByClassID(class_id);
	}
}
