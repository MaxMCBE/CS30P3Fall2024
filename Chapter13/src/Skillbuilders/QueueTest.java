package Skillbuilders;

public class QueueTest 
{
	public static void main(String[] args) 
	{
		Queue q = new Queue();
		
		q.enqueue("Hello");
		q.enqueue("World");
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		System.out.println(q.dequeue());
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		System.out.println(q.dequeue());
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		q.enqueue("Hello");
		q.enqueue("World");
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		q.makeEmpty();
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
	}
}