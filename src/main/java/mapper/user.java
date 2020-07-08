package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pojo.User;

@Mapper
public interface user {
	@Select("select * from shiro_db where user = #{username}")
	User selectUser(String username);
}
