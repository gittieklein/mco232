package airplane;

import java.time.LocalDate;
import exceptions.*;

public class CreditCard 
{
	private double balance;
	private long creditCardID;
	private double creditLimit;
	private LocalDate expirationDate;
	private int pin;

	/**
	 * Constructor to create credit card object
	 * @param creditCardID
	 * @param expirationDate
	 * @param pin
	 */
	public CreditCard(long creditCardID, String expirationDate, int pin)
	{
		balance = 0;
		creditLimit = 5000;
		this.creditCardID = creditCardID;
		this.expirationDate = LocalDate.parse(expirationDate);	//user has to type in as YYYY-MM-DD
		this.pin = pin;
	}

	/**
	 * the getBalance method gets the credit card balance
	 * i added this method because maybe the user wants to know
	 * what his balance is 
	 * @return the credit card balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * getter
	 * @return the pin number of the credit card
	 */
	public int getPin()
	{
		return pin;
	}
	
	/**
	 * the add charge limit adds a charge to the credit balance
	 * @param balance the new balance to add to the previous balance
	 * @param pin
	 */
	public void addCharge(double amount, int pin)
	{
		if(this.expirationDate.compareTo(LocalDate.now()) > 0)
		{
			if(pin == this.pin)
			{
				if((this.balance + amount) <= creditLimit)
				{
					/*
					 *you want to check that you when you add the new balance to the previous
					 *balance, it is still under the credit limit. Once you check that, you could
					 *add the new balance to the previous
					 *I see that I did it different then it says on the sheet, but mathematically it is
					 *the same thins...
					 */
					this.balance += amount;
				}
				else
				{
					throw new InsufficientFundsException();
				}
			}
			else
			{
				throw new InvalidPinException();
			}
		}
		else
		{
			throw new CardExpiredException();
		}
	}

	/**
	 * the toString method converts the information of the class as a String
	 * the pin is not included
	 * the only way to get the pin is with the getter method
	 * @return the information of the credit card class
	 */
	@Override
	public String toString()
	{
		StringBuilder creditInfo = new StringBuilder();
		creditInfo.append("Credit Card ID: " + creditCardID);
		creditInfo.append("\nExpiration Date: " + expirationDate);
		creditInfo.append("\nCredit Limit: " + creditLimit);
		creditInfo.append("\nBalance: " + balance);
		return creditInfo.toString();
	}
	

}
