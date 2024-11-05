package Vehicle;

/*

Program: Minivan.java          Last Date of this Revision: November 5, 2024

Purpose: Class that inherits Vehicle.java to represent a minivan

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class Minivan extends Vehicle
{
	private int minivanVariable; //Can't live without my minivan variable
	
	/*
	 * Constructor
	 * @param fC fuel economy of vehicle in a city
	 * @param fH fuel economy of vehicle on highway
	 * @param s seating capacity of vehicle
	 * @param c cargo volume of vehicle
	 * @param x minivan variable of the vehicle
	 */
	public Minivan(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c); //Pass the first 4 into the super constructor
		minivanVariable = x; //minivan variable to x
	}
	
	/*
	 * Returns the minivan variable
	 * @return value of minivanVariable
	 */
	public int getMinivanVariable()
	{
		return minivanVariable;
	}
	
	/*
	 * Set the minivan variable
	 * @param x New value of minivanVariable
	 */
	public void setMinivanVariable(int x)
	{
		minivanVariable = x;
	}
	
	/*
	 * Absolutely necessary subclass-unique method
	 */
	public void minivanMethod()
	{
		System.out.println("Doing minivan things"); //Minivan specific message
	}
	
	/*
	 * Abstract method of superclass to drive
	 */
	public void drive() 
	{
		System.out.println("Minivan is driving"); //Minivan specific driving message
	}
	
	/*
	 * Abstract method of superclass to park
	 */
	public void park() 
	{
		System.out.println("Minivan is parked"); //Minivan specific parking message
	}
	
	/*
	 * Returns object as a String
	 * @return object data converted to a String
	 */
	public String toString()
	{
		return "Minivan has: \nCity fuel economy: " + super.getFuelEconomyCity() + "\nHighway fuel economy: " + super.getFuelEconomyHwy() + "\nSeating capacity: " + super.getSeatingCapacity() + "\nCargo volume: " + super.getCargoVolume() + "\nMinivan variable: " + getMinivanVariable();
	}
}