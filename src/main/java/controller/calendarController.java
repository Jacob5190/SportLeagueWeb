package controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pojo.CalendarEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class calendarController{
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/calendar")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		return new ModelAndView("calendar.jsp");
	}

	@RequestMapping("/eventUpload")
	@ResponseBody
	public void eventUpload (CalendarEvent calendarEvent) {
		Date date = calendarEvent.getDate();
		String title = calendarEvent.getTitle();
		System.out.printf("Date: %s\nTitle: %s", date.toString(), title);
	}
}
