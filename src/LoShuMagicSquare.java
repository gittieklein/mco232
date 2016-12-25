//Gittie Klein

//import statements
import java.util.Scanner;

public class LoShuMagicSquare 
{
	public static void main(String[] args)
	{
		int[][] magicSquare = new int[3][3];
		Scanner input = new Scanner(System.in);
		String answer;
		
		/*Tell the user about the magic square and then ask him what numbers
		 * he would like to put in each box of the grid.
		 */
		System.out.println("The Lo Shu Magic Square is a grid with 3 rows and 3 columns. \nThe grid contains"
				+ " the numbers 1 through 9. \nIn addition, the sum of each row, column, and each diagonal "
				+ "all add up to the same number.");
		
		do
		{
			System.out.println("\nEnter numbers for the grid to see if it is a magic square.");
			System.out.print("Choose a number for the following boxes: "
					+ "\nRow 1 Column 1: ");
			magicSquare[0][0] = input.nextInt();
			System.out.print("Row 1 Column 2: ");
			magicSquare[0][1] = input.nextInt();
			System.out.print("Row 1 Column 3: ");
			magicSquare[0][2] = input.nextInt();
			System.out.print("Row 2 Column 1: ");
			magicSquare[1][0] = input.nextInt();
			System.out.print("Row 2 Column 2: ");
			magicSquare[1][1] = input.nextInt();
			System.out.print("Row 2 Column 3: ");
			magicSquare[1][2] = input.nextInt();
			System.out.print("Row 3 Column 1: ");
			magicSquare[2][0] = input.nextInt();
			System.out.print("Row 3 Column 2: ");
			magicSquare[2][1] = input.nextInt();
			System.out.print("Row 3 Column 3: ");
			magicSquare[2][2] = input.nextInt();
		
			displayGrid(magicSquare);
		
			//Find the sum for the columns
			int column0, column1, column2;
			column0 = sumColumn(magicSquare, 0);
			column1 = sumColumn(magicSquare, 1);
			column2 = sumColumn(magicSquare, 2);
		
			//Check to see if it is a valid magic square
			//Check if the sum of each column is equal to the same thing
			boolean check;
			check = isEqual(column0, column1, column2);
		
			/*You only want to continue checking the rest of the square
			 * if the columns are all equal and there is the possibility 
			 * that it is a magic square. if they are not equal, then there
			 * is no need to continue checking.
			 */
			if (check)
			{
				//find the sum for the rows
				int row0, row1, row2;
				row0 = sumRow(magicSquare, 0);
				row1 = sumRow(magicSquare, 1);
				row2 = sumRow(magicSquare, 2);
				check = isEqual(row0, row1, row2);
				
				/*
				 * You only want to continue checking to see if it is a magic square if the 
				 * rows are equal.
				 */
				if (check)
				{
					//find the sum for the diagonals
					int diagonal1, diagonal2;
					diagonal1 = sumDiagonal1(magicSquare);
					diagonal2 = sumDiagonal2(magicSquare);
					check = diagonalEqual(diagonal1, diagonal2);
					
					/*
					 * Now you know that all columns are equal to columns and all rows
					 * are equal to rows and all diagonals are equal to diagonals. Now
					 * you have to check that columns are equal to rows and are also
					 * equal to diagonals.
					 */
					if (check)
					{
						//You only have to check for 1 of each because you know all columns are equal to each other...
						check = isEqual(column0, row0, diagonal1);
						
						/*
						 * You know that all the columns, rows and diagonals are equal with each other.
						 * Now you have to check that the used all the numbers from 1-9 and only
						 * used each number once.
						 */
						if (check)
						{
							check = numbers(magicSquare);
							
							if (check)
							{
								System.out.println("The grid that you entered is a magic square:)");
							}
							else
							{
								System.out.println("This is not a valid magic square.");
							}
						}
						else
						{
							System.out.println("This is not a valid magic square.");
						}
					}
					else
					{
						System.out.println("This is not a valid magic square.");
					}
				}
				else
				{
					System.out.println("This is not a valid magic square.");
				}
			}
			else
			{
			System.out.println("This is not a valid magic square.");
			}
			
			System.out.print("Do you want to try with another set up of numbers? ");
			//get rid of the enter in the buffer
			input.nextLine();
			answer = input.nextLine();
		} while (answer.equalsIgnoreCase("yes"));	
		
		System.out.println("Thank you for playing!");
		input.close();
	}
	
	/**
	 * The diagonalEqual method tests if the diagonals are equal
	 * @param diagonal1 the sum of one diagonal
	 * @param diagonal2 the sum of another diagonal
	 * @return whether or not the diagonals are equal
	 */
	
	public static boolean diagonalEqual(int diagonal1, int diagonal2)
	{
		boolean check = false;
		
		if (diagonal1 == diagonal2)
			{
				check = true;
			}
		else
		{
			check = false;
		}
		
		return check;
	}
	
	/**
	 * 	The displayGrid method displays the magic square for the user
	 * @param magicSquare the array that's the grid of the square
	 */
	
	public static void displayGrid(int[][] magicSquare)
	{
		System.out.println("\nYour magic square:");
		for (int rows = 0; rows < magicSquare.length; rows++)
		{
			for (int columns = 0; columns < magicSquare[rows].length; columns++)
			{
				System.out.printf("%-4d", magicSquare[rows][columns]);
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/**
	 * The isEqual method tests of the rows/columns are equal
	 * @param val1 the sum of row/column 0
	 * @param val2 the sum of row/column 1
	 * @param val3 the sum of row/column 2
	 * @return whether or not the rows/columns are equal
	 */
	
	public static boolean isEqual(int val1, int val2, int val3)
	{
		boolean check = false;
		
		if (val1 == val2 && val1 == val3)
			{
				check = true;
			}
		else
		{
			check = false;
		}
		
		return check;
	}
	
	/**
	 * The numbers method checks to make sure the user used the numbers
	 * 1-9 and only used each number once
	 * @param magicSquare the array that's the grid of the square
	 * @return whether or not the user used all numbers
	 */
	
	public static boolean numbers(int[][] magicSquare)
	{
		boolean check = false;
		int find = 0;
		
		//Do a sequential search to look for all the numbers 1-9
		for (int search = 1; search < 10; search++)
		{
			for (int rows = 0; rows < magicSquare.length && find != search; rows++)
			{
				for (int columns = 0; columns < magicSquare[rows].length && find != search; columns++)
				{
					if (search == magicSquare[rows][columns])
					{
						find = magicSquare[rows][columns];
						check = true;
					}
				}
			}
			if (find != search)
			{
				check = false;
				return check;
			}
		}
		return check;
	}
	
	/**
	 * The sumColumn method adds up the values of a column
	 * @param magicSquare the array that's the grid of the square
	 * @param column the column number that the method will add up
	 * @return the sum of the column
	 */
	
	public static int sumColumn(int[][] magicSquare, int column)
	{
		int sum = 0;
		for (int rows = 0; rows < magicSquare.length; rows++)
		{
			sum += magicSquare[rows][column];
		}
		
		return sum;
	}
	
	/**
	 * The sumDiagonal1 method adds up the values of diagonal1
	 * @param magicSquare the array that's the grid of the square
	 * @return the sum of the diagonal
	 */
	
	public static int sumDiagonal1(int[][] magicSquare)
	{
		int sum = 0;
		for(int i = 0; i < magicSquare.length && i < magicSquare[i].length; i++)
		{
			sum += magicSquare[i][i];
		}
		return sum;
	}
	
	/**
	 * The sumDiagonal2 method adds up the values of diagonal2
	 * @param magicSquare the array that's the grid of the square
	 * @return the sum of the diagona2
	 */
	
	public static int sumDiagonal2(int[][] magicSquare)
	{
		int sum = 0;
		for (int row = (magicSquare.length - 1); row >= 0; row--)
		{
			int column = 0; 
			sum += magicSquare[row][column];
			column++;
		}
		return sum;
	}
	
	/**
	 * The sumRow method adds up the values of a row
	 * @param magicSquare the array that's the grid of the square
	 * @param row the row number that the method will add up
	 * @return the sum of the row
	 */
	
	public static int sumRow(int[][] magicSquare, int row)
	{
		int sum = 0;
		for (int column = 0; column < magicSquare[row].length; column++)
		{
			sum += magicSquare[row][column];
		}
		return sum;
	}
		
}	