package service;

import entity.User;

public interface UserService {
	public int add(User user);
	public User findByName(String name);
}
