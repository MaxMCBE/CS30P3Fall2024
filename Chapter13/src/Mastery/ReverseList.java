package Mastery;

/*

Program: ReverseList.java          Last Date of this Revision: November 14, 2024

Purpose: Class that uses StackList to use a stack to reverse a set of data (changed from integers in the textbook because limiting it to one data type is boring and requires a lot of extra tedious input data verification) entered by the user. Haven't done console user interaction in a while, hopefully my code isn't too messy

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

//Imports
import java.util.*; //For scanner

public class ReverseList 
{
	static Scanner in = new Scanner(System.in); //Scanner object to get console input
	static StackList stack = new StackList(); //Stack to store data
	
	public static void main(String[] args) 
	{
		mainLoop:
		while (true) //Main program loop
		{
			stack.makeEmpty(); //Empty the stack each time the program begins (exists for when restarting, but I like having it here)
			
			System.out.println("Welcome to ReverseList\n\nHow many items would you like to enter?"); //Title and instructions
			int items = 0; //Variable for how many items will be entered
			
			try //Try to get input
			{
				items = Integer.parseInt(in.nextLine()); //Get input for items variable
			}
			catch (Exception e) //If the input cannot be turned to an integer
			{
				System.out.println("\nInvalid entry. Please try again.\n"); //Error message
				continue mainLoop; //Restart program
			}
			
			//Repeat as many times as the user requested
			for (int i = 0; i < items; i++)
			{
				System.out.println("\nPlease enter item #" + (i+1) + ":"); //Instructions
				String item = ""; //Current input variable
					
				item = in.nextLine(); //Get input
					
				stack.push(item); //When the input is successfully collected, add it to the top of the stack
			}
			
			String out = "\nThe list reversed is:\n"; //Start of the output string
			
			//While the stack has data
			while (stack.isEmpty() == false)
			{
				out += (stack.pop() + "\n"); //Remove the top item from the stack and add it to the output string
			}
			
			System.out.println(out); //Output the output string
			
			continueInputLoop:
			while (true) //Loop just for "Would you like to restart this program?" input
			{
				System.out.println("Please choose from the list below:\n(1) Restart the program\n(2) Close the program"); //Instructions
				String input = ""; //Input variable
				
				input = in.nextLine(); //Get input (This time it's a string because there's no significance to the data type)
				
				if (!(input.equals("1") || input.equals("2"))) //If the input is not one or two
				{
					System.out.println("\nInvalid entry. Please try again.\n"); //Error message
					continue continueInputLoop; //Restart this individual input loop
				}
				else if (input.equals("1")) //If the input is 1
				{
					System.out.println(); //New line just to make console look nicer
					continue mainLoop; //Restart the program
				}
				else //If the input IS 1 or 2 but NOT 1 (the input is 2)
				{
					break mainLoop; //Quit the program
				}
			}
		}
	}
}

/*
Screen Dump:
Case 1:
Welcome to ReverseList

How many items would you like to enter?
3

Please enter item #1:
1

Please enter item #2:
2

Please enter item #3:
3

The list reversed is:
3
2
1

Please choose from the list below:
(1) Restart the program
(2) Close the program
1

Welcome to ReverseList

How many items would you like to enter?
5

Please enter item #1:
a

Please enter item #2:
b

Please enter item #3:
c

Please enter item #4:
d

Please enter item #5:
e

The list reversed is:
e
d
c
b
a

Please choose from the list below:
(1) Restart the program
(2) Close the program
2

Case 2:
Welcome to ReverseList

How many items would you like to enter?
2

Please enter item #1:
2

Please enter item #2:
1

The list reversed is:
1
2

Please choose from the list below:
(1) Restart the program
(2) Close the program
2

Case 3:
Welcome to ReverseList

How many items would you like to enter?
a

Invalid entry. Please try again.

Welcome to ReverseList

How many items would you like to enter?
2

Please enter item #1:
abc

Please enter item #2:
123

The list reversed is:
123
abc

Please choose from the list below:
(1) Restart the program
(2) Close the program
2
 */