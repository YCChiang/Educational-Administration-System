package dao;
import entity.*;

public interface userDao {
	public int insert(User user);
	public User searchByName(String name);
	public User login(String name, String password,String type);
}
