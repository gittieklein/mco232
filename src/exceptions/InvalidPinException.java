package exceptions;

public class InvalidPinException extends RuntimeException
{
	public InvalidPinException()
	{
		super("invalid pin");
	}
}
