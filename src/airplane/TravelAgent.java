package airplane;

public class TravelAgent extends Person
{
	private long employeeID;
	private double earnings;
	private String socialSecurityNum;
	private static double commissionRate = .15;	//the travel agent gets 15% commission
	
	/**
	 * constructor
	 * it first calls the constructor of the person class
	 * @param employeeID
	 * @param socialSecurityNum
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param phoneNumber
	 */
	public TravelAgent(long employeeID, String socialSecurityNum, String firstName, 
						String lastName, String gender, String street, String city, 
						String state, String zipcode, String phoneNumber)
	{
		super(firstName, lastName, gender, street, city, state, zipcode, phoneNumber);
		
		this.employeeID = employeeID;
		this.socialSecurityNum = socialSecurityNum;
		this.earnings = 0;	//the travel agent starts with earnings of $0
	}
	
	/**
	 * for every ticket that a travel agent books, he earns a percentage
	 * @param ticketPrice
	 */
	public void bookTicket(double ticketPrice)
	{
		earnings += (ticketPrice * commissionRate);
	}
	
	/**
	 * getter method
	 * @return employee ID
	 */
	public long getEmployeeID()
	{
		return employeeID;
	}
	
	/**
	 * getter method
	 * @return earnings
	 */
	public double getEarnings()
	{
		return earnings;
	}
	
	/**
	 * getter
	 * @return the social security number
	 */
	public String getSSN()
	{
		return socialSecurityNum;
	}
	
	/**
	 * setter
	 * @param commission
	 */
	
	public static void setCommissionRate(double commission)
	{
		commissionRate = commission;
	}
	
	/**
	 * equals method
	 * checks if 2 Travel Agent objects are equal based on employee ID
	 * @param obj another object to compare
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		TravelAgent obj2 = (TravelAgent) obj;
		if(this.employeeID == obj2.employeeID)
			return true;
		return false;
	}
	
	/**
	 * compare to method
	 * compares 2 Travel Agent objects based on employee ID
	 * @param obj another object to compare
	 * @return 0 if they're equal, -1 if it's less than, 1 if it's greater than
	 */
	public int compareTo(TravelAgent obj)
	{
		if(this.employeeID == obj.employeeID)
			return 0;
		if(this.employeeID < obj.employeeID)
			return -1;
		else
			return 1;
	}
	
	/**
	 * to String method
	 * @return the Travel Agent object as a String
	 */
	@Override
	public String toString()
	{
		StringBuilder ta = new StringBuilder();
		ta.append(super.toString());
		ta.append("\nEmployee ID: " + employeeID);
		ta.append("\nSS#: " + socialSecurityNum);
		ta.append("\nCommission: " + commissionRate);
		ta.append("\nEarnings: " + earnings);
		return ta.toString();
	}
}
