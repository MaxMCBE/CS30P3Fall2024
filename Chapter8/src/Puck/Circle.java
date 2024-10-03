package Puck;

public class Circle implements Comparable<Object>
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
	 * @param o object to compare to
	 * @return true if radii match, false if not
	 */
	public boolean equals(Object o)
	{
		Circle c = (Circle) o;
		
		if (c.getRadius() == radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 * uses the Comparable interface to compare two circles by radius
	 * @param o object to compare to
	 * @return -1 if the object is smaller than o, 0 if they are equal, 1 if the object is larger than o
	 */
	public int compareTo(Object o) 
	{
		Circle c = (Circle) o;
		
		if (radius < c.getRadius())
		{
			return -1;
		}
		else if (radius == c.getRadius())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}