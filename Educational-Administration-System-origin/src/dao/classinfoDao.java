package dao;

import entity.ClassInfo;

public interface classinfoDao{
	public int insert(ClassInfo grade);
	public ClassInfo[] selectbyteacherid(String teacher_id);
	
}
