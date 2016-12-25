package exceptions;

public class DuplicateCustomerException extends RuntimeException
{
	public DuplicateCustomerException()
	{
		super("This customer already exists");
	}
}
