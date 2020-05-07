package service.impl;

import dao.impl.userDaoimpl;
import entity.User;

public class loginservice {
	public User findById(User user) {
		userDaoimpl userhandle = new userDaoimpl();
		return userhandle.searchByName(user.getname());
	}
}
