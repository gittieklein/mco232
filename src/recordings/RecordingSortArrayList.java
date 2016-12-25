package recordings;

import java.util.Scanner;
import java.util.ArrayList;

public class RecordingSortArrayList 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		//the number of elements in the array
		final int SONGS	= 5;
		
		//create an array of 5 recording objects
		ArrayList<Recordings> playlist = new ArrayList<Recordings>();
		
		//assign values to the recordings objects
		fillArrayList(playlist, SONGS);
		
		//display the values the way the user entered them
		displayArrayList(playlist);
		
		String answer;
		
		do 
		{
			menu();
		
			int selection = input.nextInt();
			while(selection < 1 || selection > 3)
			{
				System.out.println("Please enter a valid selection.");
				menu();
				selection = input.nextInt();
			}
			
			//get rid of the enter in the buffer
			input.nextLine();
			
			switch(selection)
			{
			case 1:
				sortTitles(playlist);
				break;
			case 2:
				sortArtists(playlist);
				break;
			case 3:
				sortTime(playlist);
				break;	
			}
		
			displayArrayList(playlist);
			
			System.out.println("Do you want to sort the list again? ");
			answer = input.nextLine();
		}while(answer.equalsIgnoreCase("yes"));
		
		System.out.println("\nGood Bye!");
		input.close();
	}
	
	/**
	 * The fillArrayList method fills the data fields with values
	 * @param playlist the arrayList of recording objects
	 * @param SONGS the number of elements needed for the array
	 */
	public static void fillArrayList(ArrayList<Recordings> playlist, int SONGS)
	{
		Scanner input = new Scanner(System.in);
		
		//create the variables for the fields for the recording objects
		String title;
		String artist;
		int seconds;
		
		
		//get the data for the objects from the user
		for(int i = 0; i < SONGS; i++)
		{
			try
			{
				System.out.printf("Please enter the title, artist and playing time in seconds "
						+ "for recording %d.%n", (i + 1));
				System.out.print("Title: ");
				title = input.nextLine();
				System.out.print("Artist: ");
				artist = input.nextLine();
				System.out.print("Playing time in seconds: ");
				seconds = input.nextInt();
				input.nextLine();
				playlist.add(new Recordings(title, artist, seconds));
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
				System.out.println("You can now re-enter the data for recording " + (i + 1) + ".");
				i--;		//Do i-- so that the loop iterates for the same recording again
			}
		}	
	}
	
	/**
	 * The menu method displays the menu for the user
	 */
	public static void menu()
	{
		System.out.println("\nHow would you like to sort the recordings?");
		System.out.println("1) Titles\n"
						 + "2) Artists\n"
						 + "3) Playing time\n"
						 + "(Please type in the number corresponding to your selection.)");
	}
	
	/**
	 * The displayArrayList method displays the recording objects
	 * as a chart
	 * @param playlist the array of recording objects
	 */
	public static void displayArrayList(ArrayList<Recordings> playlist)
	{
		System.out.println("\nRecording Title\t\t\tArtist\t\t\t\tPlaying Time");
		System.out.println("---------------------------------------------------------------------------");
		for(int i = 0; i < playlist.size(); i++)
		{
			System.out.printf("%-25s\t%-25s\t%11d", playlist.get(i).getTitle(), 
					playlist.get(i).getArtist(), playlist.get(i).getSeconds());
			System.out.println();
		}
	}
	
	/**
	 * The sortTitles method sorts the recordings based on titles
	 * @param playlist the array of recording objects
	 */
	public static void sortTitles(ArrayList<Recordings> playlist)
	{
		int startScan;
		int index;
		Recordings minValue = new Recordings();
		int minIndex;
		
		for(startScan = 0; startScan < (playlist.size() - 1); startScan++)
		{
			minValue = playlist.get(startScan);
			minIndex = startScan;
			
			for(index = (startScan + 1); index < playlist.size(); index++)
			{
				if(playlist.get(index).getTitle().compareToIgnoreCase(playlist.get(minIndex).getTitle()) < 0)
				{
					minValue = playlist.get(index);
					minIndex = index;
				}
			}
			
			playlist.set(minIndex, playlist.get(startScan));
			playlist.set(startScan, minValue);
		}
	}
	
	/**
	 * The sortArtists method sorts the recordings based on artists
	 * @param playlist the array of recording objects
	 */
	public static void sortArtists(ArrayList<Recordings> playlist)
	{
		int startScan;
		int index;
		Recordings minValue = new Recordings();
		int minIndex;
		
		for(startScan = 0; startScan < (playlist.size() - 1); startScan++)
		{
			minValue = playlist.get(startScan);
			minIndex = startScan;
			
			for(index = (startScan + 1); index < playlist.size(); index++)
			{
				if(playlist.get(index).getArtist().compareToIgnoreCase(playlist.get(minIndex).getArtist()) < 0)
				{
					minValue = playlist.get(index);
					minIndex = index;
				}
			}
			
			playlist.set(minIndex, playlist.get(startScan));
			playlist.set(startScan, minValue);
		}
	}
	
	/**
	 * The sortTime method sorts the recordings based on playing time
	 * @param playlist the array of recording objects
	 */
	public static void sortTime(ArrayList<Recordings> playlist)
	{
		int startScan;
		int index;
		Recordings minValue = new Recordings();
		int minIndex;
		
		for(startScan = 0; startScan < (playlist.size() - 1); startScan++)
		{
			minValue = playlist.get(startScan);
			minIndex = startScan;
			
			for(index = (startScan + 1); index < playlist.size(); index++)
			{
				if(playlist.get(index).getSeconds() < playlist.get(minIndex).getSeconds())
				{
					minValue = playlist.get(index);
					minIndex = index;
				}
			}
			
			playlist.set(minIndex, playlist.get(startScan));
			playlist.set(startScan, minValue);
		}
	}
}
