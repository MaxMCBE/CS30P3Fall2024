package Roster;

/*

Program: StudentName.java          Last Date of this Revision: September 23, 2024

Purpose: A class that stores and returns 2 strings

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class StudentName 
{
	private String firstName;
	private String lastName;
	
	public StudentName(String fn, String ln)
	{
		firstName = fn;
		lastName = ln;
	}
	
	public String toString()
	{
		return firstName + " " + lastName;
	}
}