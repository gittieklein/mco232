package airplane;

import java.util.ArrayList;
import exceptions.*;

public class TravelAgency 
{
	private ArrayList<ScheduleFlight> flights;
	private ArrayList<Person> persons;
	private static long lastCustomerID = 0;
	private static long lastEmployeeID = 0;
	private static long lastPassengerID = 0;
	
	/**
	 * constructor
	 * Instantiates the Array lists
	 */
	public TravelAgency()
	{
		flights = new ArrayList<ScheduleFlight>();
		persons = new ArrayList<Person>();
	}
	
	/**
	 * adds a customer to the array list persons
	 * first makes sure that no customer has the same first name, last name and phone number
	 * before adding it
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 * @param creditCard
	 */
	public void addCustomer(String firstName, String lastName, String gender, String street,
								String city, String state, String zip, String phoneNumber, 
								CreditCard creditCard)
	{
		for(Person p: persons)
		{
			if(p instanceof Customer)
			{
				if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName) 
													  && p.getPhoneNumber().equals(phoneNumber))
				{
					//customer already exists
					throw new DuplicateCustomerException();
				}
			}
		}
		
		persons.add(new Customer(++lastCustomerID, firstName, lastName, gender,
									street, city, state, zip, phoneNumber, creditCard));
	}
	
	/**
	 * adds a travel agent to the array list persons
	 * first makes sure that no travel agent has the same first name, last name and phone number
	 * before adding it
	 * @param ssNum
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 */
	public void addAgent(String ssNum, String firstName, String lastName, String gender,String street,
								String city, String state, String zip, String phoneNumber)
	{
		for(Person p: persons)
		{
			if(p instanceof TravelAgent)
			{
				if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName) 
													  && p.getPhoneNumber().equals(phoneNumber))
				{
					//travel agent already exists
					throw new DuplicateAgentException();
				}
			}
		}
		
		persons.add(new TravelAgent(++lastEmployeeID, ssNum, firstName, lastName, gender,
									street, city, state, zip, phoneNumber));
	}
	
	/**
	 * adds a passenger to the array list persons
	 * first makes sure that no passenger has the same first name, last name and phone number
	 * before adding it
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 * @param passport
	 */
	public void addPassenger(String firstName, String lastName, String gender, String street,
								String city, String state, String zip, String phoneNumber, Passport passport)
	{
		for(Person per: persons)
		{
			if(per instanceof Passenger)
			{
				if(per.getFirstName().equals(firstName) && per.getLastName().equals(lastName) 
													  && per.getPhoneNumber().equals(phoneNumber))
				{
					//passenger already exists
					throw new DuplicatePassengerException();
				}
			}
		}
		
		persons.add(new Passenger(++lastPassengerID, firstName, lastName, gender, street, city,
								state, zip, phoneNumber, passport));
	}
	
	/**
	 * finds the passenger info based on a passenger id
	 * @param id
	 * @return passenger object
	 */
	public Passenger findPassengerInfo(long id)
	{
		for(Person p: persons)
		{
			if(p instanceof Passenger)
			{
				Passenger p1 = (Passenger) p;
				
				if(p1.getID() == id)
				{
					return new Passenger(p1);
				}
			}
		}
		//the passenger id couldn't be found 
		return null;
	}
	
	/**
	 * finds the customer info based on a customer id
	 * @param id
	 * @return customer object
	 */
	public Customer findCustomer(long id)
	{
		for(Person p: persons)
		{
			if(p instanceof Customer)
			{
				Customer c1 = (Customer) p;
				
				if(c1.getCustomerID() == id)
				{
					return new Customer(c1);
				}
			}
		}
		//the customer id couldn't be found 
		return null;
	}
	
	/**
	 * getter method
	 * @return the array list of passengers
	 */
	public ArrayList<Passenger> getPassengers()
	{
		ArrayList<Passenger> pas = new ArrayList<Passenger>();
		for(Person p: persons)
		{
			if(p instanceof Passenger)
				pas.add(new Passenger((Passenger)p));
		}
		return pas;
	}
	
	/**
	 * add a scheduled flight to the flights array
	 * @param flightNo
	 * @param departDate
	 */
	public void addScheduledFlight(int flightNo, String departDate)
	{
		for(ScheduleFlight f: flights)
		{
			if(f.getFlightID() == flightNo && f.getDepartureDate().equals(departDate))
			{
				throw new DuplicateDataException();
			}
		}
		flights.add(new ScheduleFlight(flightNo, departDate));
	}
	
	/**
	 * book flight
	 * @param flightNo
	 * @param passengerID
	 * @param seatNumber
	 * @param emplyeeID
	 * @param price
	 */
	public void bookFlight(int flightNo, long passengerID, int seatNumber, long employeeID, double price)
	{
		boolean check = false;
		int index = -1;
		
		for(int i = 0; i < persons.size(); i++)
		{
			if(persons.get(i) instanceof Passenger)
			{
				if(((Passenger) persons.get(i)).getID() == passengerID)
				{
					//if the passenger is found, then the check if set to true
					check = true;
					index = i;
				}
			}
		}
		if(check == false)
			throw new NotFoundException();
		
		check = false; //set check back to false to check for the flight
		for(int i = 0; i < flights.size(); i++)
		{
			if(flights.get(i).getFlightID() == flightNo)
			{
				check = true;
				flights.get(i).bookSeat((Passenger)(persons.get(index)), seatNumber);
			}
		}
		if(check == false)
			throw new NotFoundException();
		
		for(Person p: persons)
		{
			if(p instanceof TravelAgent)
			{
				if(((TravelAgent)p).getEmployeeID() == employeeID)
				{
					((TravelAgent) p).bookTicket(price);
				}
			}
		}
	}
	
	/**
	 * cancel a flight
	 * @param flightNo
	 * @param passengerID
	 * @param seatNumber
	 */
	public void cancelFlight(int flightNo, long passengerID, int seatNumber)
	{
		Passenger p = findPassengerInfo(passengerID);
		
		if(p == null)
			throw new NotFoundException();
		
		for(int i = 0; i < flights.size(); i++)
		{
			if(flights.get(i).getFlightID() == flightNo)
			{
				flights.get(i).cancelReservation(p, seatNumber);
			}
		}
	}
	
	/**
	 * to string
	 * @return the plane info as a string
	 */
	@Override
	public String toString()
	{
		StringBuilder plane = new StringBuilder();
		plane.append("Flights:");
		for(ScheduleFlight sf: flights)
		{
			plane.append("\n\n" + sf);
		}
		plane.append("\n\nPersons:");
		for(Person p: persons)
		{
			if(p instanceof Passenger)
				plane.append("\n\nPassenger:");
			else if(p instanceof Customer)
				plane.append("\n\nCustomer:");
			else if(p instanceof TravelAgent)
				plane.append("\n\nTravel Agent:");
			
			plane.append("\n" + p);
		}
		return plane.toString();
	}
}
