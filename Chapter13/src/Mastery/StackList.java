package Mastery;

/*

Program: StackList.java          Last Date of this Revision: November 14, 2024

Purpose: Class that implements a stack using a linked list (using Node.java)

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class StackList 
{
	private Node head; //The class always has a head node (in the stack context, this is the top of the stack)
	
	/*
	 * Constructor
	 */
	public StackList()
	{
		head = null; //Start with a null head, as it is empty
	}
	
	/*
	 * Returns the top item in the stack
	 * @return The data stored in the head (top) node
	 */
	public Object top()
	{
		if (head != null) //If the head exists
		{
			return head.getData(); //Return the data of the head node
		}
		else //If the head does not exist
		{
			return null; //Return null
		}
	}
	
	/*
	 * Adds a new item to the top of the stack
	 * @param o Object to add to the stack
	 */
	public void push(Object o)
	{
		Node n = new Node(o); //Create a new node with the data from the parameter
		n.setNext(head); //Set the new node's follower to the current head node
		head = n; //Set the new node as the head/top of the list/stack
	}
	
	/*
	 * Removes the item at the top of the stack
	 * @return The data stored in the head (top) node
	 */
	public Object pop()
	{
		Node n = head; //Node n is the current head
		
		if (n != null) //If n exists
		{
			head = n.getNext(); //The new head is the follower of the old one (cuts the old head out of the list, as nothing leads to it anymore)
			return n.getData(); //Return the data of the old head node
		}
		else //If n does not exist
		{
			return null; //Return null
		}
	}
	
	/*
	 * Tests if the stack is empty
	 * @return True if the stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if (head == null) //If the head node is null (there are no nodes in the list/stack to hold data)
		{
			return true; //Return true
		}
		else //If a head node exists (there are nodes in the list/stack to hold data)
		{
			return false; //Return false
		}
	}
	
	/*
	 * Returns the number of items (nodes) in the stack (list)
	 * @return The total number of items
	 */
	public int size()
	{
		int i = 0; //Variable to count nodes
		Node n = head; //Current node (starts at head)
		
		if (n != null) //If the list is not empty
		{
			i++; //Increase i
			while (n.getNext() != null) //While more nodes exist after the first one
			{
				i++; //Increase i
				n = n.getNext(); //Set the current node to the next one
			}
			return i; //Return i
		}
		else //If the list is empty
		{
			return i; //Return i now (equal to 0)
		}
	}
	
	/*
	 * Makes the list empty (removes all data contained in it)
	 */
	public void makeEmpty()
	{
		head = null; //Set the head to null (detaches all data from the list, making it inaccessible and the list empty)
	}
}