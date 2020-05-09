package service.impl;

import dao.impl.UserDaoimpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDaoimpl userDaoimpl;

	@Override
	public int add(User user) {
		return userDaoimpl.insert(user);
	}

	@Override
	public User findByName(String name) {
		return userDaoimpl.searchByName(name);
	}
}
