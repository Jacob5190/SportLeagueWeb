package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CalendarEvent {
	private String title;
	private int id;
	private Date startDate;

	public String getTitle () {
		return title;
	}

	public void setTitle (String title) {
		this.title = title;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}
	@JsonProperty("start")
	public Date getStartDate () {
		return startDate;
	}

	public void setStartDate (Date startDate) {
		this.startDate = startDate;
	}
}
