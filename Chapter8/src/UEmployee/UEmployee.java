package UEmployee;

/*

Program: UEmployee.java          Last Date of this Revision: November 4, 2024

Purpose: Abstract class for a university employee, inherited by Faculty and Staff

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public abstract class UEmployee //Abstract because an employee will always be a faculty or staff and not just an employee
{
	private String name; //Name of employee
	private int salary; //Salary of employee
	
	/*
	 * Constructor
	 * @param n Name of employee
	 * @param s Salary of employee
	 */
	public UEmployee(String n, int s)
	{
		name = n; //Name and salary from parameters
		salary = s;
	}
	
	/*
	 * Returns the employee's name
	 * @return name of employee as a string
	 */
	public String getName()
	{
		return name; //Return name
	}
	
	/*
	 * Sets the employee's name to a new value
	 * @param n New name value of employee
	 */
	public void setName(String n)
	{
		name = n; //Set name to parameter
	}
	
	/*
	 * Returns the employee's salary
	 * @return employee's salary as an integer
	 */
	public int getSalary()
	{
		return salary; //Return salary
	}
	
	/*
	 * Sets the employee's salary to a new value
	 * @param s New salary of employee
	 */
	public void setSalary(int s)
	{
		salary = s; //Set salary to parameter
	}
}