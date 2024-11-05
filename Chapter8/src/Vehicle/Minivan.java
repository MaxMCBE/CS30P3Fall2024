package Vehicle;

public class Minivan extends Vehicle
{
	private int minivanVariable;
	
	public Minivan(int fC, int fH, int s, int c, int x)
	{
		super(fC, fH, s, c);
		minivanVariable = x;
	}
	
	public int getMinivanVariable()
	{
		return minivanVariable;
	}
	
	public void setMinivanVariable(int x)
	{
		minivanVariable = x;
	}
	
	public void minivanMethod()
	{
		System.out.println("Doing minivan things");
	}
	
	public void drive() 
	{
		System.out.println("Minivan is driving");
	}

	public void park() 
	{
		System.out.println("Minivan is parked");
	}
}