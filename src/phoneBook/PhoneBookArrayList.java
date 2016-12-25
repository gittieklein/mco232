package phoneBook;

import java.util.ArrayList;

public class PhoneBookArrayList 
{
	public static void main(String[] args)
	{
		ArrayList<PhoneBookEntry> numbers = new ArrayList<PhoneBookEntry>();
		numbers.add(new PhoneBookEntry("Gittie", "Klein", "3475630372"));
		numbers.add(new PhoneBookEntry("Chaya", "Brody", "6462558006"));
		numbers.add(new PhoneBookEntry("Family", "Klein", "7183752287"));
		numbers.add(new PhoneBookEntry("Rivka Bracha", "Grunfeld", "6463348383"));
		numbers.add(new PhoneBookEntry("Miriam", "Klein", "7189865072"));
		
		for(PhoneBookEntry val: numbers)
			System.out.println(val);
		
		for(int startScan = 0; startScan < (numbers.size() - 1); startScan++)
		{
			PhoneBookEntry minValue = numbers.get(startScan);
			int minIndex = startScan;
			
			for(int index = (startScan + 1); index < numbers.size(); index++)
			{
				if(numbers.get(index).compareTo(numbers.get(startScan)) < 0)
				{
					minValue = numbers.get(index);
					minIndex = index;
				}	
			}
			
			numbers.set(minIndex, numbers.get(startScan));
			numbers.set(startScan, minValue);
		}
		
		for(PhoneBookEntry val: numbers)
			System.out.println(val);
	}
}
