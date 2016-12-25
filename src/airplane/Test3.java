package airplane;

import exceptions.DuplicateAgentException;
import exceptions.DuplicateCustomerException;
import exceptions.DuplicateDataException;
import exceptions.DuplicatePassengerException;
import exceptions.InvalidDateException;
import exceptions.NotFoundException;
import exceptions.SeatNotAvailableException;
import exceptions.SeatNotBookedException;

public class Test3 
{
	public static void main(String[] args)
	{
		TravelAgency travel = new TravelAgency();
		
		try
		{
			CreditCard cc = new CreditCard(123456789, "2017-04-15", 1234);
			travel.addCustomer("Gittie", "Klein", "female", "1824 E 24th Street",
					"Brooklyn", "New York", "11229", "3475630372", cc);
		}
		catch(DuplicateCustomerException e)
		{
			System.out.println(e);
		}
		
		try
		{
			travel.addAgent("185-68-3785", "Chaya", "Brody", "female",
					"13 Rockbridge Road", "Lakewood", "New Jersey", "08701", "6462558006");
		}
		catch(DuplicateAgentException e)
		{
			System.out.println(e);
		}
		
		try
		{
			Passport passport = new Passport("952147",  "Rochel", "Klein", "1999-03-05", "New York",
					"2011-02-25", "2017-05-19", "White");
			try
			{
				travel.addPassenger("Rochel", "Klein", "female", "1824 E 24th Street",
						"Brooklyn", "New York", "11229", "7186148799", passport);
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
		
		try
		{
			Passport passport = new Passport("985214",  "Miriam", "Klein", "1994-08-03", "New York",
					"2011-02-25", "2017-05-19", "White");
			try
			{
				travel.addPassenger("Miriam", "Klein", "female", "1824 E 24th Street",
						"Brooklyn", "New York", "11229", "7189865072", passport);
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
		//System.out.println(travel);
		
		try
		{
			travel.addScheduledFlight(1234, "2016-05-30");
		}
		catch(DuplicateDataException e)
		{
			System.out.println(e);
		}
		
		try
		{
			travel.bookFlight(1234, 1, 1, 1, 354.19);
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
		
		try
		{
			travel.addScheduledFlight(4569, "2016-08-25");
		}
		catch(DuplicateDataException e)
		{
			System.out.println(e);
		}
		
		try
		{
			travel.bookFlight(4569, 2, 5, 1, 354.19);
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
		
		System.out.println(travel);
		
		try
		{
			travel.cancelFlight(1234, 5, 1);
		}
		catch (NotFoundException e)
		{
			System.out.println(e);
		}
		catch(SeatNotBookedException x)
		{
			System.out.println(x);
		}
		
		System.out.println(travel);
	}
}
