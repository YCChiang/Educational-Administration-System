package dao;

import entity.ClassInfo;

public interface classinfoDao{
	public int save(ClassInfo grade);
	public ClassInfo[] selectbyteacherid(String teacher_id);
	
}
