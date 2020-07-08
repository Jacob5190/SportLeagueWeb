package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.userService;


@Controller
public class loginController {
	@Autowired
	userService userService;
	@RequestMapping("/admin")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView login(String username, String password) {
		ModelAndView mav = new ModelAndView();
		try {
			Subject subject = SecurityUtils.getSubject();
			if (!subject.isAuthenticated()) {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				subject.login(token);
			}
			System.out.println("Login success");

			mav.setViewName("redirect:/admin/calendar");
		}catch (AuthenticationException exception) {
			System.out.println("Login attempt");
			mav.addObject("error", "Invalid account or password");
			mav.setViewName("login");
		}
		return mav;
	}
}
