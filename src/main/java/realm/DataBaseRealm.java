package realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import service.userService;

public class DataBaseRealm extends AuthorizingRealm {
	@Autowired
	userService userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principalCollection) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		String userName= authenticationToken.getPrincipal().toString();
		String password= new String(usernamePasswordToken.getPassword());
		String passwordInDB = userService.getPassword(userName);
		if("".equals(userName)){
			return null;
		}
		if (!password.equals(passwordInDB)){
			throw new AuthenticationException();
		}
		return new SimpleAuthenticationInfo(userName,password,getName());
	}
}
