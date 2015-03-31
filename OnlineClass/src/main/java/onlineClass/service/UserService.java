package onlineClass.service;

import java.util.List;

import javax.annotation.Resource;

import onlineClass.dao.UserDao;
import onlineClass.dao.UserDaoImpl;
import onlineClass.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> userList() {
		List<User> userList = userDao.userList();
		return userList;
	}

	public Boolean modify(User user) {
		Boolean isModify = userDao.modify(user);
		return isModify;
	}

	public User myInfo() {
		User user = userDao.myInfo();
		return user;
	}

	public Boolean addUser(User user) {
		Boolean isSuccess = userDao.addUser(user);
		return isSuccess;
	}
}
