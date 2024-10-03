package Rectangle;

public class Rectangle implements Comparable<Object>, ComparableArea
{
	private int length;
	private int width;
	
	public static void displayAreaFormula()
	{
		System.out.println("l * w");
	}
	
	public Rectangle()
	{
		length = 1;
		width = 1;
	}
	
	public Rectangle(int l, int w)
	{
		length = l;
		width = w;
	}
	
	public void setLength(int l)
	{
		length = l;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int calcArea()
	{
		return length * width;
	}
	
	public int calcPerimeter()
	{
		return (2 * length) + (2 * width);
	}
	
	public String toString()
	{
		return "Length " + length + ", Width " + width;
	}
	
	public boolean equals(Object o)
	{
		Rectangle r = (Rectangle) o;
		
		if (r.getLength() == length && r.getWidth() == width)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int compareTo(Object o)
	{
		Rectangle r = (Rectangle) o;
		
		if (length + width < r.getLength() + r.getWidth())
		{
			return -1;
		}
		else if (r.getLength() + r.getWidth() == length + width)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	public int compareToArea(Object o)
	{
		Rectangle r = (Rectangle) o;
		
		if (calcArea() < r.calcArea())
		{
			return -1;
		}
		else if (calcArea() == r.calcArea())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}

abstract interface ComparableArea
{
	public int compareToArea(Object o);
}