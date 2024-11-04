package UEmployee;

public class Faculty extends UEmployee
{
	private String deptName;
	
	public Faculty(String n, int s, String d)
	{
		super(n, s);
		deptName = d;
	}
	
	public String getDeptName()
	{
		return deptName;
	}
	
	public void setDeptName(String d)
	{
		deptName = d;
	}
	
	public String toString()
	{
		return (super.getName() + " in department " + getDeptName() + " earns $" + super.getSalary() + "/year");
	}
}