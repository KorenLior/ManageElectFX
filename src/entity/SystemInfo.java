package entity;

import java.sql.Date;
import java.sql.Time;

public final class SystemInfo {

	private String partyName;
	private int managerId;
	private String startTime, endTime;
	private String date = null;
	public SystemInfo(String partyName, int managerId, String startTime, String endTime, String electionCalendarStart) {
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
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public String getCalendar() {
		
		return date;
	}
}
