package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import java.io.IOException;

public class loginController {
	@RequestMapping("/login")
	public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse){
		return new ModelAndView("login.jsp");
	}

	@RequestMapping("/checkUsr")
	@ResponseBody
	public ModelAndView checkUsr(User user) throws IOException {
		String username, password;
		username = user.getUser();
		password = new Md5Hash(user.getPassword()).toString();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		try {
			subject.login(usernamePasswordToken);
		}catch (Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("");
	}
}
