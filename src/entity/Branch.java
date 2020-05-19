package entity;


public class Branch {
	private int branchNum, managerId, transportRepId;
	public Branch(int branchNum, int managerId, int transportRepId) {
		this.branchNum = branchNum;
		this.managerId = managerId;
		this.transportRepId = transportRepId;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public int getManagerId() {
		return managerId;
	}
	public int getTransportRepId() {
		return transportRepId;
	}

}
