//Gittie Klein

//import statements
import java.lang.reflect.Array;
import java.util.Scanner;

public class SortingIntegers 
{
	public static void main(String[] args)
	{
		//this variable will hold the size of the array
		final int SIZE;
		
		//create a Scanner object
		Scanner input= new Scanner(System.in);
		
		System.out.print("Welcome. \nThis program allows you entere a list of numbers"
				+ " that will then be sorted in ascending order.\nHow many numbers would "
				+ "you like to enter? ");
		SIZE = input.nextInt();
		
		//create the array. 
		int[] numbers = new int[SIZE];
		
		enterNumbers(numbers, input);
		System.out.println("\nThe list of numbers you entered: ");
		displayArray(numbers);				//display the array before it is sorted
		sorting(numbers);
		System.out.println("\nThe list of numbers you entered after they were sorted in ascending order: ");
		displayArray(numbers);				//display the array again after is is sorted
		
		String answer;
		do 
		{
			System.out.print("\nWhich number Would you like to search for to see what position it is in? ");
			int search = input.nextInt();
			int place = search(numbers, search);
			if (place > 0)
				System.out.printf("%d is number %d in the list of numbers.%n", search, place);
			else
				System.out.printf("The number %d is not in the list of integers.%n", search);
			
			System.out.print("\nWould you like to search for another number? ");
			input.nextLine();					//swallow the enter in the buffer because you are inputing a String after an int
			answer = input.nextLine();	
		} while (answer.equalsIgnoreCase("yes"));	
	}
	
	/**
	 * The displayArray method displays the numbers the user entered
	 * @param numbers passes it the numbers array to display it
	 */
	
	public static void displayArray(int[] numbers)
	{
		for (int i = 0; i < numbers.length; i++)
			System.out.println(numbers[i]);
	}
	
	 /**
	  * The enterNumbers arrays asks the users to enter the numbers for the array
	  * and the user inputs them
	  * @param numbers passes the array of integers
	  * @param input the Scanner object so the user could input the numbers
	  */
	
	public static void enterNumbers(int[] numbers, Scanner input)
	{
		System.out.printf("Please enter %d integers.%n", numbers.length);
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = input.nextInt();
		}
	}
	
	/**
	 * The sorting method sorts the numbers in the array in ascending order
	 * @param numbers passes the array of integers to be sorted
	 */
	
	public static void sorting(int[] numbers)
	{
		int startScan;			//the point where you want to start searching for the lowest number
		int minValue;			//the minimum value of the array (it will change each time it finds a smaller number)
		int minIndex;			//the index of the minimum value of the array (it will change each time it finds a smaller number)
		int index;				//the index of the number that is being compared to the minimum value at that point
		
		/*
		 * you want the loop to iterate one less time than the size of the array because when it gets to the last element
		 * everything else would have already been sorted and there is no need to check that number
		 */
		for (startScan = 0; startScan < (numbers.length - 1); startScan++)
		{
			minIndex = startScan;
			minValue = numbers[startScan];
			/*
			 * you want this loop to iterate for every element in the loop so that it can check through every element and see if it
			 * is less than the minimum value, which is either the number in the starting point or the number that was found while
			 * searching for a lower number.
			 * this loop will start from one place higher than the start scan. the start scan is the number that it is comparing
			 * to the other elements of the array.
			 */
			for (index = startScan + 1; index < numbers.length; index++)
			{
				if (numbers[index] < minValue)
				{
					minValue = numbers[index];
					minIndex = index;
				}
			}
			numbers[minIndex] = numbers[startScan];
			numbers[startScan] = minValue;
		}
		
	}
	
	public static int search(int[] numbers, int search)
	{
		int min = 0;							//holds the minimum  value
		int max = (numbers.length - 1);			//holds the maximum value
		int mid = (min + max) / 2;				//holds the middle value
		
		while (min <= max)
		{
			mid = (min + max) / 2;	
			if (search == numbers[mid])
				return (mid + 1);				//when returning, you do +1 because an array starts with zero
			else if (search < numbers[mid])
				max = mid -1;
			else
				min = mid + 1;
		}
		
		return -1;
	}
	
}
