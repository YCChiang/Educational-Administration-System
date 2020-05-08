package entity;

public class ClassGrade {
	private String student_id;
	private String class_id;
	private float grade;
	private int rank;
	private String makeup;
	
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
	public String getMakeup() {
		return makeup;
	}
	public void setMakeup(String makeup) {
		this.makeup = makeup;
	}
}
