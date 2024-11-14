package Mastery;

/*

Program: Node.java          Last Date of this Revision: November 14, 2024

Purpose: A class that allows the creation of nodes for linked lists. This originally existed within StackList.java but it created issues when trying to create another within QueueList.java, so I moved it out to here where both can use it

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Node //Node class for linked list implementation
{
	private Object data; //Data for this node (as a node is part of the data structure, not the data actually being stored in it)
	private Node next; //Next node in the list
	
	/*
	 * Constructor
	 * @param o Object to use as the node's data
	 */
	public Node(Object o)
	{
		data = o; //Data is the parameter object
		next = null; //Next node is null, as of now. Something probably leads into it, but it does not yet lead into anything else
	}
	
	/*
	 * Returns the next node in the list
	 * @return Following Node object
	 */
	public Node getNext()
	{
		return next; //Return the next node
	}
	
	/*
	 * Sets the next node 
	 * @param n Node to use as the next one
	 */
	public void setNext(Node n)
	{
		next = n; //Following node is set to parameter
	}
	
	/*
	 * Returns the data stored in the node
	 * @return The data stored in the node, as an object
	 */
	public Object getData()
	{
		return data; //Return the node's data
	}
}