package airplane;

import exceptions.*;
import java.util.Scanner;


//this program tests the following classes: 
//Address.java
//Passport.java
//CreditCard.java
//Person.java
public class Test 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String street, city, state, zipcode;
		
		//create an address object
		System.out.println("Please enter your address.");
		System.out.print("Street: ");
		street = input.nextLine();
		System.out.print("City: ");
		city = input.nextLine();
		System.out.print("State: ");
		state = input.nextLine();
		System.out.print("Zipcode: ");
		zipcode = input.nextLine();
		Address address1 = new Address(street, city, state, zipcode);
		
		//display address1 using getters
		System.out.println("\nStreet: " + address1.getStreet());
		System.out.println("City: " + address1.getCity());
		System.out.println("State: " + address1.getState());
		System.out.println("Zipcode: " + address1.getZipCode());
		
		//copy the address object
		Address address2 = new Address(address1);
		
		//make some changes to address2
		System.out.print("\nEnter your street: ");
		street = input.nextLine();
		address2.setStreet(street);
		System.out.print("Enter you city: ");
		city = input.nextLine();
		address2.setCity(city);
		System.out.print("Enter your state: ");
		state = input.nextLine();
		address2.setState(state);
		System.out.print("Enter your zipcode: ");
		zipcode = input.nextLine();
		address2.setZipCode(zipcode);
		
		//display address2 using toString
		System.out.println("\nYour address is:\n" + address2);
		
		String firstName, lastName, phoneNumber, gender;
		
		//create a person object
		System.out.println("\nPlease enter your information.");
		System.out.print("First Name: ");
		firstName = input.nextLine();
		System.out.print("Last Name: ");
		lastName = input.nextLine();
		System.out.print("Gender: ");
		gender = input.nextLine();
		System.out.print("Phone Number: ");
		phoneNumber = input.nextLine();
		Person person1 = new Person(firstName, lastName, gender, address1, phoneNumber);
		
		//create another person object and type in address info instead of address object
		//using the info of the address of address2
		System.out.println("Please enter information for the next person.");
		System.out.print("First name: ");
		firstName = input.nextLine();
		System.out.print("Last name: ");
		lastName = input.nextLine();
		System.out.print("Genger: ");
		gender = input.nextLine();
		System.out.print("Phone Number: ");
		phoneNumber = input.nextLine();
		Person person2 = new Person(firstName, lastName, gender, address2.getStreet(), 
						address2.getCity(), address2.getState().toString(), address2.getZipCode(), phoneNumber);
		
		//display info of person1
		System.out.println("\nAddress:\n" + person1.getAddress());
		System.out.println(person1.getFirstName() + " " + person1.getLastName());
		System.out.println(person1.getPhoneNumber());
		
		//display info of person2
		System.out.println("\n" + person2);
		
		double balance, creditLimit;
		long creditCardID;
		//I made the expiration date variable as a String and in the constructor/setters
		//it will be parsed into local date
		String expirationDate;
		int pin;
		
		//create a credit card object
		System.out.println("\nPlease enter your credit card information.");
		System.out.print("Credit card ID: ");
		creditCardID = input.nextLong();
		input.nextLine();
		System.out.print("Expiration date (enter as YYYY-MM-DD): ");	
		expirationDate = input.nextLine();
		System.out.print("PIN: ");
		pin = input.nextInt();
		CreditCard creditCard1 = new CreditCard(creditCardID, expirationDate, pin);
		
		try
		{
			//add charge to card
			System.out.print("What is the blanace you would like to add? ");
			balance = input.nextDouble();
			System.out.print("What is your PIN? ");
			pin = input.nextInt();
			creditCard1.addCharge(balance, pin);
		}
		catch (InvalidPinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (InsufficientFundsException x)
		{
			System.out.println(x.getMessage());
		}
		
		try
		{
			//add another charge to card
			System.out.print("What is the blanace you would like to add? ");
			balance = input.nextDouble();
			System.out.print("What is your PIN? ");
			pin = input.nextInt();
			creditCard1.addCharge(balance, pin);
		}
		catch (InvalidPinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (InsufficientFundsException x)
		{
			System.out.println(x.getMessage());
		}
		
		//display credit card info
		System.out.println("\n" + creditCard1);
		
		System.out.println("Your balance is " + creditCard1.getBalance());
		
		//create a passport object
		String passportID, birthDate, birthPlace, issueDate, nationality;
		System.out.println("\nPlease enter your passport info.");
		System.out.print("PassportID: ");
		passportID = input.nextLine();
		input.nextLine();
		System.out.print("First Name: ");
		firstName = input.nextLine();
		System.out.print("Last Name: ");
		lastName = input.nextLine();
		System.out.print("Birth Date (enter as YYYY-MM-DD): ");
		birthDate = input.nextLine();
		System.out.print("Birth Place: ");
		birthPlace = input.nextLine();
		System.out.print("Issue Date (enter as YYYY-MM-DD): ");
		issueDate = input.nextLine();
		System.out.print("Expiratioon Date (enter as YYYY-MM-DD): ");
		expirationDate = input.nextLine();
		System.out.print("Nationality: ");
		nationality = input.nextLine();
		Passport passport1 = new Passport(passportID, firstName, lastName, birthDate, 
										birthPlace, issueDate, expirationDate, nationality);
		
		//make a copy with the same address
		Passport passport2 = passport1;
		
		//check that passport1 and passport2 have the same address
		if(passport1.compareTo(passport2) == 0)
			System.out.println("they are equal");
		
		if(passport1.equals(passport2))
			System.out.println("they are equal");
		
		System.out.println(passport1);
	}
}
