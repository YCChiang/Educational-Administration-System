package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.impl.ClassScheduleDAOImpl;
import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import entity.ClassInfo;
import entity.ClassSchedule;
import entity.ElectiveInfo;
import service.ElectiveInfoService;

public class ElectiveInfoServiceImpl implements ElectiveInfoService {
	ElectiveInfoDaoImpl electiveinfoDao = new ElectiveInfoDaoImpl();
	ClassInfoDaoimpl classinfoDao = new ClassInfoDaoimpl();
	ClassScheduleDAOImpl classscheduleDAO = new ClassScheduleDAOImpl();
	
	public int add(ElectiveInfo info) {
		return electiveinfoDao.insert(info);
	}
	
	public List<String> findByStudent_id(String student_id){
		List<ElectiveInfo> temp = electiveinfoDao.selectByStudentid(student_id);
		List<String> result = null;
		if(!temp.isEmpty()) {
			result = temp.stream().map(ElectiveInfo::getClass_id).collect(Collectors.toList());
		}
		return result;
	}
	
	public List<String> findByClass_id(String class_id) {
		List<ElectiveInfo> temp = electiveinfoDao.selectByClassID(class_id);
		List<String> result = null;
		if(!temp.isEmpty()) {
			result = temp.stream().map(ElectiveInfo::getStudent_id).collect(Collectors.toList());
		}
		return result;
	}
	
	public boolean IsConflictToOther(ClassInfo classInfo, String student_id) {
		List<ElectiveInfo> electiveInfo = electiveinfoDao.selectByStudentid(student_id);
		List<String> conflictClass = new ArrayList<String>();
		
		// 查看选择的课程是否与已选课程在教学周上有冲突
		if(!electiveInfo.isEmpty()) {
			for(ElectiveInfo e:electiveInfo) {
				ClassInfo temp = classinfoDao.selectOne(e.getClass_id());
				if(temp.getEnd_week() > classInfo.getStart_week() && temp.getStart_week() < classInfo.getStart_week()) {
					conflictClass.add(e.getClass_id());					
				}
				else if(temp.getStart_week() > classInfo.getStart_week() && temp.getStart_week() < classInfo.getEnd_week()) {
					conflictClass.add(e.getClass_id());	
				}				
			}			
		}
		
		// 查看在教学周上有冲突的课程，在上课时间是否有冲突
		if(!conflictClass.isEmpty()) {			
			List<ClassSchedule> schedule = classscheduleDAO.selectByClass_id(classInfo.getId());
			for(ClassSchedule s:schedule) {
				List<ClassSchedule> temp = classscheduleDAO.selectByClass_idsAndDayAndTime(conflictClass, s.getDay(), s.getTime());
				if(!temp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}
	
	public Massage quit(String class_id, String student_id) {
		ElectiveInfo info = electiveinfoDao.selectByClass_idAndStudent_id(student_id, class_id);
		Massage msg = new Massage();
		if(info != null) {
			electiveinfoDao.deleteById(info.getId());
			msg.setIsError(false);
			msg.setContent("成功退课！");
		}	
		else {
			msg.setIsError(true);
			msg.setContent("没有选此课，无法退课");
		}
		return msg;
	}
	
	public Massage elective(ClassInfo classInfo, String student_id) {
		Massage msg = new Massage();
		if(IsConflictToOther(classInfo, student_id))
		{
			msg.setIsError(true);
			msg.setContent(classInfo.getName()+"课程与已选课程冲突！");
		}
		else {
			// 将选课信息插入数据库中
			ElectiveInfo info = new ElectiveInfo();
			info.setStudent_id(student_id);
			info.setClass_id(classInfo.getId());
			if(add(info)==1)
			{
				msg.setIsError(false);
				msg.setContent("选课成功");
			}
			else{
				msg.setIsError(true);
				msg.setContent("选课失败");
			}
		}		
		return msg;
	}
}
