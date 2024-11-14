package StackList;

/*

Program: QueueList.java          Last Date of this Revision: November 14, 2024

Purpose: Class that implements a queue using a linked list (using Node.java). Reuses a fair amount of code from StackList as they both use linked lists

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class QueueList 
{
	private Node head; //The class always has a head node (in the stack context, this is the top of the stack)
	
	/*
	 * Constructor
	 */
	public QueueList()
	{
		head = null; //Start with a null head, as it is empty
	}
	
	/*
	 * Returns the front item in the queue
	 * @return The data stored in the head (front) node
	 */
	public Object front()
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
	 * Removes the item at the front of the queue
	 * @return The data stored in the head (front) node
	 */
	public Object dequeue()
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
	 * Adds a new item to the back of the queue
	 * @param o Data to store in the new end node
	 */
	public void enqueue(Object o)
	{
		Node n = head; //Current node (starts at head)
		Node n1 = new Node(o); //New node to add to the queue
		
		if (n != null) //If the head is not null
		{
			while (n.getNext() != null) //While there is a new node after the current one
			{
				n = n.getNext(); //Set the current node to the following one
			}
			//When there is NO following node attached to the current one
			n.setNext(n1); //Attach the new node to the end of the current node
		}
		else //If the head is null (queue is empty)
		{
			head = n1; //Set the head to the new node
		}
	}
	
	/*
	 * Tests if the queue is empty
	 * @return True if the queue is empty, false if not
	 */
	public boolean isEmpty()
	{
		if (head == null) //If the head node is null (there are no nodes in the list/queue to hold data)
		{
			return true; //Return true
		}
		else //If a head node exists (there are nodes in the list/queue to hold data)
		{
			return false; //Return false
		}
	}
	
	/*
	 * Returns the number of items (nodes) in the queue (list)
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