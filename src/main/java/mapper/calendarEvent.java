package mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.CalendarEvent;

import java.util.List;
@Mapper
public interface calendarEvent {
	void insertCalendarEvent(CalendarEvent calendarEvent);
	List<CalendarEvent> selectCalendarEvent();
	void deleteCalendarEvent(int id);
}
