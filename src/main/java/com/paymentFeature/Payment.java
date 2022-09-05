package com.paymentFeature;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.searchFlights.AddPassenger;
import com.searchFlights.SelectFlight;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_details")
public class Payment {

@Id
private String upi_id;
private String pin;
private int balance;


	public String getUpi_id() {
	return upi_id;
}


public void setUpi_id(String upi_id) {
	this.upi_id = upi_id;
}


public String getPin() {
	return pin;
}


public void setPin(String pin) {
	this.pin = pin;
}


public int getBalance() {
	return balance;
}


public void setBalance(int balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Payment [upi_id=" + upi_id + ", pin=" + pin + ", balance=" + balance + "]";
}


// ****payment method***
	public void processPayment(int tAmount ,AddPassenger[] p) {

//		**************
		String upiId;
		int upiPin;
		Scanner sc = new Scanner(System.in);
		System.out.println("**** Add Payment Details ****");		
		System.out.println("Enter your UPI id");
		upiId = sc.next();
		System.out.println("Enter your UPI pin");
		upiPin = sc.nextInt();
		
	 		
		try {
			Configuration config = new Configuration();
			config.configure("skytech.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query<Payment> query=session.createQuery("from Payment bank_details WHERE upi_id ='" + upiId + "' AND pin= '" + upiPin+ "'");
			List<Payment> list=query.list();
			
			//update database balance
			tAmount=list.get(0).balance-tAmount;
			Query<Payment> query2=session.createQuery("update Payment bank_details set balance="+tAmount+" where upi_id ='"+upiId+"'");
			int row = query2.executeUpdate();
			session.close();
			//add ticket to database		
			bookTicketFinal(p);
			
			System.out.println("Booked Successfully");
		}catch(Exception e) {
			System.out.println(e);
			int count =3;
			while(count>0) {
				System.out.println("***Invalid Credentials***");
				System.out.println("please enter correct details attempt left : "+ count);
				System.out.println("Enter your UPI id");
				upiId = sc.next();
				System.out.println("Enter your UPI pin");
				upiPin = sc.nextInt();
				
				
				try {
					Configuration config = new Configuration();
					config.configure("skytech.cfg.xml");
					SessionFactory factory = config.buildSessionFactory();
					Session session = factory.openSession();
					Transaction tx = session.beginTransaction();
					Query<Payment> query=session.createQuery("from Payment bank_details WHERE upi_id ='" + upiId + "' AND pin= '" + upiPin+ "'");
					List<Payment> list=query.list();
					
					//update database balance
					tAmount=list.get(0).balance-tAmount;
					Query<Payment> query2=session.createQuery("update Payment bank_details set balance="+tAmount+" where upi_id ='"+upiId+"'");
					int row = query2.executeUpdate();
					session.close();
					//add ticket to database
					bookTicketFinal(p);
	
					System.out.println("Booked Successfully");
					System.out.println("This is ticket****************");
					
				}catch(Exception d) {
					count--;
				}
			}
			if(count==0) {
				System.out.println("**your transaction is cancelled**");
			}
			System.out.println("press 1 to go back to menu or 2 to logout");
			
		}	
	}
	
	//to add conform ticket to database
	public void bookTicketFinal(AddPassenger[] p) {
		
		Configuration config = new Configuration();
		config.configure("skytech.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		for(int i=0; i<p.length; i++) {
			Transaction tx = session.beginTransaction();
			session.persist(p[i]);
			tx.commit();
		}
		session.close();
		System.out.println("****Your Booked Tickets******");
		for(int i=0; i<p.length; i++) {
			System.out.println(p[i]);
		}
	}


}
