package Vehicle;

public class Car extends Vehicle
{
	private int carVariable;
	
	public Car(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c);
		carVariable = x;
	}
	
	public int getCarVariable()
	{
		return carVariable;
	}
	
	public void setCarVariable(int x)
	{
		carVariable = x;
	}
	
	public void carMethod()
	{
		System.out.println("Doing car things");
	}
	
	public void drive() 
	{
		System.out.println("Car is driving");
	}

	public void park() 
	{
		System.out.println("Car is parked");
	}
}