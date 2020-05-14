package test;

import java.util.List;

import entity.ClassInfo;
import service.impl.ClassInfoServiceImpl;

public class getclassinfobyteacherid {

	public static void main(String[] args) {
		ClassInfoServiceImpl classinfoservice = new ClassInfoServiceImpl();
		List<ClassInfo> classInfo = classinfoservice.findByStudentIdAndYear("2003000003", "2020春");
		if(classInfo.isEmpty()) {
			System.out.print("empty");
		}
	}

}
