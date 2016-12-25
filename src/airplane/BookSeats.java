package airplane;

//Gittie Klein

import java.util.Scanner;

public class BookSeats 
{
	public static void main(String[] args)
	{
		//create the array with 10 elements because the plane has 10 seats
		boolean[] plane = new boolean[10];
		
		//create a Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome!");
		
		int selection; 
		boolean full;
		int seat;
		
		do
		{
			selection = menu(input);
			selection = inputValid(selection, input);
		
			String answer = null;
		
			switch (selection)
			{
				case 1:
					seat = bookFirstClass(plane, input);
					if (seat >= 0)
					{
						System.out.println("First Class Seat Assigned: Seat " + (seat + 1));
					}
					else
					{
						System.out.println("There are no available First Class Seats. "
								+ "Are you okay with flying Economy? (yes/no) ");
						input.nextLine();	//The last input was an int so there is an enter in the buffer
						answer = input.nextLine();
						if (answer.equalsIgnoreCase("yes"))
						{
							seat = bookEconomy(plane, input);
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
				case 2:
					seat = bookEconomy(plane, input);
					if (seat >= 5)
					{
						System.out.println("Economy Seat Assigned: Seat " + (seat + 1));
					}
					else
					{
						System.out.println("There are no available Economy Seats. "
								+ "Are you okay with flying First Class? (yes/no) ");
						input.nextLine();
						answer = input.nextLine();
						if (answer.equals("yes"))
						{
							seat = bookFirstClass(plane, input);
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
				case 3:
					full = isFull(plane);
					if (full == true)
						System.out.println("There are no available seats on this plane. "
								+ "All seats have been assigned.");
					else
						System.out.println("There are still available seats on this plane.");
					break;
				case 4:
				default:
					System.out.println("Good bye");
					System.exit(0);
			}
			
		} while (selection != 4);
	}
	
	/**
	 * The bookEconomy method is used to book a first class seat
	 * @param plane pass the array of the plane seats
	 * @param input allow the user to input from the keyboard
	 * @return the seat number
	 */
	
	public static int bookEconomy(boolean[] plane, Scanner input)
	{
		int seat = 5;
		while (seat < plane.length)
		{
			if (plane[seat] == false)
			{
				plane[seat] = true;
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
	 * @param input allow the user to input from the keyboard
	 * @return the seat number
	 */
	
	public static int bookFirstClass(boolean[] plane, Scanner input)
	{
		int seat = 0;
		while (seat < 5)
		{
			if (plane[seat] == false)
			{
				plane[seat] = true;
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
	 * The inputValid method checks to see if the user entered valid input
	 * @param selection the users selection from the menu
	 * @param input allow the user to input from the keyboard
	 * @return the users selection from the menu
	 */
	
	public static int inputValid(int selection, Scanner input)
	{
		while (!(selection >= 1 && selection <=4))
		{
			System.out.println("You must enter a valid choice (1, 2, 3 or 4).");
			System.out.println("Please enter a selection: ");
			selection = input.nextInt();
		}
		
		return selection;
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
				+ "\n3. Check if Seats Available \n4. Exit Application");
		int selection = input.nextInt();
		
		return selection;
	}
}
