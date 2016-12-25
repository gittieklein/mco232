package exceptions;

public class DuplicateAgentException extends RuntimeException
{
	public DuplicateAgentException()
	{
		super("This travel agent already exists");
	}
}
