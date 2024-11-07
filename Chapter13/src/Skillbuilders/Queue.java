package Skillbuilders;

import java.util.*;

public class Queue 
{
	private ArrayList<Object> data;
	
	public Queue()
	{
		data = new ArrayList<Object>();
	}
	
	public Object front()
	{
		return (data.get(0));
	}
	
	public Object dequeue()
	{
		if (data.size() > 0)
		{
			Object r = data.get(0);
			data.remove(0);
			return (r);
		}
		else
		{
			return null;
		}
	}
	
	public void enqueue (Object x)
	{
		data.add(x);
	}
	
	public boolean isEmpty()
	{
		if (data.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int size()
	{
		return data.size();
	}
	
	public void makeEmpty()
	{
		data.clear();
	}
}