package Vehicle;

/*

Program: Truck.java          Last Date of this Revision: November 5, 2024

Purpose: Class that inherits Vehicle.java to represent a truck

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Truck extends Vehicle
{
	private int truckVariable; //Perfectly relevant and logical truck variable
	
	/*
	 * Constructor
	 * @param fC fuel economy of vehicle in a city
	 * @param fH fuel economy of vehicle on highway
	 * @param s seating capacity of vehicle
	 * @param c cargo volume of vehicle
	 * @param x truck variable of the vehicle
	 */
	public Truck(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c); //Pass the first 4 into the super constructor
		truckVariable = x; //Truck variable to x
	}
	
	/*
	 * Returns the truck variable
	 * @return value of truckVariable
	 */
	public int getTruckVariable()
	{
		return truckVariable;
	}
	
	/*
	 * Set the truck variable
	 * @param x New value of truckVariable
	 */
	public void setTruckVariable(int x)
	{
		truckVariable = x;
	}
	
	/*
	 * Does very helpful and necessary truck things
	 */
	public void truckMethod()
	{
		System.out.println("Doing truck things"); //Truck specific message
	}
	
	/*
	 * Abstract method of superclass to drive
	 */
	public void drive() 
	{
		System.out.println("Truck is driving"); //Truck specific driving message
	}
	
	/*
	 * Abstract method of superclass to park
	 */
	public void park() 
	{
		System.out.println("Truck is parked"); //Truck specific parking message
	}
}