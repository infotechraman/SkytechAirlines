package com.loginSignup;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FirstMenu {

	
public String fMenu() {
	FirstMenu fmenu=new FirstMenu();
	
	
		int n;
		Scanner sc=new Scanner(System.in);
		Signup sign=new Signup();
		Login login=new Login();
		do {
		
			System.out.println("\n\t\t\t\t\t\t\t   MAIN MENU");
		System.out.println("\n\t\t\t\tPress 1 for User SIgnup\t\t\tPress 2 for User Login");
		System.out.println("\n\t\t\t\t-----------------------\t\t\t----------------------");
		n=sc.nextInt();
	
		
		switch(n) {
		
		case 1 : 
			do {
	
			
				sign.signupCode();
				//**********************To create connection with Database******************
				
				System.out.println("\n\n");				
				Configuration conf=new Configuration();
				conf.configure("skytech.cfg.xml");
				SessionFactory factory=conf.buildSessionFactory();
				Session session=factory.openSession();
				Transaction tx=session.beginTransaction();
				session.persist(sign);
				tx.commit();
				session.close();
				System.out.println("\nYour Responce is Submited Successfully\n\n");
				System.out.println("Press 1 for User Sign up :");
				System.out.println("Press 2 for User Log in  :");
				n=sc.nextInt();
				
				
			}while(n==1);
			
		
		case 2 :  
				
				login.getEmail();
				login.getPassword();
								
				String forget = "",email1=" ",pass="";
				
				do {
					System.out.print("\n\n\t\t\t\t\t====================_Log-In_====================\n\n");
				
					//..................to validate email id......................
					Pattern pattern;
					do{	
						
						System.out.print("Enter Email-ID :");
						email1=sc.next();
						
				String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

			    pattern = Pattern.compile(email_regex);
			    
			    if(pattern.matcher(email1).matches()==false){
			    	System.out.println("\t\t\t\t\t\t *Enter valid Email ID.  Ex : abcd@abc.com");
			    }
			    
				}while((pattern.matcher(email1).matches())==false);
					
				//..................to validate Password......................
					do {
				    	  
				    	   System.out.print("Password :");
				    	  	 pass=sc.next();
				       
				    	  	 if (pass.length()<=7) {
				    	  		 System.out.println("\t\t\t\t\t*Please Enter 8 Character at least\n");
				    	  	 	}
				    	  	 
				        }while(pass.length()<=7) ;
					
					try{
						Configuration cfg=new Configuration();
						cfg.configure("skytech.cfg.xml");
						SessionFactory factory=cfg.buildSessionFactory();
						Session session=factory.openSession();
						Transaction tx=session.beginTransaction();
						Query<Signup>query2= session.createQuery("FROM Signup loginsignup WHERE loginsignup.email='"+email1+ "'AND loginsignup.password='"+pass+"'");
					 	List<Signup> list =query2.list();
					 		session.close();
					 		email1=list.get(0).getEmail();	
						 	pass=list.get(0).getPassword();
						 	String Name=list.get(0).getFirst_name();
						 	String LName=list.get(0).getLast_name();
							
						 	System.out.println("\n Hey..! "+Name+" "+LName+" you have log in successfully.");
						 	return email1;
					}catch(Exception e) {
						System.out.println("\n\t\t\t\t\t* Invalid Credentials");
													
							System.out.println("\n\t\tForget Password(Yes/No)\t\t\tPress 1 Back to main Menu");
							do {
							System.out.println("Enter your Choice");
							forget=sc.next();
							
							}while(!forget.equalsIgnoreCase("no") && !forget.equalsIgnoreCase("yes") && !forget.equalsIgnoreCase("1"));
					}
					
				}while(forget.equalsIgnoreCase("no"));
				
//*******************************************Go Back to Main Menu********************************************************
					if(forget.equalsIgnoreCase("1")){
						fmenu.fMenu();
					}
//******************************************Forget Password**************************************
				
				if(forget.equalsIgnoreCase("yes")) {
					
					System.out.print("\t\t\t\t\t====================Forget Password====================\n\n");
			
	
				//..................to validate email id......................
					
					String forgetemail="";
					Pattern pattern;
					do{	
						
						System.out.print("Enter Email-ID :");
						forgetemail=sc.next();
						
				String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

			    pattern = Pattern.compile(email_regex);
			    
			    if(pattern.matcher(forgetemail).matches()==false){
			    	System.out.println("\t\t\t\t\t\t *Enter valid Email ID.  Ex : abcd@abc.com");
			    }
			    
				}while((pattern.matcher(email1).matches())==false);
					
						
		
					
					
					System.out.print("What is  name of your Favorate Pet/Dish/Place :");
					String sequrityQ=sc.next();
					
		//..................to validate Password......................
					String forgetpass="";
					do {
				    	  
				    	   System.out.print("Enter New Password:");
				    	   forgetpass=sc.next();
				       
				    	  	 if (forgetpass.length()<=7) {
				    	  		 System.out.println("\t\t\t\t\t*Please Enter 8 Character at least\n");
				    	  	 	}
				    	  	 
				        }while(forgetpass.length()<=7) ;
					
			 
					 

					
//********************************* to update *************************************			
						
				try {
					
					Configuration cfg=new Configuration();
					cfg.configure("skytech.cfg.xml");
					SessionFactory factory=cfg.buildSessionFactory();
					Session session=factory.openSession();
					Transaction tx=session.beginTransaction();
					Query<Signup>query2= session.createQuery("UPDATE Signup loginsignup SET password='"+forgetpass+"' WHERE email='"+forgetemail+ "' AND sequrity_answer='"+sequrityQ+"'");
					int i=query2.executeUpdate();
					List<Signup> list =query2.list();
				 	forgetemail=list.get(0).getEmail();	
				 	sequrityQ=list.get(0).getSequrity_answer();
					session.close();
					System.out.println("\nPassword has been updated successfully !");
					System.out.println("\nPress 1 for back to main menu :");
					
					n=sc.nextInt();
		
					
			}catch(Exception e){
				System.out.println("\nEmail or Answer is not found match in the record");
				System.out.println("\nPress 1 for back to main menu :");
				
				n=sc.nextInt();
				
				} 
				}else {
					
				}
					break;
		default :  System.out.println("Please enter valid input");
		
					fmenu.fMenu();
					}
		
}while(n==1);
		return "";
}
	
}



