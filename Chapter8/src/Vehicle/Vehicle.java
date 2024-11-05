package Vehicle;

/*

Program: Vehicle.java          Last Date of this Revision: November 5, 2024

Purpose: Abstract class representing a generic vehicle

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public abstract class Vehicle 
{
	private int fuelEconomyCity; //Fuel economy of vehicle in a city
	private int fuelEconomyHwy; //Fuel economy of vehicle on highway
	private int seatingCapacity; //Seating capacity of vehicle
	private int cargoVolume; //Cargo volume of vehicle
	
	/*
	 * Constructor
	 * @param fC fuel economy of vehicle in a city
	 * @param fH fuel economy of vehicle on highway
	 * @param s seating capacity of vehicle
	 * @param c cargo volume of vehicle
	 */
	public Vehicle(int fC, int fH, int s, int c)
	{
		//Set all the variables to their parameter values
		fuelEconomyCity = fC;
		fuelEconomyHwy = fH;
		seatingCapacity = s;
		cargoVolume = c;
	}
	
	/*
	 * Returns fuel economy of the vehicle in a city
	 * @return value of fuelEconomyCity variable
	 */
	public int getFuelEconomyCity()
	{
		return fuelEconomyCity;
	}
	
	/*
	 * Sets the fuel economy in a city to a new value
	 * @param x New value of fuelEconomyCity
	 */
	public void setFuelEconomyCity(int x)
	{
		fuelEconomyCity = x;
	}
	
	/*
	 * Returns fuel economy of the vehicle on a highway
	 * @return value of fuelEconomyHwy variable
	 */
	public int getFuelEconomyHwy()
	{
		return fuelEconomyHwy;
	}
	
	/*
	 * Sets the fuel economy on a highway to a new value
	 * @param x New value of fuelEconomyHwy
	 */
	public void setFuelEconomyHwy(int x)
	{
		fuelEconomyHwy = x;
	}
	
	/*
	 * Returns seating capacity of the vehicle
	 * @return value of seatingCapacity variable
	 */
	public int getSeatingCapacity()
	{
		return seatingCapacity;
	}
	
	/*
	 * Sets the seating capacity of the vehicle to a new value
	 * @param x New value of seatingCapacity
	 */
	public void setSeatingCapacity(int x)
	{
		seatingCapacity = x;
	}
	
	/*
	 * Returns cargo volume of the vehicle
	 * @return value of cargoVolume variable
	 */
	public int getCargoVolume()
	{
		return cargoVolume;
	}
	
	/*
	 * Sets the cargo volume of the vehicle to a new value
	 * @param x New value of cargoVolume
	 */
	public void setCargoVolume(int x)
	{
		cargoVolume = x;
	}
	
	//Textbook said to define the general actions associated with a vehicle too. I figured I might as well make them abstract and define them in each subclass
	
	//Abstract method for driving the vehicle
	public abstract void drive();
	
	//Abstract method for parking the vehicle
	public abstract void park();
}