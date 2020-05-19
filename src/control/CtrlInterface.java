package control;

import java.sql.Date;
import java.sql.Time;


public class CtrlInterface {
	
	private static CtrlContactElector ctrlContactElector;
	private static CtrlLogin ctrlLogin;
	private static CtrlSystemInfo ctrlSystemInfo;
	private static CtrlElector ctrlElector;
	private int loginId = -1;
	
	
	
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public CtrlInterface() {
		
		ctrlSystemInfo = new CtrlSystemInfo();
		ctrlElector = new CtrlElector();
		
	}
	public void login(int employeeId)
	{
		this.loginId = employeeId;
		ctrlLogin = new CtrlLogin(loginId);
	}
	public int getPermmission()
	{
		if (loginId==-1)
		{
			return -5556;
		}
		else
		{
			return ctrlLogin.getPermission();
		}
	}
	public void contactElector(int electorId, Date callDate,
			String gotAnswer, String planToVote, String supportTheParty, String interestInClass,
			String needRide, Time pickupFrom, Time pickupTo){
		/*
		 * add logic to test for valid input
		 */
		ctrlContactElector = new CtrlContactElector(loginId, electorId, callDate,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo);
	}
	
	public String getElectorName(int id)
	{
		return ctrlElector.getElectorName(id);
	}
	
	public String getElectorAddress(int id)
	{
		return ctrlElector.getElectorAddress(id);
	}
	
	public String getElectorContactInfo(int id)
	{
		return ctrlElector.getElectorInfo(id);
	}
	
	public String getElector(int id)
	{
		return ctrlElector.toString();
	}
	public void contactElector(int electorId, Date date, String gotAnswer, 
			String planToVote, String supportTheParty, String interestInClass,
			String needRide, String pickupFrom, String pickupTo) {
		
		ctrlContactElector = new CtrlContactElector(loginId, electorId, date,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo);
		
	}

}
