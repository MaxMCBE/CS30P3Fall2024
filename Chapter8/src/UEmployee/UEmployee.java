package UEmployee;

public class UEmployee 
{
	private String name;
	private int salary;
	
	public UEmployee(String n, int s)
	{
		name = n;
		salary = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void setSalary(int s)
	{
		salary = s;
	}
}