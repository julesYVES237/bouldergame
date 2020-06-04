package game.exception;

/**
 * Roll when Rockford is not on the map.
 *
 */
/**
 * @author mael
 *
 */
public class RockfordNotInLevelException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RockfordNotInLevelException()
	{
		super();
	}

	public RockfordNotInLevelException(String message)
	{
		super(message);
	}

	public RockfordNotInLevelException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RockfordNotInLevelException(Throwable cause)
	{
		super(cause);
	}
}
