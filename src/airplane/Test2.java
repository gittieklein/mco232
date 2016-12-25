package airplane;

import exceptions.*;

public class Test2 
{
	public static void main(String[] args)
	{
		//using customer
		Address house = new Address("1154 E 24th Street", "Brooklyn", "New York", "11210");
		CreditCard cc = new CreditCard(123456789, "2017-04-15", 1234);
		CreditCard cc2 = new CreditCard(98764321, "2019-05-16", 6985);
		Customer customer1 = new Customer(123456, "Gittie", "Klein", "female", "1824 E 24th Street",
				"Brooklyn", "New York", "11229", "3475630372", cc);
		Customer customer2 = new Customer(456789, "Raizy", "Klein", "female", house, "7183771298", cc2);

		System.out.println("Customer 1, Customer ID: " + customer1.getCustomerID());
		System.out.println("Customer 2, Customer ID: " + customer2.getCustomerID());
		System.out.println();

		//add charge
		System.out.println(cc.getBalance()); 
		try
		{
			customer1.chargeCard(500);
		}
		catch (InsufficientFundsException e)
		{
			System.out.println(e);
		}
		catch (InvalidPinException x)
		{
			System.out.println(x);
		}
		catch (CardExpiredException n)
		{
			System.out.println(n);
		}
		System.out.println(cc.getBalance()); 
		System.out.println();

		System.out.println(cc2.getBalance());
		try
		{
			customer2.chargeCard(6500);
		}
		catch (InsufficientFundsException e)
		{
			System.out.println(e);
		}
		catch (InvalidPinException x)
		{
			System.out.println(x);
		}
		catch (CardExpiredException n)
		{
			System.out.println(n);
		}
		System.out.println(cc2.getBalance());
		System.out.println();

		//compare
		if(customer1.compareTo(customer2) < 0)
			System.out.println("Customer 1 comes before customer 2.");
		else if(customer1.compareTo(customer2) > 0)
			System.out.println("Customer 1 comes after customer 2.");
		else
			System.out.println("Customer 1 is the same as customer 2.");
		System.out.println();

		if(customer1.equals(customer2))
			System.out.println("Customer 1 is the same as customer 2.");
		else
			System.out.println("Customer 1 is not the same as customer 2.");
		System.out.println();

		System.out.println("Customer 1:");
		System.out.println(customer1);
		System.out.println();

		System.out.println("Customer 2:");
		System.out.println(customer2);
		System.out.println();

		//using travel agent
		TravelAgent ta = new TravelAgent(198756, "185-68-3785", "Chaya", "Brody", "female",
				"13 Rockbridge Road", "Lakewood", "New Jersey", "08701", "6462558006");

		//book ticket
		System.out.println(ta.getEarnings());
		ta.bookTicket(598.36);
		System.out.println(ta.getEarnings());
		System.out.println();

		//employee id ss#
		System.out.println("Employee ID: " + ta.getEmployeeID());
		System.out.println("SS#: "+ ta.getSSN());

		//change commission rate
		TravelAgent.setCommissionRate(.2);

		//book ticket
		System.out.println(ta.getEarnings());
		ta.bookTicket(459.21);
		System.out.println(ta.getEarnings());
		System.out.println();

		//compare travel agent to customer and show that not equal
		if(ta.equals(customer1))
			System.out.println("Travel agent is the same as customer 1.");
		else
			System.out.println("Travel agent is not the same as customer 1.");
		System.out.println();

		//display travel agent
		System.out.println(ta);
		System.out.println();

		//using passenger
		Passport pp = new Passport("952147",  "Rochel", "Klein", "1999-03-05", "New York",
				"2011-02-25", "2017-05-19", "White");
		Passenger p1 = new Passenger(658741, "Rochel", "Klein", "female", "1824 E 24th Street",
				"Brooklyn", "New York", "11229", "7186148799", pp);
		Passenger p2 = new Passenger(321854, "Miriam", "Klein", "female", "1824 E 24th Street",
				"Brooklyn", "New York", "11229", "7189865072");

		if(p1.hasPassport())
			System.out.println("Passenger 1 has a passport");
		else
			System.out.println("Passenger 1 does not have a passport");
		System.out.println();

		if(p2.hasPassport())
			System.out.println("Passenger 2 has a passport");
		else
			System.out.println("Passenger 2 does not have a passport");
		System.out.println();

		System.out.println("Passenger 1: " + p1.getPassport());
		System.out.println();

		System.out.println("Passenger 2: " + p2.getPassport());
		System.out.println();

		System.out.println("Passenger 1 ID: " + p1.getID());
		System.out.println();

		System.out.println("Passenger 2 ID: " + p2.getID());
		System.out.println();

		//check if passengers are equal
		if(p1.equals(p2))
			System.out.println("Passenger 1 is the same as passenger 2.");
		else
			System.out.println("Passenger 1 is not the same as passenger 2.");
		System.out.println();

		System.out.println(p1);
		System.out.println();

		System.out.println(p2);
		System.out.println();

		//uses seat class
		Seat s = new Seat("FIRSTCLASS");

		//book seat

		try
		{
			s.bookSeat(p1);
		}
		catch (SeatNotAvailableException e)
		{
			System.out.println(e);
		}

		System.out.println("The seat is available: " + s.isAvailable());
		System.out.println();

		System.out.println(s.getSeatType());
		System.out.println();

		System.out.println(s.getPassenger());
		System.out.println();

		System.out.println(s);
		System.out.println();

		//cancel seat

		try
		{
			s.cancelReservation(p1);
		}
		catch (SeatNotBookedException f)
		{      
			System.out.println(f);
		}

		System.out.println("The seat is available: " + s.isAvailable());
		System.out.println();
	}
}
