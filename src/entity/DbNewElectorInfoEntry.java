package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbNewElectorInfoEntry {
	private int employeeId, electorId;
	String gotAnswer, planToVote, supportTheParty, interestInClass,
	needRide, pickupFrom, pickupTo, callDate;
	public DbNewElectorInfoEntry(int employeeId, int electorId, String gotAnswer, String planToVote,
			String supportTheParty, String interestInClass, String needRide, String pickupFrom, String pickupTo,
			String callDate) {
		super();
		this.employeeId = employeeId;
		this.electorId = electorId;
		this.gotAnswer = gotAnswer;
		this.planToVote = planToVote;
		this.supportTheParty = supportTheParty;
		this.interestInClass = interestInClass;
		this.needRide = needRide;
		this.pickupFrom = pickupFrom;
		this.pickupTo = pickupTo;
		this.callDate = callDate;
	}
	/*
	public DbNewElectorInfo(int employeeId, int electorId, String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass, String needRide, Time pickupFrom, Time pickupTo, Date callDate) {
				 try {
					 System.out.println("inputbug:");
				
				 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 try (Connection conn = DriverManager.getConnection(ConstsDbNewElectorInfo.CONN_STR);

					 CallableStatement stmt = conn.prepareCall(ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO)) {
						 System.out.println("inputbug1:");
			 (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)
					 int i = 1;
					 stmt.setDate(i++, callDate);
					 stmt.setString(i++, gotAnswer);
					 stmt.setString(i++, planToVote);
					 stmt.setString(i++, supportTheParty);
					 stmt.setString(i++, interestInClass);
					 stmt.setString(i++, needRide);
					 stmt.setString(i++, pickupFrom.toString());
					 stmt.setString(i++, pickupTo.toString());
					 stmt.setInt(i++, electorId);
					 stmt.setInt(i++, employeeId);
					 
					 System.out.println("SQL Statement="+stmt.toString());
					 stmt.executeUpdate();
					 } catch (SQLException e) {
						 System.out.println("DbNewElectorInfo Failure");
					 e.printStackTrace();
					 }
				 } catch (ClassNotFoundException e) {
					 System.out.println("DbNewElectorInfo ClassNotFound Failure");
				 e.printStackTrace();
				 }
	}
*/
	public void SetEntry(){
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbNewElectorInfo.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO)) {

	/* (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)*/
			
		int i = 1;
		 //stmt.setString(i++, callDate);
		stmt.setString(i++, callDate);
		stmt.setString(i++, gotAnswer);
		stmt.setString(i++, planToVote);
		stmt.setString(i++, supportTheParty);
		 stmt.setString(i++, interestInClass);
		 stmt.setString(i++, needRide);
		 stmt.setString(i++, pickupFrom);
		 stmt.setString(i++, pickupTo);
		 stmt.setInt(i++, electorId);
		 stmt.setInt(i++, employeeId);
		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("DbNewElectorInfo Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbNewElectorInfo ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
	
}
