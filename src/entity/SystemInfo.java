package entity;

import java.sql.Time;
import java.util.Calendar;

public final class SystemInfo {

	private static String partyName;
	private int managerId;
	private Time startTime, endTime;
	private Calendar date = null;
	public SystemInfo(String partyName, int managerId, Time startTime, Time endTime, Calendar date) {
		this.endTime = endTime;
		this.startTime = startTime;
		this.managerId = managerId;
		this.partyName = partyName;
		this.date = date;
	}
	public static String getPartyName() {
		return new String(partyName);
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
	public Calendar getCalendar() {
		Calendar result = (Calendar)date.clone();
		return result;
	}
}
