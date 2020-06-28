package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class calendarController{
	@RequestMapping("/calendar")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		return new ModelAndView("calendar.jsp");
	}

	@RequestMapping("/eventUpload")
	@ResponseBody
	public void eventUpload (@RequestParam("iDate") String iDate, @RequestParam("iEvent") String iEvent) throws ParseException, IOException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(iDate);
	}
}
