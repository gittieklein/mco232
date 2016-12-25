package airplane;

import java.time.LocalDate;
import exceptions.*;

public class Passport implements Comparable<Passport>
{
	private String passportID;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String birthPlace;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private String nationality;
	
	/**
	 * constructor
	 * @param passportID
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param birthPlace
	 * @param issueDate
	 * @param expirationDate
	 * @param nationality
	 */
	public Passport(String passportID, String firstName, String lastName, String birthDate,
				String birthPlace, String issueDate, String expirationDate, String nationality)
	{
		this.passportID = passportID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = LocalDate.parse(birthDate);
		this.birthPlace = birthPlace;
		
		if(LocalDate.parse(issueDate).compareTo(this.birthDate) >= 0)
			this.issueDate = LocalDate.parse(issueDate);
		else
			throw new InvalidDateException();
		
		if(LocalDate.parse(expirationDate).compareTo(this.issueDate) > 0)
			this.expirationDate = LocalDate.parse(expirationDate);
		else
			throw new InvalidDateException();
		
		this.nationality = nationality;
	}
	
	/**
	 * copy constructor
	 * @param copy
	 */
	public Passport(Passport copy)
	{
		this.passportID = copy.passportID;
		this.firstName = copy.firstName;
		this.lastName = copy.lastName;
		this.birthDate = copy.birthDate;
		this.birthPlace = copy.birthPlace;
		this.issueDate = copy.issueDate;
		this.expirationDate = copy.expirationDate;
		this.nationality = copy.nationality;
	}
	
	/**
	 * compare based on passport ID and nationality
	 * @param obj
	 * @return -1 if less than, +1 if greater than and 0 if equal
	 */
	@Override
	public int compareTo(Passport obj)
	{
		int one = this.passportID.compareTo(obj.passportID);
		int two = this.nationality.compareTo(obj.nationality);
		
		if(one == 0)
			return two;
		else
			return one;
	}
	
	/**
	 * checks to see if the objects are equal
	 * @return true or false-if the objects are equal
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		if(this.getID().equals(other.getID()) && this.getNationality().equals(other.getNationality()))
			return true;
		else
			return false;
	}
	
	/**
	 * getter method
	 * @return the passportID
	 */
	public String getID()
	{
		return passportID;
	}
	
	/**
	 * getter method
	 * @return the full name on the passport
	 */
	public String getName()
	{
		return (firstName + lastName);
	}
	
	/**
	 * getter method
	 * @return the last name on the passport
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * getter method
	 * @return birth date
	 */
	public LocalDate getBirthDate()
	{
		return birthDate;
	}
	
	/**
	 * getter method
	 * @return birth place
	 */
	public String getBirthPlace()
	{
		return birthPlace;
	}
	
	/**
	 * getter method
	 * @return issue date
	 */
	public LocalDate getIssueDate()
	{
		return issueDate;
	}
	
	/**
	 * getter method
	 * @return the expiration date of the passport
	 */
	public LocalDate getExpirationDate()
	{
		return expirationDate;
	}
	
	/**
	 * getter method
	 * @return the nationality on the passport
	 */
	public String getNationality()
	{
		return nationality;
	}
	
	/**
	 * checks to see if the card is expired
	 * @return true or false
	 */
	public boolean isExpired()
	{
		if(expirationDate.compareTo(LocalDate.now()) < 0)
			return true;
		return false;
	}
	
	/**
	 * the toString method returns the passport info as a String
	 * @return passport info 
	 */
	@Override
	public String toString()
	{
		StringBuilder passportInfo = new StringBuilder();
		passportInfo.append("Name: " + firstName + " " + lastName);
		passportInfo.append("\nPassport ID: " + passportID);
		passportInfo.append("\nDate of Birth: " + birthDate);
		passportInfo.append("\nBirth Place: " + birthPlace);
		passportInfo.append("\nIssue Date: " + issueDate);
		passportInfo.append("\nExpiration Date: " + expirationDate);
		passportInfo.append("\nNationality: " + nationality);
		return passportInfo.toString();
	}
}
