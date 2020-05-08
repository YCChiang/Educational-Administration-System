package entity;

/*
 * 此类对应学生信息表
 */
public class Student {
	private String id;
	private String name;
	private int gender;
	private String specialty;
	private String classinfo;
	private String department;
	private int age;
	private int admission_time;
	public String getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String address;
	private String tel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAdmission_time() {
		return admission_time;
	}
	public void setAdmission_time(int admission_time) {
		this.admission_time = admission_time;
	}
}
