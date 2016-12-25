package airplane;

import exceptions.*;

public class Customer extends Person
{
	private long customerID;
	private CreditCard creditCard;
	
	/**
	 * constructor
	 * first calls the super to create the Person object
	 * the address is passed in as separate fields
	 * @param customerID
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param phoneNumber
	 * @param creditCard
	 */
	public Customer(long customerID, String firstName, String lastName, String gender,
						String street, String city, String state, String zipcode, 
						String phoneNumber, CreditCard creditCard)
	{
		super(firstName, lastName, gender, street, city, state, zipcode, phoneNumber);
		this.customerID = customerID;
		this.creditCard = creditCard;
	}
	
	/**
	 * constructor
	 * first calls the super to create the Person object
	 * the address is passed in as an address object
	 * @param customerID
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param address
	 * @param phoneNumber
	 * @param creditCard
	 */
	public Customer(long customerID, String firstName, String lastName, String gender,
						Address address, String phoneNumber, CreditCard creditCard)
	{
		super(firstName, lastName, gender, address, phoneNumber);
		this.customerID = customerID;
		this.creditCard = creditCard;		
	}
	
	/**
	 * copy constructor
	 * @param c customer object
	 */
	public Customer(Customer c)
	{
		super(c.getFirstName(), c.getLastName(), String.valueOf(c.getGender()), 
												c.getAddress(), c.getPhoneNumber());
		this.customerID = c.customerID;
		this.creditCard = c.creditCard;	
	}
	
	/**
	 * getter method
	 * @return customer ID
	 */
	public long getCustomerID()
	{
		return customerID;
	}
	
	/**
	 * add a charge to the card
	 * @param amount
	 */
	public void chargeCard(double amount) throws InsufficientFundsException, InvalidPinException, CardExpiredException
	{
		creditCard.addCharge(amount, creditCard.getPin());
	}
	
	/**
	 * compares the customers based on customer ID
	 * @param cmpr another customer
	 * @return -1, 1 or 0
	 */
	public int compareTo(Customer cmpr)
	{
		if(this.customerID < cmpr.customerID)
			return -1;
		if(this.customerID > cmpr.customerID)
			return 1;
		return 0;
	}
	
	/**
	 * checks if objects equal based on customer id
	 * @param obj another object to compare
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
		Customer other = (Customer) obj;
		if(this.customerID == other.customerID)
			return true;
		return false;
	}
	
	/**
	 * toString method
	 * the pin is not included with the other credit card information
	 * @return the object as a String
	 */
	@Override
	public String toString()
	{
		StringBuilder cstmr = new StringBuilder();
		cstmr.append(super.toString());
		cstmr.append("\nCustomer ID: " + customerID);
		cstmr.append("\nCredit Card Information:");
		cstmr.append("\n" + creditCard);
		return cstmr.toString();
	}
}
