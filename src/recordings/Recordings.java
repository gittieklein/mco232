package recordings;

public class Recordings 
{
	private String title;
	private String artist;
	private int seconds;

	/**
	 * No argument constructor
	 * initializes to default
	 * default title: Unknown Recording
	 * default artist: Unknown Artist
	 * default seconds: 0
	 */
	public Recordings()
	{
		this("Unknown Recording", "Unknown Artist", 0);
	}
	
	/**
	 * Constructor: title supplied, artist and seconds set to default
	 * @param title the title of the recording
	 */
	public Recordings(String title)
	{
		this(title, "Unknown Artist", 0);
	}
	
	/**
	 * Constructor: title and artist supplied, seconds set to default
	 * @param title the title of the recording
	 * @param artist the artist of the recording
	 */
	public Recordings(String title, String artist)
	{
		this(title, artist, 0);
	}
	
	/**
	 * Constructor: title, artist and seconds supplied
	 * @param title the title of the recording
	 * @param artist the artist of the recording
	 * @param seconds the time of the recording in seconds
	 */
	public Recordings(String title, String artist, int seconds)
	{
		this.title = title;
		this.artist = artist;
		
		if(seconds < 0)
			throw new IllegalArgumentException("The time of the recording must be positive.");
		
		this.seconds = seconds;
	}
	
	/**
	 * Constructor: to copy a recording object
	 * a recording object is supplied
	 * @param song a recording object
	 */
	public Recordings(Recordings song)
	{
		this(song.getTitle(), song.getArtist(), song.getSeconds());
	}
	
	/**
	 * Getter method
	 * @return the title of the recording
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Getter method
	 * @return the artist of the recording
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Getter method
	 * @return the time of the recording in seconds
	 */
	public int getSeconds()
	{
		return seconds;
	}
	
	/**
	 * Setter method
	 * @param title the title of the recording
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Setter method
	 * @param artist the artist of the recording
	 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	/**
	 * Setter method
	 * @param seconds the time of the recording in seconds
	 */
	public void setTime(int seconds)
	{
		if(seconds < 0)
			throw new IllegalArgumentException("The time of the recording must be positive.");
		
		this.seconds = seconds;
	}
	
	/**
	 * Setter method
	 * @param title the title of the recording
	 * @param artist the artist of the recording
	 * @param seconds the seconds of the recording
	 */
	public void setRecording(String title, String artist, int seconds)
	{
		this.title = title;
		this.artist = artist;
		
		if(seconds < 0)
			throw new IllegalArgumentException("The time of the recording must be positive.");
		
		this.seconds = seconds;
	}
	
	/**
	 * covert the time from seconds to minutes
	 * returned as a type double
	 * @return the time in minutes
	 */
	public double timeMinutesDouble()
	{
		double min;
		min = (double)seconds / 60.0;
		return min;
	}
	
	/**
	 * the toString method overrides the default toString method
	 * @return the output of the object as a String
	 */
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		output.append("Recording: ");
		output.append("\nTitle: " + title);
		output.append("\nArtist: " + artist);
		output.append("\nTime in Seconds: " + seconds);
		return output.toString();
	}
}