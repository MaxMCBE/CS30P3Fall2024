package Skillbuilders;

public class LinkedListTest 
{
	public static void main(String[] args) 
	{
		LinkedList l = new LinkedList();
		l.addEnd("1");
		System.out.println(l.toString());
		System.out.println(l.size() + " SIZE\n");
		
		l.addEnd("2");
		l.addEnd("3");
		System.out.println(l.toString());
		System.out.println(l.size() + " SIZE\n");
		
		l.empty();
		
		l.addFront("1");
		l.addFront("2");
		System.out.println(l.size() + " SIZE\n");
		l.addFront("3");
		System.out.println(l.toString());
		System.out.println(l.size() + " SIZE\n");
		
		l.remove("2");
		System.out.println(l.toString());
		System.out.println(l.size() + " SIZE\n");
	}
}
