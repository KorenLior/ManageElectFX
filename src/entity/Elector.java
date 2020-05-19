package entity;

import java.sql.Time;

public class Elector {

	int id, ballotNum, serialNum, rideID;
	Time RideHour;
	String firstName, lastName, address;
	int phoneNumber;
	public Elector(int id, int ballotNum, int serialNum, int rideID, Time rideHour, String firstName, 
			String lastName, String address, int phoneNumber) {
		super();
		this.id = id;
		this.ballotNum = ballotNum;
		this.serialNum = serialNum;
		this.rideID = rideID;
		this.RideHour = rideHour;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public Time getRideHour() {
		return RideHour;
	}
	public void setRideHour(Time rideHour) {
		RideHour = rideHour;
	}
	

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public int getBallotNum() {
		return ballotNum;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public int getRideID() {
		return rideID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Elector [id=" + id + ", ballotNum=" + ballotNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
