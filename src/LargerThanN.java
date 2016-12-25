//Gittie Klein

//import statements
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LargerThanN 
{
	public static void main(String[] args)
	{
		System.out.println("This program will input the users numbers into an array and array\n"
				+ "list at the same time. Then the user will choose a number and it will display"
				+ "\nall the numbers equal to or larger than that number.");
		
		Scanner input = new Scanner(System.in);
		
		//create the array and array list
		int[] arrayNumbers = new int[10];
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		System.out.println("Please enter 10 integers to go into the array and array list: ");
		for(int i = 0; i < arrayNumbers.length; i++)
		{
			arrayNumbers[i] = input.nextInt();
			numbers.add(i, arrayNumbers[i]);
		}
		
		display(arrayNumbers, numbers);
		
		System.out.println("\nChoose a number to display all of the numbers greater than that number.");
		int n = input.nextInt();
		search(arrayNumbers, numbers, n);
	}
	
	public static void display(int[] arrayNumbers, ArrayList<Integer> numbers)
	{
		System.out.println("The array of numbers: ");
		for(int val: arrayNumbers)
			System.out.print(val + "\t");
		
		System.out.println("\n");
		
		System.out.println("The array list of numbers: ");
		for(int val: numbers)
			System.out.print(val + "\t");
	}
	
	public static void search(int[] arrayNumbers, ArrayList<Integer> numbers, int n)
	{
		System.out.print("The numbers in the list greater than " + n + " are as follows: ");
		for(int i = 0; i < arrayNumbers.length && i < numbers.size(); i++)
		{
			if(arrayNumbers[i] >= n && numbers.get(i) >= n)
				System.out.print(numbers.get(i) + "\t");
		}
	}
}
