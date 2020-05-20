package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class DbNewElectorInfo {
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
	public DbNewElectorInfo(int employeeId, int electorId, String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass, String needRide, String pickupFrom, String pickupTo, String callDate) {
		 try {
			 System.out.println("ConstsDbNewElectorInfo.CONN_STR="+ConstsDbNewElectorInfo.CONN_STR);
			 System.out.println("ConstsDbNewElectorInfo.SQL_INS...="+ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO);
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbNewElectorInfo.CONN_STR);
					 
				PreparedStatement stmt = conn.prepareCall(ConstsDbNewElectorInfo.SQL_INS_ELECTORINFO)) {
				 System.out.println("Inputbug1:");
	/* (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)*/
			
		int i = 1;
		 //stmt.setString(i++, callDate);
		stmt.setString(i++, "TEST");
		stmt.setString(i++, "TEST1");
		stmt.setString(i++, "TEST2");
		stmt.setString(i++, "TEST3");
		 stmt.setString(i++, "TEST4");
		 stmt.setString(i++, "TEST5");
		 stmt.setString(i++, "TEST6");
		 stmt.setString(i++, "TEST7");
		 stmt.setInt(i++, 1111111);
		 stmt.setInt(i++, 333333332);
		 System.out.println("SQL Statement="+stmt.toString());
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
