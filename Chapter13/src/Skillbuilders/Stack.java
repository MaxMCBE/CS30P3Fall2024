package Skillbuilders;

import java.util.*;

public class Stack 
{
	private ArrayList<Object> data;
	
	public Stack()
	{
		data = new ArrayList<Object>();
	}
	
	public Object top()
	{
		return (data.get(data.size()-1));
	}
	
	public Object pop()
	{
		if (data.size() > 0)
		{
			Object r = data.get(data.size()-1);
			data.remove(data.size()-1);
			return (r);
		}
		else
		{
			return null;
		}
	}
	
	public void push(Object x)
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