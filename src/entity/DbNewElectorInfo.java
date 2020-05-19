package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;

public class DbNewElectorInfo {
	public DbNewElectorInfo(int employeeId, int electorId, String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass, String needRide, Time pickupFrom, Time pickupTo, Date callDate) {
				 try {
				
				 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 try (Connection conn = DriverManager.getConnection(ConstsDbNewElectorInfo.CONN_STR);

				 CallableStatement stmt = conn.prepareCall(ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO)) {
		/* (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)*/
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
				 
				 stmt.executeUpdate();
				 } catch (SQLException e) {
				 e.printStackTrace();
				 }
				 } catch (ClassNotFoundException e) {
				 e.printStackTrace();
				 }
	}

	public DbNewElectorInfo(int employeeId, int electorId, String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass, String needRide, String pickupFrom, String pickupTo, Date callDate) {
		 try {
				
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbNewElectorInfo.CONN_STR);

			 CallableStatement stmt = conn.prepareCall(ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO)) {
	/* (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)*/
			
		int i = 1;
		 stmt.setDate(i++, callDate);
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
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 }
	}
	
}
