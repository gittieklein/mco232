package exceptions;

public class DuplicateDataException extends RuntimeException
{
	public DuplicateDataException()
	{
		super("duplicate data");
	}
}
