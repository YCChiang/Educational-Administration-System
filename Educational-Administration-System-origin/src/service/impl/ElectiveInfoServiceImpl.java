package service.impl;

import java.util.List;
import dao.ClassScheduleDAO;
import dao.ClassInfoDao;
import dao.ElectiveInfoDao;
import entity.ClassInfo;
import entity.ElectiveInfo;
import service.ElectiveInfoService;

public class ElectiveInfoServiceImpl implements ElectiveInfoService {
	ElectiveInfoDao electiveinfoDao;
	ClassInfoDao classinfoDao;
	ClassScheduleDAO classscheduleDAO;
	ClassInfoServiceImpl ClassInfoService;
	
	public int add(ElectiveInfo info) {
		return electiveinfoDao.insert(info);
	}
	
	public List<ElectiveInfo> findByStudent_id(String student_id){
		return electiveinfoDao.selectByStudentid(student_id);
	}
	
	public List<ElectiveInfo> findByClass_id(String class_id) {
		return electiveinfoDao.selectByClassID(class_id);
	}
	
	public boolean quit(ClassInfo classInfo, String student_id) {
		ElectiveInfo info = electiveinfoDao.selectByClass_idAndStudent_id(student_id, classInfo.getId());
		if(info != null) {
			electiveinfoDao.deleteById(info.getId());
			return true;
		}			
		return false;
	}
	
	public String elective(ClassInfo classInfo, String student_id) {
		if(ClassInfoService.IsConflictToOther(classInfo, student_id))
			return classInfo.getName()+"课程与已选课程冲突！";
		
		// 将选课信息插入数据库中
		ElectiveInfo info = new ElectiveInfo();
		info.setStudent_id(student_id);
		info.setClass_id(classInfo.getId());
		if(add(info)==1)
			return "选课成功";
		else
			return "选课失败";
	}
}
