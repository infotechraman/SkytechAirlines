package com.loginSignup;


import java.util.Scanner;
import java.util.regex.Pattern;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="loginsignup")

public class Signup {
	

	@Id	 private String email;
	 private String  first_name;
	 private String last_name;
	 private String password;
	 private String sequrity_answer ;
	private long mo_no;
	
	
	public String getSequrity_answer() {
		return sequrity_answer;
	}
	public void setSequrity_answer(String sequrity_answer) {
		this.sequrity_answer = sequrity_answer;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMo_no() {
		return mo_no;
	}
	public void setMo_no(long mo_no) {
		this.mo_no = mo_no;
	}
	
	

public void signupCode() {

	
		System.out.print("\t\t\t\t\t====================_Sign Up_====================\n\n");
		
			
		
		Scanner sc= new Scanner (System.in);


		System.out.print("First Name : ");
		first_name=sc.next();
	
	
		System.out.print("Last Name :");
		last_name=sc.next();
	
	
//..................to validate email id......................
	Pattern pattern;
		do{	
			
			System.out.print("Email-ID :");
			email=sc.next();
			
	String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    pattern = Pattern.compile(email_regex);
    
    if(pattern.matcher(email).matches()==false){
    	System.out.println("\t\t\t\t\t\t *Enter valid Email ID.  Ex : abcd@abc.com");
    }
    
	}while((pattern.matcher(email).matches())==false);
	
	   
	
//............................Password............................................
	

  
    
    //Checks to see if password is at least 8 characters. 
   
     do {
    	  
    	   System.out.print("Password :");
    	  	 password=sc.next();
       
    	  	 if (password.length()<=7) {
    	  		 System.out.println("\t\t\t\t\t*Please Enter 8 Character at least\n");
    	  	 	}
    	  	 
        }while(password.length()<=7) ;
     
       
       System.out.print("Confirm Password :");
       String confirm_password=sc.next();
       
       if(!confirm_password.equals(password)) {
    	   do {
    		   System.out.println("\t\t\t\t\t*Your Password didn't Match \n ");
    		   System.out.print("Re-Enter Password :");
    		   password=sc.next();
    		   
    		   System.out.print("Confirm Password :");
    		   confirm_password=sc.next();
    		   
    	   }while(!confirm_password.equals(password));
       }

       System.out.println("What is  name of your Favorate Pet/Dish/Place :");
   	sequrity_answer=sc.next();
  
//***************************Mobile Number**********************
	
     String mono;

	do {
		System.out.print("Mobile Number :");
		mo_no=sc.nextLong();
	
		mono=String.valueOf(mo_no);
		
		if((mono.length()<10 )|| (mono.length()>10 )){
		System.out.println("\t\t\t\t\t*Please enter Correct Mobile number it must be 10 digit.\n");
		}
		
		}while((mono.length()<10 )|| (mono.length()>10 ));
}
@Override
public String toString() {
	return "Signup [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password="
			+ password + ", sequrity_answer=" + sequrity_answer + ", mo_no=" + mo_no + "]";
}
		
}
