package exceptions;

public class FullyBookedException extends RuntimeException
{
	public FullyBookedException()
	{
		super("the flight is fully booked");
	}
}
