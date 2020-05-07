package entity;

/*
 * 此类对应课程成绩信息表 
 */
public class ClassGrade {
	private String student_id;
	private String class_id;
	private float grade;
	private int rank;
	
	public ClassGrade() {
		
	}
	public ClassGrade(String student_id, String class_id, float grade, int rank) {
		this.student_id = student_id;
		this.class_id = class_id;
		this.grade = grade;
		this.rank = rank;
	}
	
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
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
