package realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;
import service.userService;

public class DataBaseRealm extends AuthenticatingRealm {
	@Autowired
	userService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken authenticationToken) throws AuthenticationException {
		String userName = authenticationToken.getPrincipal().toString();
		User user = userService.getUserByName(userName);
		if (user == null) {
			throw new AuthenticationException();
		}
		String password = user.getPassword();
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userName", userName);
		return new SimpleAuthenticationInfo(userName,password,getName());
	}
}
