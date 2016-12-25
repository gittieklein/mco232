package circle;

import java.util.Scanner;

public class CircleInfo 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is the radius of circle1? ");
		double radius = input.nextDouble();
		
		//create the circle object
		Circle circle1 = new Circle(radius);
		
		//create a second circle object
		Circle circle2 = new Circle();
		
		//use set method to set a radius for circle 2
		System.out.print("What is the radius of circle2? ");
		radius = input.nextDouble();
		circle2.setRadius(radius);
		
		//print the radius of the 2 circles
		System.out.println();
		System.out.println("\t\tCircle1\t\tCircle2");
		System.out.println("-----------------------------------------");
		System.out.printf("Radius\t\t%-15.4f%-15.4f%n", circle1.getRadius(), circle2.getRadius());
		
		//calculate the area
		System.out.printf("Area\t\t%-15.4f%-15.4f%n", circle1.getArea(), circle2.getArea());
		
		//calculate the diameter
		System.out.printf("Diameter\t%-15.4f%-15.4f%n", circle1.getDiameter(), circle2.getDiameter());
		
		//calculate the circumference
		System.out.printf("Circumference\t%-15.4f%-15.4f%n", circle1.getCircumference(), circle2.getCircumference());
		
		System.out.print(circle1.toString());
		
	}
}

