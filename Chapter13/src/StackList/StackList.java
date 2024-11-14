package StackList;

public class StackList 
{
	private Node head;
	
	public StackList()
	{
		head = null;
	}
	
	public void push(Object o)
	{
		Node n = new Node(o);
		n.setNext(head);
		head = n;
	}
	
	public void pop(Object o)
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