package service;

import org.springframework.stereotype.Repository;

@Repository("userService")
public interface userService {
	String getPassword(String name);
}
