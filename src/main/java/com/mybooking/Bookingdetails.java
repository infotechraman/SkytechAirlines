	package com.mybooking;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.IncrementGenerator;
import org.hibernate.query.Query;

import com.searchFlights.AddPassenger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


public class Bookingdetails {


	public  String  email;
	private String first_name;
	private String last_name;
	private String flight_name;
	private String status;
	private String origin;
	private String destination;
	private String boarding_time;
	private String destination_time;
	private String gender;
	private String flight_date;
	private String fClass;
	private int age;
	private int seat_no;
	private int ticket_number;


@Override
	public String toString() {
		return "Bookingdetails [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", flight_name=" + flight_name + ", status=" + status + ", origin=" + origin + ", destination="
				+ destination + ", boarding_time=" + boarding_time + ", destination_time=" + destination_time
				+ ", gender=" + gender + ", flight_date=" + flight_date + ", fClass=" + fClass + ", age=" + age
				+ ", seat_no=" + seat_no + ", ticket_number=" + ticket_number + "]";
	}
	



	

	//......................................................................................
	public int mybookings(String userEmail) {
		int count1=0;
		int count=0;
		int count3=0;
		String s="";
		int temp=0;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\t MY BOOKING \t\t\t");
		
	String email1=userEmail;


		Configuration config=new Configuration();
		config.configure("skytech.cfg.xml");
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Bookingdetails bd =new Bookingdetails();
		
		Query<AddPassenger> query=session.createQuery("From AddPassenger  booking_details where email='"+email1+"'");
		List<AddPassenger> list=query.list();
		
		System.out.println(list);
		
		//for index length out of bound
	
			if(list.size() !=0) {
		do      
		{
		try {	//for valid pnrno
	
			
			do {   //if ticket is already cancel     
				System.out.print("to Cancel Ticket(Press 1)");
				System.out.print(" Go to main menu (Press 2) ");
int n=sc.nextInt();
if(n==2) {
	return 10;
}
switch(n) {

case 1:	do{   //for wrong input in cancel ticket
		
			System.out.print("\n\nDo you want to cancel your ticket ? Yes : No");
			s=sc.next();
			
  	if(s.equalsIgnoreCase("yes"))
			
			{
				count=1;			
				}
			else if(s.equalsIgnoreCase("no"))
				
			{
				return 10;

			}
			else {
				System.out.println("\n invalid input");
			}
			} while(count==0 || !s.equalsIgnoreCase("yes"));
		
break;
case 2:		
	
	System.out.println("goto menu");
break;

default:
	System.out.print("Please Enter correct Input");
	break;
}
	

		System.out.print("\n Enter your pnrno : ");
			String pnrno1=sc.next();
			
		for (int i=0;i<list.size();i++) {
			if(pnrno1.equals(list.get(i).getTicket_number()))
			{
			
				if(!list.get(i).getStatus().equals("cancel"))
						{
					Query query1=session.createQuery("Update AddPassenger booked_tickets set status='cancelled'"+"where ticket_number='"+pnrno1+"'");
					int row=query1.executeUpdate();
					
//					int amt;
//					amt=list.get(0).amount-(list.get(0).amount*20/100);
//					Query query2=session.createQuery("Update Bookingdetails  set amount="+amt+"where pnrno='"+pnrno1+"'");
//					int row1=query2.executeUpdate();
					session.close();
					System.out.println("\n\nTicket cancelled");
					count1=1;
						
						}		
				else 
			     {
					count1=0;
				System.out.println("\nYour Ticket is already cancel");
				
				}
			}
		
		}
		
	}while(count1==1 || count1==0);
	
	}catch(Exception e) {
		System.out.println("\n Invalid Input...");
		s=sc.next();
		temp=1;
	}
	}while(temp==1);	
			}else {
				System.out.println("you have no bookings yet");
			}
			return 10;
	}	
	
	
	}
		


