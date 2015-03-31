package onlineClass.dao;

import java.util.List;

import onlineClass.domain.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

	public List<User> userList();

	public Boolean modify(User user);

	public User myInfo();
	
	public Boolean addUser(User user);
}
