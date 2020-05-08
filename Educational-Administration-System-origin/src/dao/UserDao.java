package dao;
import entity.*;

public interface UserDao {
	public int insert(User user);
	public User searchByName(String name);
}
