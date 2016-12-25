package airplane;

//Gittie Klein

import java.util.Scanner;

public class BookSeats2 
{
	public static void main(String[] args)
	{
		//create the array with 10 elements because the plane has 10 seats
		boolean[] plane = new boolean[10];
		String[] passengerNames = new String[10];
		
		//create a Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome!");
		
		int selection; 				//The users choice from the menu
		boolean full;				//If the plane is full
		int seat;					//The seat that is booked
		
		do
		{
			selection = menu(input);
			
			boolean valid = false;		//if the inputed value is valid
			while (valid == false)
			{
				valid = inputValid(selection, 1, 6);
				if (valid == false)
				{
					System.out.println("You must make a valid selection.");
					selection = menu(input);
				} 
			}	
			
			String answer = null;			//ask user if okay with flying other seat status
			String yourName = null;			//when user books a seat, ask his name
			int preferredSeat = 0;			//if the user wants to change seats, ask seat he wants	
		
			switch (selection)
			{
				case 1:	//book first class
					System.out.println("What is your full name? (first and last) ");
					input.nextLine();	//If last input was int, there is an enter in the buffer
					yourName = input.nextLine();
					seat = bookFirstClass(plane, passengerNames, yourName);
					if (seat >= 0)
					{
						System.out.println("First Class Seat Assigned: Seat " + (seat + 1));
					}
					else
					{
						System.out.println("There are no available First Class Seats. "
								+ "\nAre you okay with flying Economy? (yes/no) ");
						answer = input.nextLine();
						if (answer.equalsIgnoreCase("yes"))
						{
							seat = bookEconomy(plane, passengerNames, yourName);
							if (seat >= 5)
							{
								System.out.println("Economy Seat Assigned: Seat " + (seat + 1));
							}
							else
							{
								System.out.println("This flight is full. "
										+ "You must wait for the next flight.");
							}
						}
						else
						{
							System.out.println("You must wait for the next flight.");
						}
					}
					break;
				case 2:	//book economy 
					System.out.println("What is your full name? (first and last) ");
					input.nextLine();	//If last input was int, there is an enter in the buffer
					yourName = input.nextLine();
					seat = bookEconomy(plane, passengerNames, yourName);
					if (seat >= 5)
					{
						System.out.println("Economy Seat Assigned: Seat " + (seat + 1));
					}
					else
					{
						System.out.println("There are no available Economy Seats. "
								+ "Are you okay with flying First Class? (yes/no) ");
						answer = input.nextLine();
						if (answer.equals("yes"))
						{
							seat = bookFirstClass(plane, passengerNames, yourName);
							if (seat >= 0)
							{
								System.out.println("First Class Seat Assigned: Seat " + (seat + 1));
							}
							else
							{
								System.out.println("This flight is full. "
										+ "You must wait for the next flight.");
							}
						}
						else
						{
							System.out.println("You must wait for the next flight.");
						}
					}
					break;
				case 3: //display plane manifest
					displayManifest(plane, passengerNames);
					break;
				case 4: //change seat
					System.out.println("What is your full name? (first and last) ");
					input.nextLine();	//If last input was int, there is an enter in the buffer
					yourName = input.nextLine();
					System.out.println("What seat do you prefer? ");
					preferredSeat = input.nextInt();
					//input validation
					valid = false;		//set back to false so goes through the loop at least once
					while (valid == false)
					{
						valid = inputValid(preferredSeat, 1, plane.length);
						if (valid == false)
						{
							System.out.println("There are 10 seats on this pland. \nYou must make "
									+ "a valid selection.");
							System.out.println("What seat do you prefer? ");
							preferredSeat = input.nextInt();
						} 
					}	
					boolean done = changeSeat(plane, passengerNames, yourName, preferredSeat);
					if (done == false)
					{
						System.out.println("Sorry. Your request could not be processed.");
					}
					else
					{
						System.out.println("Your seat was changed to seat " + preferredSeat + ".");
					}
					break;
				case 5: //check if seats are available
					full = isFull(plane);
					if (full == true)
						System.out.println("There are no available seats on this plane. "
								+ "All seats have been assigned.");
					else
						System.out.println("There are still available seats on this plane.");
					break;
				case 6: //exit application
				default:
					System.out.println("Good bye");
					System.exit(0);
			}
			
		} while (selection != 6);
	}
	
	/**
	 * The bookEconomy method is used to book a first class seat
	 * @param plane pass the array of the plane seats
	 * @param passengerNames pass the array of names of passengers
	 * @param yourName pass the users name so it can be entered into the array
	 * @return the seat number
	 */
	
	public static int bookEconomy(boolean[] plane, String[] passengerNames, String yourName)
	{
		int seat = 5;
		/* If the seat is empty, set it to full
		 * if the seat is full continue looping until the end
		 * of the economy seats.
		 */
		while (seat < plane.length)
		{
			if (plane[seat] == false)
			{
				plane[seat] = true;
				passengerNames[seat] = yourName;
				return seat;
			}
			else
			{
				seat++;
			}
		}		
		
		/*it will only finish the loop if all the seats in economy are taken
		 * set seat to -1 to show that all economy seats are taken.
		 */
		seat = -1;
		return seat;
	}
	
	/**
	 * The bookFirstClass method is used to book a first class seat
	 * @param plane pass the array of the plane seats
	 * @param passengerNames pass the array of names of passengers
	 * @param yourName pass the users name so it can be entered into the array
	 * @return the seat number
	 */
	
	public static int bookFirstClass(boolean[] plane, String[] passengerNames, String yourName)
	{
		int seat = 0;
		/* If the seat is empty, set it to full
		 * if the seat is full continue looping until the end
		 * of the first class seats.
		 */
		while (seat < 5)
		{
			if (plane[seat] == false)
			{
				plane[seat] = true;
				passengerNames[seat] = yourName;
				return seat;
			}
			else
			{
				seat++;
			}
		}
		
		/*it will only finish the loop if all the seats in first class are taken
		 * set seat to -1 to show that all first class seats are taken.
		 */
		seat = -1;
		return seat;
	}
	
	/**
	 * 
	 * @param plane pass the array of the plane seats
	 * @param passengerNames pass the array of names of passengers
	 * @param yourName the users name to check to see if he booked a flight
	 * @param preferredSeat the seat that the user would like to switch to
	 * @return whether or not the users seat was changed
	 */
	
	public static boolean changeSeat(boolean[] plane, String[] passengerNames, 
														String yourName, int preferredSeat)
	{
		preferredSeat--;					//subtract 1 because an array starts with 0
		boolean onFlight = false;			//is the names on the list of passengers
		int seatStatus = 2;					//status of customers seat 1=first class, 2=economy
		boolean done = false;				//true=mission accomplished  false=can't process
	
		//check the status of the preferred seat 1=first class, 2=economy
		int preferredStatus;				
		if (preferredSeat < 5)
			preferredStatus = 1;
		else
			preferredStatus = 2;
		
		int i;
		for (i = 0; i < plane.length && onFlight == false; i++)
		{
			if (plane[i] == true && yourName.equalsIgnoreCase(passengerNames[i]))
			{
				onFlight = true;
				if (i < 5)
					seatStatus = 1;
				else
					seatStatus = 2;
					
				//verify the preferred seat is available and passenger is entitled to it
				if (plane[preferredSeat] == false && preferredStatus >= seatStatus)
				{
					//book him the preferred seat
					plane[preferredSeat] = true;
					passengerNames[preferredSeat] = passengerNames[i];
					//make his previously booked seat available
					plane[i] = false;
					passengerNames[i] = null;
					done = true;
					return done;
					
				}
			}
		}
		done = false;
		return done;
	}
	
	/**
	 * The displayManifest method is used to display all the full seats and the passenger name
	 * @param plane pass the array of the plane seats
	 * @param passengerNames pass the array of the passengers on the plane 
	 */
	
	public static void displayManifest(boolean[] plane, String[] passengerNames)
	{
		//you only want the header displayed once
		System.out.println("\nPassenger Name\t   Seat Number");
		System.out.println("----------------------------------");
		for (int i = 0; i < plane.length; i++)
		{
			if (plane[i] == true)
			{
				System.out.printf("%-20s\t%d%n", passengerNames[i], (i+1));
			}
		}
	}
	
	/**
	 * The inputValid method checks to see if the user entered valid input
	 * @param selection the users selection from the menu
	 * @param min the min value that the user could enter
	 * @param max the max value that the user could enter
	 * @return the users selection from the menu
	 */
	
	public static boolean inputValid(int selection, int min, int max)
	{
		boolean valid;
		if (selection < min || selection > max)
		{
			valid = false;
		}
		else
			valid = true;		
		
		return valid;
	}
	
	/**
	 * The isFull method checks if the plane is full
	 * @param plane pass the array of the plane seats
	 * @return if the plane still has available seats
	 */
	
	public static boolean isFull(boolean[] plane)
	{
		boolean full = false;
		
		for (int i = 0; i < plane.length; i++)
		{
			if (plane[i] == false)
			{
				full = false;
				return full;
			}
			else
				full = true;
		}
		
		return full;
	}
	
	
	/**
	 * The menu method allows the user to choose what he would like to do
	 * @param input allow the user to input from the keyboard
	 * @return the users selection from the menu
	 */
	
	public static int menu(Scanner input)
	{
		System.out.println("\nPlease select from the following menu: ");
		System.out.println("1. Book First Class \n2. Book Economy"
				+ "\n3. Display Plane Manifest \n4. Change Seat"
				+ "\n5. Check if Seats Available \n6. Exit Application");
		int selection = input.nextInt();
		
		return selection;
	}
}
