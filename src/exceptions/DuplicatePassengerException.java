package exceptions;

public class DuplicatePassengerException extends RuntimeException
{
	public DuplicatePassengerException()
	{
		super("This passenger already exists");
	}
}
