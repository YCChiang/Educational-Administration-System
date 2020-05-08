package service;

import dao.impl.UserDaoimpl;
import entity.User;

public class loginservice {
	public User findById(String name) {
		UserDaoimpl userhandle = new UserDaoimpl();
		return userhandle.searchByName(name);
	}
}
