//Gittie Klein

import java.util.Scanner;

public class DriversLicenseExam 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		char[] answers = {'B', 'D', 'A', 'A', 'C', 
						  'A', 'B', 'A', 'C', 'D', 
						  'B', 'C', 'D', 'A', 'D', 
						  'C', 'C', 'B', 'D', 'A'};
		
		char[] student = new char[answers.length];
		
		String again;
		
		do
		{
			System.out.println("Please enter the students answers.");
			for(int i = 0; i < student.length; i++)
			{
				System.out.print("# " + (i + 1) + ": ");
				student[i] = input.nextLine().toUpperCase().charAt(0);
				while(!(student[i] == 'A' || student[i] == 'B' || student[i] == 'C' || student[i] == 'D'))
				{
					System.out.println("You mush enter a valid letter: A, B, C or D.");
					student[i] = input.nextLine().toUpperCase().charAt(0);
				}
			}
		
			//check if the student passed the exam
			int correct;
			correct = passExam(answers, student);
			System.out.println("The student answered " + correct + " questions correct.");
			if(correct >= 15)
				System.out.println("The student passed the exam.");
			else
				System.out.println("The student did not pass the exam.");
			
			System.out.println("Do you want to do it again with another student? ");
			again = input.nextLine();
		} while(again.equalsIgnoreCase("yes"));	
	}
	
	public static int passExam(char[] answers, char[] student)
	{
		int accumalate = 0;			//keep track of the amount of questions the student got right
		for(int i = 0; i < answers.length; i++)
		{
			if(answers[i] == student[i])
				accumalate++;
		}
		return accumalate;
	}
}
