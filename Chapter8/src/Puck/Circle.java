package Puck;

public class Circle 
{
	private static final double PI = 3.14159265359;
	private double radius;
	
	/*
	 * constructor
	 * @param r radius of circle object
	 */
	public Circle(double r)
	{
		radius = r;
	}
	
	/*
	 * sets the circle object's radius to a new value
	 * @param r new radius of circle object
	 */
	public void setRadius(double r)
	{
		radius = r;
	}
	
	/*
	 * returns the circle object's radius value
	 * @return radius value of object
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/*
	 * calculates and returns the area of the circle object
	 * @return calculated area value
	 */
	public double calcArea()
	{
		return (PI*(radius*radius));
	}
	
	/*
	 * determines if the object is equal to another object using radius
	 * @param c circle to compare to
	 * @return true if radii match, false if not
	 */
	public boolean equals(Circle c)
	{
		if (c.getRadius() == radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
