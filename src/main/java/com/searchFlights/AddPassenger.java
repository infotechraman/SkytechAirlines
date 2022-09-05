package com.searchFlights;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_tickets")
public class AddPassenger {
	@Id
private String ticket_number;
private String flight_name;
private String first_name;
private String last_name;
private int age;
private String origin;
private String destination;
private String flight_date;
private String boarding_time;
private String destination_time;
private String gender;
private String fClass;
private String status;
private int seat_no;
String email;
//constructor to add passenger
//public AddPassenger(String fName, String lName, int age, String gender, String fClass) {
//	this.first_name=fName;
//	this.last_name=lName;
//	this.age=age;
//	this.gender=gender;
//	this.fClass=fClass;
//}
//constructor to book passenger
	public AddPassenger(String email ,String first_name, String last_name, int age,String gender, String fClass, String flight_name, String origin, String destination, String flight_date, String boarding_time, String destination_time,int seat_no,String ticket_number,String status) {

		this.email=email;
	this.flight_name=flight_name;
	 this.first_name=first_name;
	 this.last_name=last_name;
	 this.age=age;
	 this.gender=gender;
	 this.origin=origin;
	 this.destination=destination;
	 this.flight_date=flight_date;
	 this.boarding_time=boarding_time;
	 this.destination_time=destination_time;
	 this.fClass=fClass;
	 this.seat_no=seat_no;
	 this.ticket_number=ticket_number;
	 this.status=status;
	 
}
	
	public AddPassenger() {
	super();
}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
public String getTicket_number() {
	return ticket_number;
}
public void setTicket_number(String ticket_number) {
	this.ticket_number = ticket_number;
}
public String getFlight_name() {
	return flight_name;
}
public void setFlight_name(String flight_name) {
	this.flight_name = flight_name;
}
public String getfName() {
	return first_name;
}
public void setfName(String fName) {
	this.first_name = first_name;
}
public String getlName() {
	return last_name;
}
public void setlName(String lName) {
	this.last_name = last_name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getFlight_date() {
	return flight_date;
}
public void setFlight_date(String flight_date) {
	this.flight_date = flight_date;
}
public String getBoarding_time() {
	return boarding_time;
}
public void setBoarding_time(String boarding_time) {
	this.boarding_time = boarding_time;
}
public String getDestination_time() {
	return destination_time;
}
public void setDestination_time(String destination_time) {
	this.destination_time = destination_time;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getfClass() {
	return fClass;
}
public void setfClass(String fClass) {
	this.fClass = fClass;
}
public int getSeat_no() {
	return seat_no;
}
public void setSeat_no(int seat_no) {
	this.seat_no = seat_no;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "AddPassenger [ email="+email+" ticket_number=" + ticket_number + ", flight_name=" + flight_name + ", first_name=" + first_name
			+ ", last_name=" + last_name + ", age=" + age + ", origin=" + origin + ", destination=" + destination
			+ ", flight_date=" + flight_date + ", boarding_time=" + boarding_time + ", destination_time="
			+ destination_time + ", gender=" + gender + ", fClass=" + fClass + ", seat_no=" + seat_no + ", status="
			+ status + "]";
}


}
