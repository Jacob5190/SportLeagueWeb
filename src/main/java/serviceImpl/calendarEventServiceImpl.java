package serviceImpl;

import mappers.calendarEvent.calendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.CalendarEvent;
import service.calendarEventService;

import java.util.List;
@Service
public class calendarEventServiceImpl implements calendarEventService {
	@Autowired
	calendarEvent calendarEvent;
	@Override
	public List<CalendarEvent> selectCalendarEvent(){
		return calendarEvent.selectCalendarEvent();
	}

	@Override
	public void insertCalendarEvent (CalendarEvent calendar_event) {
		calendarEvent.insertCalendarEvent(calendar_event);
	}

	@Override
	public void deleteCalendarEvent (int id) {
		calendarEvent.deleteCalendarEvent(id);
	}

}
