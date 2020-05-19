package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbGetEmployeeList {

	public DbGetEmployeeList() {
		// TODO Auto-generated constructor stub
	}
	ConstsDbEmployee dbConsts = new ConstsDbEmployee();
	
	
	
	public static ArrayList<Employee> getEmployees() {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbEmployee.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbEmployee.SQL_SEL_EMPLOYEES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Employee(rs.getInt(i++), rs.getDate(i++),
		 rs.getString(i++), rs.getString(i++), rs.getBoolean(i++),
		 rs.getInt(i++), rs.getInt(i++), rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}

}
