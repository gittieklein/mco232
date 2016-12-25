package airplane;

public class Person 
{
	private Address address;
	private String firstName;
	private String lastName;
	private char gender;
	private String phoneNumber;
	
	/**
	 * constructor
	 * makes a deep copy of address so the user can't make changes
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param address
	 * @param phoneNumber
	 */
	public Person(String firstName, String lastName, String gender, Address address, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		/*
		 * I changed it that the method receives a String for the gender, 
		 * because the user may type in the full word male or female,
		 * and then in the constructor, the first character
		 * of the String is assigned to the gender
		 */
		this.gender = gender.charAt(0);			
		this.address = new Address(address);
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Constructor that receives the address fields separately as opposed to an address object
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param phoneNumber
	 */
	public Person(String firstName, String lastName, String gender, String street, 
							String city, String state, String zipcode, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		/*
		 * I changed it that the method receives a String for the gender, 
		 * because the user may type in the full word male or female,
		 * and then in the constructor, the first character
		 * of the String is assigned to the gender
		 */
		this.gender = gender.charAt(0);
		this.address = new Address(street, city, state, zipcode);
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * getter
	 * @return copy of the address
	 */
	public Address getAddress()
	{
		return new Address(address);
	}
	
	/**
	 * getter
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * getter
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * getter
	 * @return phone number
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * getter
	 * @return gender
	 */
	public char getGender()
	{
		return gender;
	}
	
	/**
	 * setter
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 */
	public void setAddress(String street, String city, String state, String zipcode)
	{
		address = new Address(street, city, state, zipcode);
	}
	
	/**
	 * setter
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * setter
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * setter
	 * @param street
	 * @param zipcode
	 */
	public void setStreet(String street, String zipcode)
	{
		address.setStreet(street);
		address.setZipCode(zipcode);
	}
	
	/**
	 * toString method
	 * @return the person object as a String
	 */
	@Override
	public String toString()
	{
		StringBuilder person = new StringBuilder();
		person.append("Name: " + firstName + " " + lastName);
		person.append("\nGender: " + gender);
		person.append("\nAddress:");
		person.append("\n" + address);
		person.append("\nPhone Number: " + phoneNumber);
		return person.toString();
	}
}
