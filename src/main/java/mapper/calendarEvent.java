package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pojo.CalendarEvent;

import java.util.List;
@Mapper
public interface calendarEvent {
	@Insert("insert into calendar_event (startDate, title) values (#{startDate}, #{title})")
	void insertCalendarEvent(CalendarEvent calendarEvent);

	@Select("select id, startDate, title from calendar_event")
	List<CalendarEvent> selectCalendarEvent();

	@Delete("delete from calendar_event where id = #{id}")
	void deleteCalendarEvent(int id);
}
