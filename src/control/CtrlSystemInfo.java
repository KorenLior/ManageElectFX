package control;
import entity.*;

class CtrlSystemInfo {

	private SystemInfo systemInfo;
	public CtrlSystemInfo() {
		DbGetSystem dbGetSystem = new DbGetSystem();
		systemInfo = DbGetSystem.getSystem();
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
