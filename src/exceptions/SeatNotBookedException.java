package exceptions;

public class SeatNotBookedException extends RuntimeException
{
	public SeatNotBookedException()
	{
		super("Seat wasn't booked");
	}
}
