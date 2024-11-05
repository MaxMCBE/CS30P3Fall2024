package UEmployee;

/*

Program: Staff.java          Last Date of this Revision: November 5, 2024

Purpose: Inherits UEmployee.java to create the object for an employee with a non-faculty job title

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Staff extends UEmployee //Extends UEmployee
{
	private String jobName; //Name of job
	
	/*
	 * Constructor
	 * @param n Name of employee
	 * @param s Salary of employee
	 * @param j Name of job
	 */
	public Staff (String n, int s, String j)
	{
		super(n, s); //Pass name and salary params into super constructor
		jobName = j; //Set job name to parameter
	}
	
	/*
	 * Returns the employee's job title
	 * @return name of employee's job as a string
	 */
	public String getJobName()
	{
		return jobName; //Return job name
	}
	
	/*
	 * Sets the employee's job title to a new value
	 * @param j New value of job title
	 */
	public void setJobName(String j)
	{
		jobName = j; //Set job name to parameter
	}
	
	/*
	 * Returns the object as a String, overriding toString()
	 * @return object as String
	 */
	public String toString()
	{
		//Return: Name with job X earns $Y/year
		return (super.getName() + " with job " + getJobName() + " earns $" + super.getSalary() + "/year");
	}
}