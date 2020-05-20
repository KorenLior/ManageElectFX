package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DbGetElectorList {

	public DbGetElectorList() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Elector> getElectors() {
		 ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR);

		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectors() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			System.out.println("getElectors() readFromDb ClassNotFound Failure");
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<Elector> getElectors(int ballotNum) {
		ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR_BALLOT
				 + String.valueOf(ballotNum));

		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectors(int ballotNum) readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			System.out.println("getElectors(int ballotNum) readFromDb ClassNotFound Failure");
			e.printStackTrace();
		}

		return results;
	}
	
	public Elector getElector(int electorId) {
		Elector result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 //System.out.println(ConstsDbElector.SQL_SEL_ELECTOR_ID
		 //+ electorId);
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);
				 
		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR_ID
				 + electorId);

		 ResultSet rs = stmt.executeQuery()) {
			 while(rs.next()) {
				 result = readFromDb(rs);
			 }
			 } catch (SQLException e) {
				 System.out.println("Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		return result;
	}
	
	
	private Elector readFromDb(ResultSet rs) throws SQLException {
			 int i = 1;
			 int id;
			 String firstName;
			 String lastName;
			 String address;
			 int phoneNum;
			 int ballotNum;
			 int serialNum;
			 int rideId;
			 String rideTime;
			 Elector result = null;
			 try {


			 id = rs.getInt(i++);
			 firstName = rs.getString(i++);
			 lastName = rs.getString(i++);
			 address = rs.getString(i++);
			 phoneNum = rs.getInt(i++);
			 ballotNum = rs.getInt(i++);
			 serialNum = rs.getInt(i++);
			 rideId = rs.getInt(i++);
			 rideTime = rs.getString(i++);
			 result = new Elector(id, ballotNum, serialNum, rideId, rideTime,
						firstName, lastName, address, phoneNum);
			 }
			 catch (Exception e) {
				System.out.println("DbGetElector.readFromDd Failure");
			}
			 return result;
	}
}
