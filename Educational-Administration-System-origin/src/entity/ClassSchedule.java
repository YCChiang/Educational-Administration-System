package entity;

import java.sql.Time;

/*
 * 此类对应课程时间表
 */
public class ClassSchedule {
	private int id;
	private String class_id;
	private Time time;
	private int start_week;
	private int end_week;
	private String year;
	private String classroom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getStart_week() {
		return start_week;
	}
	public void setSart_week(int start_week) {
		this.start_week = start_week;
	}
	public int getEnd_week() {
		return end_week;
	}
	public void setEnd_week(int end_week) {
		this.end_week = end_week;
	}
}
