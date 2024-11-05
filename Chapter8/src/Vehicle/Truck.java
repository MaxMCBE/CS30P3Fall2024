package Vehicle;

public class Truck extends Vehicle
{
	private int truckVariable;
	
	public Truck(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c);
		truckVariable = x;
	}
	
	public int getTruckVariable()
	{
		return truckVariable;
	}
	
	public void setTruckVariable(int x)
	{
		truckVariable = x;
	}
	
	public void truckMethod()
	{
		System.out.println("Doing truck things");
	}
	
	public void drive() 
	{
		System.out.println("Truck is driving");
	}

	public void park() 
	{
		System.out.println("Truck is parked");
	}
}