package control;

import java.sql.Date;
import java.sql.Time;

import entity.DbNewElectorInfo;


class CtrlContactElector {

	public CtrlContactElector(int employeeId, int electorId, Date callDate,
			String gotAnswer, String planToVote, String supportTheParty, String interestInClass,
			String needRide, Time pickupFrom, Time pickupTo) {
		DbNewElectorInfo dbNewElectorInfo = new DbNewElectorInfo(employeeId, electorId,
				gotAnswer, planToVote, supportTheParty,
				interestInClass, needRide, pickupFrom, pickupTo, callDate);
		
	}

	public CtrlContactElector(int employeeId, int electorId, Date callDate, String gotAnswer,
			String planToVote, String supportTheParty, String interestInClass, 
			String needRide, String pickupFrom, String pickupTo) {
		DbNewElectorInfo dbNewElectorInfo = new DbNewElectorInfo(employeeId,
				electorId, gotAnswer, planToVote, supportTheParty,
				interestInClass, needRide, pickupFrom, pickupTo, callDate);
	}
	
}
