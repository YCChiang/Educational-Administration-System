package service.impl;

import java.util.List;

import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import entity.ClassInfo;
import entity.ElectiveInfo;
import service.ElectiveInfoService;

public class ClassSelectionServiceImpl implements ElectiveInfoService {
	ElectiveInfoDaoImpl electiveinfoDao = new ElectiveInfoDaoImpl();
	ClassInfoDaoimpl classinfoDaoimpl = new ClassInfoDaoimpl();
	
	public int save(ElectiveInfo info) {
		return electiveinfoDao.insert(info);
	}
	
	public List<ElectiveInfo> findByStudent_id(String student_id){
		return electiveinfoDao.selectByStudentid(student_id);
	}
	
	public List<ElectiveInfo> findByClass_id(String class_id) {
		return electiveinfoDao.selectByClassID(class_id);
	}
	
	public int elective(ClassInfo classInfo, String student_id) {
		List<ElectiveInfo> electiveInfo = electiveinfoDao.selectByStudentid(student_id);
		int result = 0;
		if(!electiveInfo.isEmpty()) {
			for(ElectiveInfo e:electiveInfo) {
				ClassInfo temp = classinfoDaoimpl.selectByClass_id(e.getClass_id());
				if(temp.getEnd_week() > classInfo.getStart_week()) {
					
				}
			}
		}
		
		// 将选课信息插入数据库中
		ElectiveInfo info = new ElectiveInfo();
		info.setStudent_id(student_id);
		info.setClass_id(classInfo.getId());
		result = save(info);
		return result;
	}
}
