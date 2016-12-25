package circle;

/**
 * The Circle class allows the user to create a circle object and 
 * calculate the diameter, area, and circumference
 */

public class Circle 
{
	private double radius;
	private final double PI = 3.14159;
	
	/**
	 * Constructor
	 * @param radius the radius of the circle
	 */
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	/**
	 * Constructor
	 * The no args constructor sets the radius to zero
	 */
	
	public Circle()
	{
		radius = 0;
	}
	
	/**
	 * Setter
	 * The setRadius method allows the user to change the value of the radius
	 * @param radius the radius of the circle
	 */
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	/**
	 * Getter
	 * The getRadius method returns the radius of the circle
	 * @return the radius of the circle
	 */
	
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * The getArea method calculates the area of the circle
	 * @return the area of the circle
	 */
	
	public double getArea()
	{
		double area = PI * radius * radius;
		return area;
	}
	
	/**
	 * The getDiameter method calculates the diameter of the method
	 * @return the diameter of the circle
	 */
	
	public double getDiameter()
	{
		double diameter = radius * 2;
		return diameter;
	}
	
	/**
	 * the getCircumference method calculates the circumference of the circle
	 * @return the circumference of the circle
	 */
	
	public double getCircumference()
	{
		double circumference = PI * radius * 2;
		return circumference;
	}
}
