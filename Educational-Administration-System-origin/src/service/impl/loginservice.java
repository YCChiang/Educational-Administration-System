package service.impl;

import dao.impl.UserDaoimpl;
import entity.User;

public class loginservice {
	public User findById(User user) {
		UserDaoimpl userhandle = new UserDaoimpl();
		return userhandle.searchByName(user.getname());
	}
}
