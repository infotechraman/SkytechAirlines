package com.test;

import java.util.Scanner;
import java.util.UUID;

import org.hibernate.type.CustomCollectionType;

import com.customerSupport.CustomerSupport;
import com.loginSignup.FirstMenu;
import com.mybooking.Bookingdetails;
import com.paymentFeature.Payment;
import com.searchFlights.SelectFlight;

public class Client {

	public static void main(String[] args) {
		String email="";
		int userInput=0;
		Scanner sc = new Scanner(System.in);		

				
	
		
		// main Switch case
		do {
		switch (userInput) {
//		***************loginSignup component***********
		case 0:
			
			System.out.println("\n\t\t\t\t\t|                SKYTECH  Airlines               |");
			System.out.print("\t\t\t\t\t|        Welcome to Flight Booking System        |\n");
			System.out.print("\t\t\t\t\t|________________________________________________|\n\n");
		
			FirstMenu first=new FirstMenu();
			email=first.fMenu();
			if(!email.equals("")) {
				userInput=10;
			}
			break;
			
			//****************Search flight**************		
		case 1:	
		String userStringInput;
	
			int returnOutput=0;
			int count=0;
			
			SelectFlight dd = new SelectFlight();	
			dd.setEmail(email);
		
			do {
			switch (returnOutput) {
			case 0:
				 dd.searchFlight();
				 returnOutput=dd.searchFlightinDatabase();
				break;
			case 1:
				returnOutput = dd.summary();
				userInput=returnOutput;
				break;

			default:
				count=1;
				userInput=10;
				break;
			}
			
		}while(count==0);
		
			break;
			
			//****************Customer Support**************		
		case 2:	
			CustomerSupport cs= new CustomerSupport();
			cs.support();
			System.out.println("enter 1 to go back to menu");
			do {
				userInput=sc.nextInt();
				
				if(userInput==1) {
					userInput=10;
					break;
				}
			}while(userInput != 1);
				
			break;
			
//			**************my bookings**********************	
		case 3:
			Bookingdetails bd = new Bookingdetails();
			userInput= bd.mybookings(email);
			break;
		case 10:
			System.out.println("enter 1 for search flight");
			System.out.println("enter 2 for  Customer Support");
			System.out.println("enter 3 for  my bookings");
			System.out.println("enter 4  to logout");
			
			do {
				userInput=sc.nextInt();
				
				if(userInput==1) {
					userInput=1;
					break;
				}else if(userInput==2){
					userInput=2;
					break;
				}else if(userInput==3){
					userInput=3;
					break;
				}else if(userInput==4){
					userInput=100;
					break;
				}
			}while(userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4);
					
			break;
		case 4:
			System.out.println("Logged out successfully");
			System.out.println("Thankyou for visiting !!");

			userInput=100;
			break;
		default:
			break;
		}
		}while(userInput != 100);
		
}
}
