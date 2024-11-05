package Vehicle;

/*

Program: Car.java          Last Date of this Revision: November 5, 2024

Purpose: Class that inherits Vehicle.java to represent a car

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Car extends Vehicle
{
	private int carVariable; //I know almost nothing about vehicles so I just added generic variables and generic print methods to each subclass
	
	/*
	 * Constructor
	 * @param fC fuel economy of vehicle in a city
	 * @param fH fuel economy of vehicle on highway
	 * @param s seating capacity of vehicle
	 * @param c cargo volume of vehicle
	 * @param x car variable of the vehicle
	 */
	public Car(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c); //Pass the first 4 into the super constructor
		carVariable = x; //Car variable to x
	}
	
	/*
	 * Returns the car variable
	 * @return value of carVariable
	 */
	public int getCarVariable()
	{
		return carVariable;
	}
	
	/*
	 * Set the car variable
	 * @param x New value of carVariable
	 */
	public void setCarVariable(int x)
	{
		carVariable = x;
	}
	
	/*
	 * Does car things (I really know nothing about vehicles)
	 */
	public void carMethod()
	{
		System.out.println("Doing car things"); //Car specific message
	}
	
	/*
	 * Abstract method of superclass to drive
	 */
	public void drive() 
	{
		System.out.println("Car is driving"); //Car specific driving message
	}
	
	/*
	 * Abstract method of superclass to park
	 */
	public void park() 
	{
		System.out.println("Car is parked"); //Car specific parking message
	}
}