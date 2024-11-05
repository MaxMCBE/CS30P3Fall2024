package UEmployee;

/*

Program: University.java          Last Date of this Revision: November 5, 2024

Purpose: Uses Faculty.java and Staff.java to run some basic code for demonstration. This is not asked for in the textbook and therefore extremely bare bones, as it is just for ensuring functionality.

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class University 
{
	public static void main(String[] args) 
	{
		//Create new employees of Faculty and Staff types with placeholder values
		Faculty e1 = new Faculty("NAME1", 1, "DEPT1");
		Faculty e2 = new Faculty("NAME2", 2, "DEPT2");
		Staff e3 = new Staff("NAME3", 3, "JOB3");
		Faculty e4 = new Faculty("NAME4", 4, "DEPT4");
		Staff e5 = new Staff("NAME5", 5, "JOB5");
		
		Object[] employees = {e1, e2, e3, e4, e5}; //Put employees in an array
		
		for (int i = 0; i < employees.length; i++) //Loop through the array
		{
			System.out.println(employees[i].toString()); //Output each element
		}
	}
}

/*
Screen Dump:

NAME1 in department DEPT1 earns $1/year
NAME2 in department DEPT2 earns $2/year
NAME3 with job JOB3 earns $3/year
NAME4 in department DEPT4 earns $4/year
NAME5 with job JOB5 earns $5/year
*/