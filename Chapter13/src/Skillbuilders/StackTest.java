package Skillbuilders;

public class StackTest 
{
	public static void main(String[] args) 
	{
		Stack list = new Stack();
		list.push("Hello");
		list.push("World");
		
		System.out.println(list.size());
		System.out.println(list.pop());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.pop());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		list.push("Hello");
		list.push("World");
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		list.makeEmpty();
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
}