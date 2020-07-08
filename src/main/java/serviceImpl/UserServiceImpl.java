package serviceImpl;

import mapper.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.userService;

@Service
public class UserServiceImpl implements userService {
	@Autowired
	user user;
	@Override
	public User getUserByName (String name) {
		User u = user.selectUser(name);
		if (null == u){
			return null;
		}
		return u;
	}
}
