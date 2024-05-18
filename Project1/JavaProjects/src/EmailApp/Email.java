package EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 100;
	private String alternateEmail;
	private int passwordLength = 10;
	private String companySuffix = "randCompany.com";
	
	public Email(String firstname, String lastname) {
		this.firstName = firstname;
		this.lastName = lastname;
		
		this.department = setDepartment();
		this.password = randomPassword(this.passwordLength);
		
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	private String setDepartment() {
		System.out.print("Enter the department:\n1 for sales\n2 for development \n3 for accounting \n0 for none");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "Sales";
		}
		else if(depChoice == 2) {
			return "dev";
		}
		else if(depChoice == 3) {
			return "accounting";
		}
		else {
			return "nothing";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePass(String password) {
		this.password = password;
	}
	
	public int getCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlt() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String displayInfo() {
		return "Display name: " + firstName + " " + lastName +
				"\nCompany Email: " + email + "\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
