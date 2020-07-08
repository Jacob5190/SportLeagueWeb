package service;

import org.springframework.stereotype.Repository;
import pojo.User;

@Repository("userService")
public interface userService {
	User getUserByName(String name);
}
