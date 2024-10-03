package Rectangle;

public class RunRectangle 
{

	public static void main(String[] args) 
	{
		Rectangle.displayAreaFormula();
		System.out.println();
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(1, 1);
		Rectangle r3 = new Rectangle(2, 3);
		
		System.out.println(r1.getLength());
		System.out.println(r1.getWidth());
		System.out.println(r1.toString());
		System.out.println(r1.calcArea());
		System.out.println(r1.calcPerimeter());
		System.out.println();
		
		System.out.println(r2.getLength());
		System.out.println(r2.getWidth());
		System.out.println(r2.toString());
		System.out.println(r2.calcArea());
		System.out.println(r2.calcPerimeter());
		System.out.println();
		
		System.out.println(r3.getLength());
		System.out.println(r3.getWidth());
		System.out.println(r3.toString());
		System.out.println(r3.calcArea());
		System.out.println(r3.calcPerimeter());
		System.out.println();
		
		System.out.println(r1.equals(r2));
		System.out.println(r1.equals(r3));
		System.out.println();
		
		System.out.println(r1.compareTo(r2));
		System.out.println(r1.compareTo(r3));
		System.out.println();
		
		System.out.println(r1.compareToArea(r2));
		System.out.println(r1.compareToArea(r3));
		System.out.println();
	}
}
