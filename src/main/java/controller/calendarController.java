package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.CalendarEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class calendarController{
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/calendar")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("calendar.jsp");
		SqlSession session = SessionFactory.getSession();
		List<CalendarEvent> calendarEvents = session.selectList("selectCalendarEvent");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String json = mapper.writeValueAsString(calendarEvents);
		mav.addObject("calendar_events", json);
		return mav;
	}

	@RequestMapping("/eventUpload")
	@ResponseBody
	public void eventUpload (CalendarEvent calendarEvent) throws IOException {
		SqlSession session = SessionFactory.getSession();
		session.insert("insertCalendarEvent",calendarEvent);
		session.commit();
		session.close();
	}
}
