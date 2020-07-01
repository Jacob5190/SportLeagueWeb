package service;


import org.springframework.stereotype.Repository;
import pojo.CalendarEvent;

import java.util.List;
@Repository (value = "calendarEventService")
public interface calendarEventService {
	List<CalendarEvent> selectCalendarEvent();
	void insertCalendarEvent(CalendarEvent calendarEvent);
	void deleteCalendarEvent(int id);
}
