package Puck;

public class Puck extends Disk
{
	private double weight;
	private boolean standard;
	private boolean youth;
	
	/*
	 * constructor
	 * @param r radius of new puck object
	 * @param t thickness of new puck object
	 * @param w weight of new puck object
	 */
	public Puck(double r, double t, double w)
	{
		super(r, t);
		weight = w;
	}
	
	/*
	 * checks which division the puck is legal in, if any, changing the standard and youth boolean variables
	 */
	public void checkDivision()
	{
		if (weight >= 5 && weight <= 5.5)
		{
			standard = true;
			youth = false;
		}
		else if (weight >= 4 && weight <= 4.5)
		{
			standard = false;
			youth = true;
		}
		else
		{
			standard = false;
			youth = false;
		}
	}
	
	/*
	 * returns a String stating the division the puck is legal in
	 * @return standard if the puck is legal in standard division, youth if the puck is legal in youth division, or neither
	 */
	public String getDivision()
	{
		checkDivision();
		
		if (standard)
		{
			return "standard";
		}
		else if (youth)
		{
			return "youth";
		}
		else
		{
			return "not legal in either division";
		}
	}
	
	/*
	 * sets the weight of the puck object to a new value
	 * @param w new weight value
	 */
	public void setWeight(double w)
	{
		weight = w;
	}
	
	/*
	 * returns the weight value of the puck object
	 * @return the double weight value
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/*
	 * compares the puck object to another
	 * @param o object to compare to
	 * @return true if disks match, false if not
	 */
	public boolean equals(Object o)
	{
		Puck p = (Puck) o;
		
		if (p.getRadius() == super.getRadius() && p.getThickness() == super.getThickness() && p.getWeight() == weight)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * uses the Comparable interface to compare two pucks by weight
	 * @param o object to compare to
	 * @return -1 if the object is smaller than o, 0 if they are equal, 1 if the object is larger than o
	 */
	public int compareTo(Object o) 
	{
		Puck p = (Puck) o;
		
		if (weight < p.getWeight())
		{
			return -1;
		}
		else if (weight == p.getWeight())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}
