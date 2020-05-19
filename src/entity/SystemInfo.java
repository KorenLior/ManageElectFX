package entity;

import java.sql.Date;
import java.sql.Time;

public final class SystemInfo {

	private String partyName;
	private int managerId;
	private Time startTime, endTime;
	private Date date = null;
	public SystemInfo(String partyName, int managerId, Time startTime, Time endTime, Date electionCalendarStart) {
		this.endTime = endTime;
		this.startTime = startTime;
		this.managerId = managerId;
		this.partyName = partyName;
		this.date = electionCalendarStart;
		}
	public String getPartyName() {
		return partyName;
	}
	public int getManagerId() {
		return managerId;
	}
	public Time getStartTime() {
		Time result = (Time)startTime.clone();
		return result;
	}
	public Time getEndTime() {
		Time result = (Time)endTime.clone();
		return result;
	}
	public Date getCalendar() {
		Date result = (Date)date.clone();
		return result;
	}
}
