package entity;

import java.net.URLDecoder;

public class ConstsDbNewElectorInfo {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH;
	public static final String SQL_INS_ELECTORINFO =  "INSERT INTO TblElectorInfo "
 + "(CallDate,GotAnswer,PlanToVote,SupportTheParty,InterestInClass,NeedRide,PickupFrom,PickupTo,ElectorID,EmployeeID)";
	
	private static String getDBPath() {
		 try {
		String path = ConstsDbEmployee.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/DbManageElect.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/entity/DbManageElect.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}
	public ConstsDbNewElectorInfo() {
		// TODO Auto-generated constructor stub
	}

}
