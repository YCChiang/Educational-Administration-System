package service.impl;

import dao.impl.UserDaoimpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDaoimpl userDao = new UserDaoimpl();

	@Override
	public int add(User user) {
		return userDao.insert(user);
	}

	@Override
	public User findByName(String name) {
		return userDao.searchByName(name);
	}

	public Massage login(String name, String password, String type) {
		User user = findByName(name);
		Massage msg = new Massage();
		if(user != null) {
			if(user.getpassword().equals(password)) {
				if(user.gettype().equals(type)) {
					msg.setContent("登录成功!");
					msg.setIsError(false);
				}
				else {
					msg.setContent("类型错误!");
					msg.setIsError(true);
				}
			}
			else {
				msg.setContent("账号错误!");
				msg.setIsError(true);
			}
		}
		else {
			msg.setContent("账户名不存在!");
			msg.setIsError(true);
		}
		return msg;
	}
}
