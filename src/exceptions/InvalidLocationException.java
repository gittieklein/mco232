package exceptions;

public class InvalidLocationException extends RuntimeException
{
	public InvalidLocationException()
	{
		super("invalid location");
	}
}
