package UEmployee;

/*

Program: Faculty.java          Last Date of this Revision: November 5, 2024

Purpose: Inherits UEmployee.java to create the object for an employee belonging to a university faculty

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Faculty extends UEmployee //Extends UEmployee
{
	private String deptName; //Name of employee's department
	
	/*
	 * Constructor
	 * @param n Name of employee
	 * @param s Salary of employee
	 * @param d Name of department
	 */
	public Faculty(String n, int s, String d)
	{
		super(n, s); //Pass name and salary parameters to super constructor
		deptName = d; //Set department name to parameter
	}
	
	/*
	 * Returns the employee's department name
	 * @return name of employee's department as a string
	 */
	public String getDeptName()
	{
		return deptName; //Return department name
	}
	
	/*
	 * Sets the employee's department name to a new value
	 * @param n New value of department name
	 */
	public void setDeptName(String d)
	{
		deptName = d; //Set department name to parameter
	}
	
	/*
	 * Returns the object as a String, overriding toString()
	 * @return object as String
	 */
	public String toString()
	{
		//Return: Name in department X earns $Y/year
		return (super.getName() + " in department " + getDeptName() + " earns $" + super.getSalary() + "/year");
	}
}