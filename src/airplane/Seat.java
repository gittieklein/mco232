package airplane;

import exceptions.*;

public class Seat 
{
	private boolean available;
	private Passenger passenger;
	private SeatType seatType;
	
	/**
	 * constructor
	 * @param seat
	 */
	public Seat(String seat)
	{
		available = true;
		passenger = null;
		seatType = SeatType.valueOf(seat);
	}
	
	/**
	 * book a seat
	 * @param p passenger object
	 */
	public void bookSeat(Passenger p)
	{
		if(available == true)
		{
			available = false;
			passenger = p;
		}
		else
		{
			throw new SeatNotAvailableException();
		}
	}
	
	/**
	 * cancel a reservation
	 * @param p passenger object
	 */
	public void cancelReservation(Passenger p)
	{
		if(available == true)
		{
			throw new SeatNotBookedException();
		}
		else
		{
			available = true;
			passenger = null;
		}
	}
	
	/**
	 * check if a seat is available
	 * @return true if available, false if not available
	 */
	public boolean isAvailable()
	{
		if(available == true)
			return true;
		else
			return false;
	}
	
	/**
	 * getter method
	 * @return the seat type
	 */
	public SeatType getSeatType()
	{
		return seatType;
	}
	
	/**
	 * getter method
	 * @return deep copy of the passenger
	 */
	public Passenger getPassenger()
	{
		return new Passenger(passenger);
	}
	
	public String toString()
	{
		StringBuilder seat = new StringBuilder();
		seat.append("Availability status: ");
		if(available)
			seat.append("available");
		else
			seat.append("full");
		seat.append("\nPassenger:\n");
		seat.append(passenger.toString());
		seat.append("\nSeat Type: " + seatType);
		return seat.toString();
	}
}
