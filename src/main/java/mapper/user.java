package mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.User;

@Mapper
public interface user {
	User selectUser(String username);
}
