package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.CalendarEvent;
import service.calendarEventService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class calendarController{
	@Autowired
	calendarEventService calendarEventService;
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/calendar")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("calendar");
		List<CalendarEvent> calendarEvents = calendarEventService.selectCalendarEvent();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String json = mapper.writeValueAsString(calendarEvents);
		mav.addObject("calendar_events", json);
		return mav;
	}

	@RequestMapping("/eventUpload")
	@ResponseBody
	public void eventUpload (CalendarEvent calendarEvent) throws IOException {
		calendarEventService.insertCalendarEvent(calendarEvent);
	}

	@RequestMapping("/reqEvent")
	@ResponseBody
	public String reqEvent () throws IOException {
		List<CalendarEvent> resultList = calendarEventService.selectCalendarEvent();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		return mapper.writeValueAsString(resultList);
	}

	@RequestMapping("/delEvent")
	@ResponseBody
	public void delEvent (@RequestParam("option") int option) {
		calendarEventService.deleteCalendarEvent(option);
	}

	@RequestMapping("/admin/calendar")
	public ModelAndView calendarAdmin(){
		return new ModelAndView("calendarAdmin");
	}
}
