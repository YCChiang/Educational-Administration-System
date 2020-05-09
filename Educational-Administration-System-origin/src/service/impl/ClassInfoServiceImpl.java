package service.impl;

import java.util.ArrayList;
import java.util.List;

import entity.ClassInfo;
import entity.ClassSchedule;
import entity.ElectiveInfo;
import service.ClassInfoService;

import dao.impl.ClassInfoDaoimpl;
import dao.impl.ElectiveInfoDaoImpl;
import dao.impl.ClassScheduleDAOImpl;

public class ClassInfoServiceImpl implements ClassInfoService {
	ClassInfoDaoimpl classinfoDao;
	ElectiveInfoDaoImpl electiveinfoDao;
	ClassScheduleDAOImpl classscheduleDAO;
	
	@Override
	public List<ClassInfo> findByName(String name) {
		return classinfoDao.selectByClass_name(name);
	}

	@Override
	public ClassInfo findById(String Id) {
		return classinfoDao.selectByClass_id(Id);
	}
	
	public boolean IsConflictToOther(ClassInfo classInfo, String student_id) {
		List<ElectiveInfo> electiveInfo = electiveinfoDao.selectByStudentid(student_id);
		List<String> conflictClass = new ArrayList<String>();
		
		// 查看选择的课程是否与已选课程在教学周上有冲突
		if(!electiveInfo.isEmpty()) {
			for(ElectiveInfo e:electiveInfo) {
				ClassInfo temp = classinfoDao.selectByClass_id(e.getClass_id());
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
	
	/*
	 * 通过课程名称查找课程
	 * IsFall: 1为只查找课容量不为0的课程，0为包括课容量为0的课程
	 * IsConflict: 1为只查找与自己选课不冲突的课程，0为包括冲突课程
	 */
	public List<ClassInfo> seachClassByName(String name, String student_id, boolean IsFall, boolean IsConflict) {
		List<ClassInfo> Infos = findByName(name);
		
		if(IsFall) {
			
		}
		
		if(IsConflict) {
			for(ClassInfo info:Infos) {
				if(IsConflictToOther(info, student_id)) {
					Infos.remove(info);
				}
			}
		}
		return null;
	}

}
