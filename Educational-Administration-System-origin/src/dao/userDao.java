package dao;
import entity.*;

public interface userDao {
	public int insert(User user);
	public User searchByName(String name);
}
