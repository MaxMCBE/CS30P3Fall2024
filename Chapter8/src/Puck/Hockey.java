package Puck;

public class Hockey 
{
	public static void main(String[] args) 
	{
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(5);
		Circle c3 = new Circle(3);
		
		Disk d1 = new Disk(5,2);
		Disk d2 = new Disk(5,2);
		Disk d3 = new Disk(5,1);
		
		Puck p1 = new Puck(5,2,4);
		Puck p2 = new Puck(5,2,4);
		Puck p3 = new Puck(5,2,5);
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.compareTo(c3));
		
		System.out.println();
		
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.compareTo(d3));
		
		System.out.println();
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p3));
		
		System.out.println();
		
		System.out.println(c1.calcArea());
		System.out.println(c2.calcArea());
		System.out.println(c3.calcArea());
		
		System.out.println();
		
		System.out.println(d1.calcArea());
		System.out.println(d1.calcVolume());
		System.out.println(d2.calcArea());
		System.out.println(d2.calcVolume());
		System.out.println(d3.calcArea());
		System.out.println(d3.calcVolume());
		
		System.out.println();
		
		System.out.println(p1.calcArea());
		System.out.println(p1.calcVolume());
		System.out.println(p1.getDivision());
		System.out.println(p2.calcArea());
		System.out.println(p2.calcVolume());
		System.out.println(p2.getDivision());
		System.out.println(p3.calcArea());
		System.out.println(p3.calcVolume());
		System.out.println(p3.getDivision());
	}
}
