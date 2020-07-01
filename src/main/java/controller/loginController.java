package controller;

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
		return new ModelAndView("");
	}
}
