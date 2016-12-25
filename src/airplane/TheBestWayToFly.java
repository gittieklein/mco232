package airplane;

import java.util.Scanner;
import exceptions.*;
import java.util.ArrayList;

public class TheBestWayToFly 
{
	public static void main(String[] args)
	{
		//create the travel agency object
		TravelAgency travel = new TravelAgency();
		
		Scanner input = new Scanner(System.in);
		int selection;
		boolean valid;
		
		do
		{
			menu();
			selection = input.nextInt();
			valid = inputValid(selection);
			while(!valid)
			{
				System.out.print("Please make a valid selection: ");
				selection = input.nextInt();
				valid = inputValid(selection);
			}
			input.nextLine();
			
			switch(selection)
			{
				case 1: 
					addCustomer(travel);
					break;
				case 2:
					addAgent(travel);
					break;
				case 3:
					addPassenger(travel);
					break;
				case 4:
					findPassengerInfo(travel);
					break;
				case 5:
					findCusomter(travel);
					break;
				case 6:
					getPassengers(travel);
					break;
				case 7:
					addScheduledFlight(travel);
					break;
				case 8:
					bookFlight(travel);
					break;
				case 9:
					cancelFlight(travel);
					break;
				case 10:
					displayPlane(travel);
					break;
				case 11:
				default:
					System.out.println("Good bye");
					System.exit(0);
			}
			
		}while(selection != 11);
		
	}
	
	/**
	 * menu
	 * drives the program
	 */
	public static void menu()
	{
		System.out.println("\n\nPlease make a selection from the following:\n"
					   + "\n1. Add a Customer"
					   + "\n2. Add a Travel Agent"
					   + "\n3. Add a Passenger"
					   + "\n4. Find a Passenger"
					   + "\n5. Find a Customer"
					   + "\n6. Get the list of Passengers"
					   + "\n7. Add a Scheduled Flight"
					   + "\n8. Book a Flight"
					   + "\n9. Cancel a Flight"
					   + "\n10. Display all the flighs and all the people"
					   + "\n11. Exit Application");
	}
	
	/**
	 * checks if the user inputs correct data
	 * @param selection
	 * @return if data is valid or not
	 */
	public static boolean inputValid(int selection)
	{
		if(selection < 1 || selection > 11)
			return false;
		return true;
	}
	
	/**
	 * adds a customer
	 * @param travel
	 */
	public static void addCustomer(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the following information about the customer:");
		System.out.print("First name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Gender: ");
		String gender = input.nextLine();
		System.out.print("Street: ");
		String street = input.nextLine();
		System.out.print("City: ");
		String city = input.nextLine();
		System.out.print("State: ");
		String state = input.nextLine();
		System.out.print("Zipcode: ");
		String zip = input.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		System.out.println("Please enter the following credit card information:");
		System.out.print("Credit card ID: ");
		long ccid = input.nextLong();
		input.nextLine();
		System.out.print("Expiration date: ");
		String expirationDate = input.nextLine();
		System.out.print("Pin: ");
		int pin = input.nextInt();
		input.nextLine();
		CreditCard cc = new CreditCard(ccid, expirationDate, pin);
		
		try
		{
			travel.addCustomer(firstName, lastName, gender, street, city, state, zip, phoneNumber, cc);
		}
		catch(DuplicateCustomerException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * adds a travel agent
	 * @param travel
	 */
	public static void addAgent(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the following information about the travel agent:");
		System.out.print("First name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Gender: ");
		String gender = input.nextLine();
		System.out.print("Street: ");
		String street = input.nextLine();
		System.out.print("City: ");
		String city = input.nextLine();
		System.out.print("State: ");
		String state = input.nextLine();
		System.out.print("Zipcode: ");
		String zip = input.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		System.out.print("Social Security Number: ");
		String ssn = input.nextLine();
		
		try
		{
			travel.addAgent(ssn, firstName, lastName, gender, street, city, state, zip, phoneNumber);
		}
		catch(DuplicateAgentException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * adds a passenger
	 * @param travel
	 */
	public static void addPassenger(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the following information about the passenger:");
		System.out.print("First name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Gender: ");
		String gender = input.nextLine();
		System.out.print("Street: ");
		String street = input.nextLine();
		System.out.print("City: ");
		String city = input.nextLine();
		System.out.print("State: ");
		String state = input.nextLine();
		System.out.print("Zipcode: ");
		String zip = input.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		System.out.println("Please enter the following passport information:");
		System.out.print("Passport ID: ");
		String passportid = input.nextLine();
		System.out.print("Date of birth: ");
		String dob = input.nextLine();
		System.out.print("Birth place: ");
		String birthPlace = input.nextLine();
		System.out.print("Issue date: ");
		String issueDate = input.nextLine();
		System.out.print("Expiration date: ");
		String expirationDate = input.nextLine();
		System.out.print("Nationality: ");
		String nationality = input.nextLine();
		
		try
		{
			Passport passport = new Passport(passportid, firstName, lastName, dob, birthPlace, issueDate, expirationDate, nationality);
			try
			{
				travel.addPassenger(firstName, lastName, gender, street, city, state, zip, phoneNumber, passport);
			}
			catch(DuplicatePassengerException e)
			{
				System.out.println(e);
			}
		}
		catch(InvalidDateException e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	/**
	 * find passenger
	 * @param travel
	 */
	public static void findPassengerInfo(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nWhat is the passenger ID of the passenger you would like to find? ");
		long id = input.nextLong();
		input.nextLine();
		Passenger p = travel.findPassengerInfo(id);
		System.out.print("\n" + p);
	}
	
	/**
	 * find customer
	 * @param travel
	 */
	public static void findCusomter(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nWhat is the customer ID of the customer you would like to find? ");
		long id = input.nextLong();
		input.nextLine();
		Customer c = travel.findCustomer(id);
		System.out.print("\n" + c);
	}
	
	/**
	 * get the list of all passengers
	 * @param travel
	 */
	public static void getPassengers(TravelAgency travel)
	{
		ArrayList<Passenger> p = new ArrayList<>();
		p = travel.getPassengers();
		for(Passenger pas: p)
			System.out.println(pas);
	}
	
	/**
	 * add a flight
	 * @param travel
	 */
	public static void addScheduledFlight(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the following information about the flight you would like to add: ");
		System.out.print("Flight number: ");
		int flightnum = input.nextInt();
		input.nextLine();
		System.out.print("Departure date: ");
		String dd = input.nextLine();
		try
		{
			travel.addScheduledFlight(flightnum, dd);
		}
		catch(DuplicateDataException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * book a flight
	 * @param travel
	 */
	public static void bookFlight(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the following information about the flight you would like to book: ");
		System.out.print("Flight number: ");
		int flightnum = input.nextInt();
		System.out.print("Passenger ID: ");
		long passengerID = input.nextLong();
		System.out.print("Seat number: ");
		int seatNum = input.nextInt();
		System.out.print("Employee ID: ");
		long employeeID = input.nextLong();
		System.out.print("Price: ");
		double price = input.nextDouble();
		input.nextLine();
		try
		{
			travel.bookFlight(flightnum, passengerID, seatNum, employeeID, price);
		}
		catch(NotFoundException e)
		{
			System.out.println(e);
		}
		catch(DuplicateDataException x)
		{
			System.out.println(x);
		}
		catch(SeatNotAvailableException n)
		{
			System.out.println(n);
		}
	}
	
	/**
	 * cancel flight
	 * @param travel
	 */
	public static void cancelFlight(TravelAgency travel)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the following information about the flight you would like to cancel: ");
		System.out.print("Flight number: ");
		int flightnum = input.nextInt();
		System.out.print("Passenger ID: ");
		long passengerID = input.nextLong();
		System.out.print("Seat number: ");
		int seatNum = input.nextInt();
		input.nextLine();
		
		try
		{
			travel.cancelFlight(flightnum, passengerID, seatNum);
		}
		catch (NotFoundException e)
		{
			System.out.println(e);
		}
		catch(SeatNotBookedException x)
		{
			System.out.println(x);
		}
	}
	
	/**
	 * to string method
	 * @param travel
	 */
	public static void displayPlane(TravelAgency travel)
	{
		System.out.println("\n" + travel.toString());
	}
}
