package entity;


public class Employee {
	private int id;
	private String birthDate;
	private String gender;
	private String nationality;
	private String car;
	private int status, numChildren, branchNum;
	public Employee(int id, 
			String birthDate, 
			String gender, 
			String nationality, 
			String car, 
			int status, 
			int numChildren,
			int branchNum) {
		this.id = id;
		this.birthDate = birthDate;
		this.branchNum = branchNum;
		this.birthDate = birthDate;
		this.car = car;
		this.id = id;
		this.status = status;
		this.numChildren = numChildren;
	}
	public int getId() {
		return id;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String getGender() {
		return gender;
	}
	public String getNationality() {
		return nationality;
	}
	public String isCar() {
		return car;
	}
	public int getStatus() {
		return status;
	}
	public int getNumChildren() {
		return numChildren;
	}
	public int getBranchNum() {
		return branchNum;
	}
	@Override
	public String toString() {
		return "Employee [ID=" + id + ", birthDate=" + birthDate + ", gender=" + gender + ", nationality=" + nationality
				+ ", car=" + car + ", status=" + status + ", numChildren=" + numChildren + ", branchNum=" + branchNum
				+ "]";
	}

}
