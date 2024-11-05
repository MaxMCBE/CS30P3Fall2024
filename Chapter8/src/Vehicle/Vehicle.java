package Vehicle;

public abstract class Vehicle 
{
	private int fuelEconomyCity;
	private int fuelEconomyHwy;
	private int seatingCapacity;
	private int cargoVolume;
	
	public Vehicle(int fC, int fH, int s, int c)
	{
		fuelEconomyCity = fC;
		fuelEconomyHwy = fH;
		seatingCapacity = s;
		cargoVolume = c;
	}
	
	public int getFuelEconomyCity()
	{
		return fuelEconomyCity;
	}
	
	public void setFuelEconomyCity(int x)
	{
		fuelEconomyCity = x;
	}
	
	public int getFuelEconomyHwy()
	{
		return fuelEconomyHwy;
	}
	
	public void setFuelEconomyHwy(int x)
	{
		fuelEconomyHwy = x;
	}
	
	public int getSeatingCapacity()
	{
		return seatingCapacity;
	}
	
	public void setSeatingCapacity(int x)
	{
		seatingCapacity = x;
	}
	
	public int getCargoVolume()
	{
		return cargoVolume;
	}
	
	public void setCargoVolume(int x)
	{
		cargoVolume = x;
	}
	
	public abstract void drive();
	
	public abstract void park();
}