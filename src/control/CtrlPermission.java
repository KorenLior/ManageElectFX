package control;

public class CtrlPermission {
	private int permissionLvl = -5555;
	public CtrlPermission(CtrlLogin ctrlLogin) {
		
	}
	public void setPermission(int permission)
	{
		if (permission < 5678 && permission > 5673)
		{
			permissionLvl = permission;
		}
	}
}
