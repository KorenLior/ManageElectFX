package control;

import java.sql.Date;
import java.sql.Time;



public class CtrlInterface {
	
	private CtrlLogin ctrlLogin;
	private CtrlSystemInfo ctrlSystemInfo;
	private CtrlElector ctrlElector;
	private int loginId = -1;
	
	
	
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public CtrlInterface() {
		
		ctrlSystemInfo = new CtrlSystemInfo();
		
	}
	public void login(int employeeId)
	{
		
		ctrlLogin = new CtrlLogin(employeeId);
		if (ctrlLogin.getPermission()>-1)
		{
			this.loginId = employeeId;
			System.out.println("loginId = "+loginId);
		}
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
	public int getId()
	{
		return loginId;
	}
	/**
	public void contactElector(int electorId, Date callDate,
			String gotAnswer, String planToVote, String supportTheParty, String interestInClass,
			String needRide, Time pickupFrom, Time pickupTo){
		
		 * add logic to test for valid input

		if (loginId != -1)
		{
			CtrlContactElector ctrlContactElector = new CtrlContactElector(loginId, electorId, callDate,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo);
		}
	}
	*/
	public String getElectorName(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorName(id);
	}
	
	public String getElectorAddress(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorAddress(id);
	}
	
	public String getElectorContactInfo(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorInfo(id);
	}
	
	public String getElector(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorInfo(id);
	}
	
		
		
	public String getElector(String idTxt) {
		int idInt = Integer.parseInt(idTxt);
		String res = getElector(idInt);
		//System.out.println("control.getElector res= "+res);
		return res;
	}
	public void contactElector(int loadedId, String date, String gotAnswer, String planToVote, String supportTheParty,
			String interestInClass, String needRide, String pickupFrom, String pickupTo) {
		if (loginId != -1)
		{
			CtrlContactElector ctrlContactElector = new CtrlContactElector(loginId, loadedId, date,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo);
		}
		
	}

}
