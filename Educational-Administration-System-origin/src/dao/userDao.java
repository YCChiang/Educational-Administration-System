package dao;
import entity.*;

public interface userDao {
		public user login(String name, String password,String type);
}
