package Puck;

public class Puck extends Disk
{
	private double weight;
	private boolean standard;
	private boolean youth;
	
	public Puck(double r, double t, double w)
	{
		super(r, t);
		weight = w;
	}
	
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
	
	public void setWeight(double w)
	{
		weight = w;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public boolean equals(Puck p)
	{
		if (p.getRadius() == super.getRadius() && p.getThickness() == super.getThickness() && p.getWeight() == weight)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
