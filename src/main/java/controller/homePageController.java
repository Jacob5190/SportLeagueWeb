package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.fileService;

@Controller
public class homePageController{
	@Autowired
	fileService fileService;
	@RequestMapping("/")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		return new ModelAndView("index");
	}
}
