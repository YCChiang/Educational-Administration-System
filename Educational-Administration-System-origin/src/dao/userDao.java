package dao;
import entity.*;

public interface userDao {
		public User login(String name, String password,String type);
}
