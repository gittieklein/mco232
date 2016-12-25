package exceptions;

public class CardExpiredException extends RuntimeException
{
	public CardExpiredException()
	{
		super("Card expired");
	}
}
