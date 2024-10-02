package Puck;

public class Disk extends Circle 
{
	private double thickness;
	
	/*
	 * constructor
	 * @param r radius of disk object to create
	 * @param t thickness of disk object to create
	 */
	public Disk(double r, double t)
	{
		super(r);
		thickness = t;
	}
	
	/*
	 * sets the thickness of the disk object to a new value
	 * @param t new thickness value
	 */
	public void setThickness(double t)
	{
		thickness = t;
	}
	
	/*
	 * returns the thickness value of the disk object
	 * @return the double thickness value
	 */
	public double getThickness()
	{
		return(thickness);
	}
	
	/*
	 * calculates and returns the disk object's volume
	 * @return calculated volume value for disk
	 */
	public double calcVolume()
	{
		return (super.calcArea() * thickness);
	}
	
	/*
	 * compares the disk object to another
	 * @param d disk object to compare to
	 * @return true if disks match, false if not
	 */
	public boolean equals(Disk d)
	{
		if (d.getRadius() == super.getRadius() && d.getThickness() == thickness)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}