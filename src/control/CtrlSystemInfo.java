package control;
import entity.*;

public class CtrlSystemInfo {

	private SystemInfo systemInfo;
	public CtrlSystemInfo() {
		DbGetSystem dbGetSystem = new DbGetSystem();
		systemInfo = dbGetSystem.getSystem();
	}
	public String getPartyName()
	{
		return new String(systemInfo.getPartyName());
	}
	public int getManagerId()
	{
		return systemInfo.getManagerId();
	}
}
