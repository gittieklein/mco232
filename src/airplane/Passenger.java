package airplane;

import java.time.LocalDate;

public class Passenger extends Person
{
	private Passport passport;
	private long id;
	
	/**
	 * constructor
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 * @param passport
	 */
	public Passenger(long id, String firstName, String lastName, String gender,
							String street, String city, String state, String zip,
							String phoneNumber, Passport passport) 
	{
		super(firstName, lastName, gender, street, city, state, zip, phoneNumber);
		this.id = id;
		this.passport = passport;
	}
	
	/**
	 * Constructor that calls the first constructor and sets passport to null
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNumber
	 */
	public Passenger(long id, String firstName, String lastName, String gender,
							String street, String city, String state, String zip,
							String phoneNumber)
	{
		this(id, firstName, lastName, gender, street, city, state, zip, 
							phoneNumber, null);
	}
	
	/**
	 * copy constructor
	 * @param copy another passenger object
	 */
	public Passenger(Passenger copy)
	{
		super(copy.getFirstName(), copy.getLastName(), String.valueOf(copy.getGender()), 
							copy.getAddress(), copy.getPhoneNumber());
		this.id = copy.id;
		this.passport = copy.passport;
	}
	
	/**
	 * checks to see if the passenger has a passport
	 * @return true if have passport, false if doesn't have passport
	 */
	public boolean hasPassport()
	{
		if(passport == null || passport.getExpirationDate().compareTo(LocalDate.now()) < 0)
			return false;
		return true;
	}
	
	/**
	 * getter method
	 * @return passport object
	 */
	public Passport getPassport()
	{
		return passport;
	}
	
	/**
	 * getter method
	 * @return the id of the passenger
	 */
	public long getID()
	{
		return id;
	}
	
	/**
	 * checks if the passengers are equal based on id
	 * @param obj object to compare
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if(id == other.id)
			return true;
		return false;
	}
	
	public String toString()
	{
		StringBuilder psngr = new StringBuilder();
		psngr.append(super.toString());
		psngr.append("\nPassenger ID: " + id);
		psngr.append("\nPassport Information:\n" + passport);
		return psngr.toString();
	}
}
