//Gittie Klein

//import statements
import java.util.Scanner;
import java.io.*;

import javax.swing.JOptionPane;

public class WorldSeriesChampions 
{
	public static void main(String[] args)
	{
		//create an array to hold the winners of the world series
		String[] winners = new String[200];
		int timesWon;
		
		String team;		//The team the user wants to search
		String answer;
		int i = 0;
		
		try
		{
			File input = new File("E:\\MCO232\\AdvancedProgramming\\src\\WorldSeriesWinners.txt");
			
			Scanner read = new Scanner(input);
			
			for (i = 0; read.hasNext(); i++)
			{
				winners[i] = read.nextLine();
			}
			read.close();
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "The file does not exist.");
			JOptionPane.showMessageDialog(null, e);
			System.exit(1);
		}
		catch (ArrayIndexOutOfBoundsException x)
		{
			JOptionPane.showMessageDialog(null, "The array is full.");
			JOptionPane.showMessageDialog(null, x);
		}
		
		do
		{				
			team = JOptionPane.showInputDialog("Enter the name of a team to see how "
											+ "\nmany times this team won the World "
											+ "\nSeries in the time period from 1903 "
											+ "\nthrough 2009.\n"
											+ "\nEx: Boston Americans, New York Giants, "
											+ "\nChicago White Sox, Chicago Cubs... ");
			
			timesWon = search(winners, i, team);
		
			
			JOptionPane.showMessageDialog(null, String.format("The %s won the World "
					+ "Series %d time(s).\n", team, timesWon));
			
			answer = JOptionPane.showInputDialog("Would you like to see another team?");
			
			
		} while (answer.equalsIgnoreCase("yes"));
		
		JOptionPane.showMessageDialog(null, "Good bye!");
		
		System.exit(0);
	}
	
	 /**
	  * The search method looks for the team the user chose, to see how many times 
	  * they won the world series
	  * @param winners the array with the world series winners
	  * @param index the amount of teams entered into the array
	  * @param team the name of the team the user wants to search
	  * @return
	  */
	
	public static int search(String[] winners, int index, String team)
	{
		int accumalator = 0; 		//calculate the number of times a particular team won the world series
		for (int i = 0; i < index; i++)
		{
			if (winners[i].equalsIgnoreCase(team))
				accumalator++;
		}
		
		return accumalator;
	}
}



