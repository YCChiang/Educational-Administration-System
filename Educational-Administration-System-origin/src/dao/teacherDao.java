package dao;

import entity.Teacher;

public interface teacherDao {
	public Teacher searchbyteacherid(String teacher_id);
	public int modifyinfo(Teacher t);
}
