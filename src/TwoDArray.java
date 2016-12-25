//Gittie Klein

import java.util.Scanner;

public class TwoDArray 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many rows would you like in your chart? ");
		final int ROW = input.nextInt();
		
		System.out.print("How many columns would you like in your chart? ");
		final int COL = input.nextInt();
		
		int[][] chart = new int[ROW][COL];
		
		for (int r = 0; r < chart.length; r++)
		{
			System.out.printf("Enter %d numbers for row %d. ", COL, (r + 1));
			for (int c = 0; c < chart[r].length; c++)
			{	
				chart[r][c] = input.nextInt();
			}
		}
		
		//display the array
		for (int r = 0; r < chart.length; r++)
		{
			System.out.println();
			for (int c = 0; c < chart[r].length; c++)
			{
				System.out.print(chart[r][c] + "\t");
			}
		}
		
		//calculate the sum of the array
		int sum = 0;
		for (int r = 0; r < chart.length; r++)
		{
			for (int c = 0; c < chart[r].length; c++)
			{
				sum += chart[r][c];
			}
		}
		System.out.println("\n\nThe sum of the chart is " + sum + ".");
		
		//calculate the sum of each row
		for (int r = 0; r < chart.length; r++)
		{
			int rowSum = 0;
			for (int c = 0; c < chart[r].length; c++)
			{
				rowSum += chart[r][c];
			}
			System.out.printf("The sum of row %d is %d.%n", r, rowSum);
		}
		
		//calculate the sum of each column
		for (int c = 0; c < COL; c++)
		{
			int colSum = 0;
			for (int r = 0; r < chart.length; r++)
			{
				colSum += chart[r][c];
			}
			System.out.printf("The sum of column %d is %d.%n", c, colSum);
		}
		
	}
}
