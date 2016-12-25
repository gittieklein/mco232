//Gittie Klein

public class sortingArray 
{
	public static void main(String[] args)
	{
		int[] val = {21, 98, 36, 54, 84, 15, 
						97, 32, 59, 60, 71, 82};
		
		display(val);
		sort(val);
		display(val);
		int value = search(val, 54);
		if(value != (-1))
			System.out.println("54 is in place number " + (value + 1));
	}
	public static void display(int[] val)
	{
		System.out.println();
		for(int i = 0; i < val.length; i++)
			System.out.println(val[i]);
	}
	
	public static void sort(int[] val)
	{
		int minValue;
		int minIndex;
		int startScan;
		int index;
		
		for(startScan = 0; startScan < (val.length - 1); startScan++)
		{
			minIndex = startScan;
			minValue = val[minIndex];
			for(index = (startScan + 1); index < val.length; index++)
			{
				if(val[index] < minValue)
				{
					minValue = val[index];
					minIndex = index;
				}
			}
			val[minIndex] = val[startScan];
			val[startScan] = minValue;
		}
	}
	
	public static int search(int[] val, int search)
	{
		int low = 0;
		int high = (val.length - 1);
		int mid = (low + high) / 2;
		
		while(low <= high)
		{
			mid = (low + high) / 2;
			if(val[mid] == search)
			{
				return mid;
			}
			else if(search < val[mid])
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return -1;
	}
}
