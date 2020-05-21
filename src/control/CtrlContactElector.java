package control;

import entity.DbNewElectorInfoEntry;


class CtrlContactElector {
/*
	public CtrlContactElector(int employeeId, int electorId, Date callDate,
			String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass,String needRide, Time pickupFrom, Time pickupTo) {
		System.out.print("InputBug1");
		DbNewElectorInfo dbNewElectorInfo = new DbNewElectorInfo(employeeId, electorId,
				gotAnswer, planToVote, supportTheParty,interestInClass,
				needRide, pickupFrom, pickupTo, callDate);
		
	}
*/	CtrlContactElector(int employeeId, int electorId, String gotAnswer, String planToVote,
		String supportTheParty, String interestInClass, String needRide, String pickupFrom, String pickupTo,
		String callDate) {
		DbNewElectorInfoEntry dbNewElectorInfoEntry = new DbNewElectorInfoEntry(employeeId, electorId,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo, callDate);
		dbNewElectorInfoEntry.SetEntry();
	}
	
}
