//Gitte Klein

//import statements
import java.util.ArrayList;

public class colorList 
{
	public static void main(String[] args)
	{
		//make the arrayList
		ArrayList<String> color = new ArrayList<String>();
		
		//display the size of the array
		System.out.println("The size of the array is: " + color.size());
		
		//check if the arrayList is empty
		System.out.println();
		System.out.println("The array list is empty: " + color.isEmpty());
		
		//add colors to the array
		color.add("red");
		color.add("oragne");
		color.add(1, "yellow");
		
		//display the arrayList
		System.out.println();
		for (int i = 0; i < color.size(); i++)
			System.out.println(color.get(i));
		
		//display the size of the array
		System.out.println();
		System.out.println("Now the size of the array list is: " + color.size());
		
		//add more colors and remove some colors
		color.remove(2);
		color.add("green");
		color.add(0, "blue");
		color.remove("red");
		color.add("pink");
		
		//display the arrayList
		System.out.println();
		for (int i = 0; i < color.size(); i++)
			System.out.println(color.get(i));
		
		//check if pink is in the list
		System.out.println();
		System.out.println("Pink is part of the list: " + color.contains("pink"));
		
		//at what location is yellow
		System.out.println();
		System.out.println("Yellow is at location: " + color.indexOf("yellow"));
		
		//remove more colors
		color.remove(1);
		color.remove(2);
		color.add("purple");
		
		//display the list using .toString()
		System.out.println();
		System.out.println(color.toString());
		
		//replace colors at certain positions
		color.set(0, "gray");
		color.set(1, "coral");
		color.add("black");
		color.add(0, "red");
		
		//display the arrayList
		System.out.println();
		for(int i = 0; i < color.size(); i++)
			System.out.println(color.get(i));
		
	}
}
