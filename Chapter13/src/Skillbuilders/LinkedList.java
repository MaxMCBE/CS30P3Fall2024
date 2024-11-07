package Skillbuilders;

public class LinkedList 
{
	private Node head;
	
	public LinkedList()
	{
		head = null;
	}
	
	public void addFront(Object o)
	{
		Node n = new Node(o);
		n.setNext(head);
		head = n;
	}
	
	public void addEnd(Object o)
	{
		Node n = head;
		
		if (n != null)
		{
			while (n.getNext() != null)
			{
				n = n.getNext();
			}
			
			n.setNext(new Node(o));
		}
		else
		{
			head = new Node(o);
		}
	}
	
	public void remove(Object o)
	{
		Node n = head;
		Node prev = head;
		
		if (n.getData() == o)
		{
			head = n.getNext();
		}
		else
		{
			while (n.getNext() != null)
			{
				prev = n;
				n = n.getNext();
				if (n.getData() == o)
				{
					prev.setNext(n.getNext());
				}
			}
		}
	}
	
	public void empty()
	{
		head = null;
	}
	
	public int size()
	{
		int i = 0;
		Node n = head;
		
		if (n != null)
		{
			i++;
			while (n.getNext() != null)
			{
				i++;
				n = n.getNext();
			}
			return i;
		}
		else
		{
			return i;
		}
	}
	
	public String toString()
	{
		Node n = head;
		String r;
		
		if (n != null)
		{
			r = n.getData().toString() + "\n";
			while (n.getNext() != null)
			{
				n = n.getNext();
				r += n.getData().toString() + "\n";
			}
			return(r);
		}
		else
		{
			return null;
		}
	}
}

class Node
{
	private Object data;
	private Node next;
	
	public Node(Object o)
	{
		data = o;
		next = null;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public Object getData()
	{
		return data;
	}
}