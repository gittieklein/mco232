package airplane;

public class Address 
{
	private String street;
	private String city;
	private USState state;
	private String zipcode;
	
	/**
	 * copy constructor
	 * @param copy an Address object to copy
	 */
	public Address(Address copy)
	{
		street = copy.street;
		city = copy.city;
		state = copy.state;
		zipcode = copy.zipcode;
	}
	
	/**
	 * constructor to create address
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 */
	public Address(String street, String city, String state, String zipcode)
	{
		this.street = street;
		this.city = city;
		
		int position = state.indexOf(" ");
		if (position >= 0)
		{
			state = state.substring(0, position) + state.substring(position + 1);
		}
		this.state = USState.valueOf(state.toUpperCase());
		
		this.zipcode = zipcode;
	}
	
	/**
	 * getCity method returns the city from the Address
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * getState method returns the state from the Address
	 * @return the state
	 */
	public USState getState()
	{
		return state;
	}
	
	/**
	 * getZipCode method returns the zip code from the Address
	 * @return the zip code
	 */
	public String getZipCode()
	{
		return zipcode;
	}
	
	/**
	 * getStreet method returns the street from the Address
	 * @return the street
	 */
	public String getStreet()
	{
		return street;
	}
	
	/**
	 * the setCity method sets the city to the users input
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * the setState method sets the state to the users input
	 * @param state
	 */
	public void setState(String state)
	{
		int position = state.indexOf(" ");
		if (position >= 0)
		{
			state = state.substring(0, position) + state.substring(position + 1);
		}
		
		this.state = USState.valueOf(state.toUpperCase());
	}
	
	/**
	 * the setStreet method sets the street to the users input
	 * @param street
	 */
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	/**
	 * the setZipCode method sets the zip code to the users input
	 * @param zipcode
	 */
	public void setZipCode(String zipcode)
	{
		this.zipcode = zipcode;
	}
	
	/**
	 * the toString method returns the address as a String
	 * @return address
	 */
	@Override
	public String toString()
	{
		StringBuilder add = new StringBuilder();
		add.append(street);
		add.append("\n" + city + ", " + state.getSymbol() + " " + zipcode);
		return add.toString();
	}
}
