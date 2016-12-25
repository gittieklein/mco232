package exceptions;

public class SeatNotAvailableException extends RuntimeException
{
	public SeatNotAvailableException()
	{
		super("seat not available");
	}
}
