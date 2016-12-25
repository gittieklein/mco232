package phoneBook;

public class PhoneBookEntry 
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	/**
	 * constructor
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public PhoneBookEntry(String firstName, String lastName, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * checks to see if the phone numbers of the 2 objects are equal
	 * @param cmpr the object to check if equal
	 * @return true or false if the objects phone numbers are the same
	 */
	@Override
	public boolean equals(Object cmpr)
	{
		if(this == cmpr)
			return true;
		if(cmpr == null)
			return false;
		if(getClass() != cmpr.getClass())
			return false;
		PhoneBookEntry rename = (PhoneBookEntry) cmpr;
		if(this.getPhoneNumber() == rename.getPhoneNumber())
			return true;
		return false;
	}
	
	/**
	 * comapres to see which objects are greater than other objects
	 * @param cmpr the object to compare
	 * @return 0, -1 or +1 
	 */
	public int compareTo(PhoneBookEntry cmpr)
	{
		if(this.getPhoneNumber().compareTo(cmpr.getPhoneNumber()) < 0)
			return -1;
		if(this.getPhoneNumber().compareTo(cmpr.getPhoneNumber()) > 0)
			return +1;
		return 0;
	}
	
	/**
	 * @return the info of the phone book entry as a String
	 */
	@Override
	public String toString()
	{
		StringBuilder phone = new StringBuilder();
		phone.append("\nName: " + firstName + " " + lastName);
		phone.append("\nPhone Number: " + phoneNumber);
		return phone.toString();
	}
}
