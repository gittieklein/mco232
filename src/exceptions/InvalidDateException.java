package exceptions;

/*
 * I made another exception for invalid date because we had to do input validation
 * by the passport class. so if the issue date is before the birth date, etc., then
 * the invalid date exception is thrown
 */
public class InvalidDateException extends RuntimeException
{

	public InvalidDateException()
	{
		super("Invalid date");
	}
}
