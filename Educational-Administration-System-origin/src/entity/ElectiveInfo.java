package entity;

/*
 * 此类对应课程成绩信息表 
 */
public class ElectiveInfo {
	private String student_id;
	private String class_id;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
}
