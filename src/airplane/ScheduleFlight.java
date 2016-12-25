package airplane;

import java.util.ArrayList;
import java.time.LocalDate;
import exceptions.*;

public class ScheduleFlight 
{
	ArrayList<Passenger> passengers;
	Seat[] seats;
	LocalDate departureDate;
	long flightID;
	int availableFirstClassSeats;
	int availableEconomySeats;
	
	/**
	 * constructor
	 */
	public ScheduleFlight(long flightID, String departureDate)
	{
		this.flightID = flightID;
		this.departureDate = LocalDate.parse(departureDate);
		
		passengers = new ArrayList<Passenger>();
		seats = new Seat[10];
		
		availableFirstClassSeats = 5;
		availableEconomySeats = 5;
		
		for(int i = 0; i < seats.length; i++)
		{
			if(i < 5)
				seats[i] = new Seat("FIRSTCLASS");
			else
				seats[i] = new Seat("ECONOMY");
		}
	}
	
	/**
	 * getter method
	 * @param seatNumber
	 * @return the seat type
	 */
	public SeatType getSeatType(int seatNumber)
	{
		return seats[seatNumber].getSeatType();
	}
	
	/**
	 * book seat
	 * @param p person object
	 * @param seatNumber
	 */
	public void bookSeat(Passenger p, int seatNumber)
	{
		for(int i = 0; i < passengers.size(); i++)
		{
			if(passengers.get(i).equals(p))
				throw new DuplicateDataException();
		}
		
		if(seats[seatNumber].isAvailable() == false)
			throw new SeatNotAvailableException();
		
		passengers.add(p);
		seats[seatNumber].bookSeat(p);
		
		if(seatNumber < 5)
			availableFirstClassSeats--;
		else
			availableEconomySeats--;
	}
	
	/**
	 * cancel reservation
	 * @param p person object
	 * @param seatNumber
	 */
	public void cancelReservation(Passenger p, int seatNumber)
	{
		for(int i = 0; i < passengers.size(); i++)
		{
			if(passengers.get(i).equals(p))
				passengers.remove(i);
			
			seats[seatNumber].cancelReservation(p);
			
			if(seatNumber < 5)
				availableFirstClassSeats++;
			else
				availableEconomySeats++;
		}
	}
	
	/**
	 * getter method
	 * @return flight id
	 */
	public long getFlightID()
	{
		return flightID;
	}
	
	/**
	 * getter method
	 * @return departure date
	 */
	public LocalDate getDepartureDate()
	{
		return departureDate;
	}
	
	/**
	 * displays the plane layout
	 * @return the layout of the plane as a string
	 */
	public String viewPlaneLayout()
	{
		StringBuilder plane = new StringBuilder();
		
		plane.append("Flight ID number: " + flightID);
		plane.append("\nDeparture Date: " + departureDate);
		for(int i = 0; i < seats.length; i++)
		{
			plane.append("\n------------------");
			plane.append("\nSEAT " + (i + 1));

			if(seats[i].isAvailable())
			{
				plane.append("\nAvailable");
			}
			else
			{
				plane.append("\nNot available");
				plane.append("\nPassenger:");
				plane.append("\n" + seats[i].getPassenger().toString());
			}
		}	
		return plane.toString();
	}
	
	/**
	 * displays the plane layout
	 * @return the layout of the plane
	 */
	@Override
	public String toString()
	{
		StringBuilder plane = new StringBuilder();
		
		plane.append("Flight ID number: " + flightID);
		plane.append("\nDeparture Date: " + departureDate);
		for(int i = 0; i < seats.length; i++)
		{
			plane.append("\n------------------");
			plane.append("\nSEAT " + (i + 1));

			if(seats[i].isAvailable())
			{
				plane.append("\nAvailable");
			}
			else
			{
				plane.append("\nNot available");
				plane.append("\nPassenger:");
				plane.append("\n" + seats[i].getPassenger().toString());
			}
		}	
		return plane.toString();
	}

}
