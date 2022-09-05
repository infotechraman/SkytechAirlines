package com.searchFlights;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//for hibernate
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.paymentFeature.Payment;

//for entity class annotation
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class SelectFlight {
	
FlightDetails fd=new FlightDetails();

	private int totalAmount;
	private String origin1;
	private String destination1;
	private String flight_date1;
	int passengerNo;
	private AddPassenger[] p;
	private String email;
	
	public void setEmail(String email1) {
		this.email=email1;
	}


	public AddPassenger[] getP() {
		return p;
	}

	public void setP(AddPassenger[] p) {
		this.p = p;
	}

	public void searchFlight() {
		 String[] location= {"pune", "delhi", "hydrabad", "mumbai", "banglore"};
		Scanner sc = new Scanner(System.in);
		
	// **************For Origin Selection *****************
	System.out.println("Please Enter the Origin from below options :");
	System.out.println("1.Pune 2.Delhi 3.Hydrabad 4.Mumbai 5.Banglore");
		 origin1 = sc.next();
		int count1=0;
			for (int k=0; k<location.length; k++) {
				if(location[k].equals(origin1)) {
					count1=1; 
					break;
					}
			}
					while(count1==0) {
						System.out.println("please enter valid input");
						origin1 = sc.next();
						for (int i=0; i<location.length; i++) {
							if(location[i].equals(origin1)) {
								count1=1; 				
							}
						}
				}
				
	// **************For Destination Selection *****************
	System.out.println("Please Enter the Destination from above options :");
	destination1 = sc.next();
	
	int count2=0;
	
	for (int k=0; k<location.length; k++) {
		//checking the origin and destination are not same
		while(destination1.equals(origin1)) {
			System.out.println("Origin and destination must not be same !");
			System.out.println("please enter valid input");
			destination1 = sc.next();
			}
		//check if the input is correct
		for (int h=0; h<location.length; h++) {
		if(location[h].equals(destination1)) {
			count2=1; 
			break;
			}
		}
		//check if the input is correct
			while(count2==0) {
				System.out.println("please enter valid input");
				destination1 = sc.next();
				//checking the origin and destination are not same
				while(destination1.equals(origin1)) {
					System.out.println("Origin and destination must not be same !");
					System.out.println("please enter valid input");
					destination1 = sc.next();
					}
				//check if the input is correct
				for (int i=0; i<location.length; i++) {
					if(location[i].equals(destination1)) {
						count2=1; 	
						}
					}
			}
	}

//	 **************For flight_date Selection *****************
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
	        sdf.setLenient(false);
	        System.out.println("Please enter a date (yyyy-mm-dd)");
	         flight_date1 = sc.next();
	        try{
	             sdf.parse(flight_date1);
	        }
	        catch(Exception e)
	        {
	            System.out.println("please enter valid date");
		        flight_date1 = sc.next();
	        }  
	                
	         }
		
// *****Method to search flight in database*********
	
	public int searchFlightinDatabase() {
		Scanner sc = new Scanner(System.in);
		String flightNinput;
		int count=0;
        	
		Configuration config = new Configuration();
		config.configure("skytech.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query<FlightDetails> query=session.createQuery("from FlightDetails flight_details WHERE flight_details.origin ='" + origin1 + "' AND flight_details.destination= '" + destination1 + "' AND flight_details.flight_date= '" + flight_date1 + "'");
		List<FlightDetails> list=query.list();
		session.close();
		
		int lSize=list.size();
		if(lSize==0) {
			System.out.println("No flights are Available");
			System.out.println("enter n to back to menu");
			flightNinput=sc.next();
			if(flightNinput.equals("n")){
				return 0;
			}else {
			while(!flightNinput.equals("n")) {
				System.out.println("enter n to back to menu");
				if(flightNinput.equals("n")){
					return 0;
				}
			}
			}
		}else {
			System.out.println(list);
			System.out.println("***Enter flight Name to Select Flight***");
			System.out.println("***Enter n to go back to menu***");
			flightNinput=sc.next();
			if(flightNinput.equals("n")) {
				return 0;
			}else {
			while(count==0) {
			for (int i=0; i<lSize; i++) {
				if(!flightNinput.equals(list.get(i).getFlight_name())) {
				System.out.println("please enter correct flight name");
				flightNinput=sc.next();
				}else {
					count=1;
					addPassenger(list.get(i));	
					return 1;
				}
			}
			}
		}
		}
		return 0;
	}


//****************Add pasenger details*****************
	public void addPassenger(FlightDetails list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of tickets you want to Book.(max 5)");
		passengerNo=sc.nextInt();
		p=new AddPassenger[passengerNo];
		while(passengerNo>5) {
			System.out.println("you can only book max 5 tickets at a time");
			passengerNo=sc.nextInt();
			p=new AddPassenger[passengerNo];
		}
//		***************************************************************
		for(int i=0; i<passengerNo; i++) {
		if(i>0) {
			System.out.println("***Enter next Passenger Details***");
		}
		String fName;
		String lName;
		int age;
		String gender;
		String fClass;
		int count4=0;
		int count5=0;
		System.out.println("Enter First Name");
		fName=sc.next();
		System.out.println("Enter Last Name");
		lName=sc.next();
		System.out.println("Enter Age");
		age=sc.nextInt();
		System.out.println("Enter Gender (male,female,other)");
		gender=sc.next();
		if(gender.equals("male") || gender.equals("female")|| gender.equals("other")) {
			count4=1;
		}
		while(count4==0) {
		System.out.println("Please Enter valid input in Gender  (male,female,other)");
		gender=sc.next();
		if(gender.equals("male") || gender.equals("female")|| gender.equals("other")) {
			count4=1;
		}
		}
		
		System.out.println("Enter Class from below option");
		System.out.println("1. Economy       2. Business");
		fClass=sc.next();
		if(fClass.equals("economy") || fClass.equals("business")) {
			count5=1;
		}
		while(count5==0) {
		System.out.println("Please Enter valid input in class");
		fClass=sc.next();
		if(fClass.equals("economy") || fClass.equals("business")) {
			count5=1;
		}
		}
		int seatGen=ThreadLocalRandom.current().nextInt(1, 101);
		String ticketGen=""+seatGen+""+fName.charAt(0)+""+lName.charAt(0)+""+ThreadLocalRandom.current().nextInt(100, 10001);
		p[i]= new AddPassenger(email ,fName, lName, age, gender, fClass,list.getFlight_name(),list.getOrigin(),list.getDestination(),list.getFlight_date(),list.getOrigin_time(),list.getDestination_time(),seatGen,ticketGen,"Booked");
		}
		

		//****************Fare breakup Summary*****************
		
		
		int eco=list.getEconomy_price();
		int busi=list.getBusiness_price();
		totalAmount=0;
			System.out.println("****Your total Bill Summary****");
			
			for(int i=0; i<p.length; i++) {
				if(p[i].getfClass().contains("economy")) {
				System.out.println(p[i].getfName() + " " +p[i].getlName() +" "+p[i].getfClass() +" Class"+" Price : "+eco);
				totalAmount+=eco;
			}
				else {
					System.out.println(p[i].getfName() + " " +p[i].getlName() +" "+p[i].getfClass() +" Class"+" Price : "+busi);
					totalAmount+=busi;
				}
			}
			System.out.println("**Total Amount to Pay : "+totalAmount);
			System.out.println("=================================");
	}
	
	public int summary() {
		Scanner sc = new Scanner(System.in);
		String desision;
		
			System.out.println("enter (y) to continue to payment option");
			System.out.println("enter (n) to cancel and go back to menu");
			desision=sc.next();
			if(desision.equals("y")){
				Payment p1 = new Payment();
				p1.processPayment(totalAmount,p);	
			}else if(desision.equals("n")) {
				return 0;
			}
			while(!desision.equals("y") && !desision.equals("n")) {
				System.out.println("please enter valid input");
				desision=sc.next();
				if(desision.equals("y")){
					Payment p1 = new Payment();
					p1.processPayment(totalAmount,p);	
				}else {
					return 10;
				}
	}
			return 10;
	}
}

