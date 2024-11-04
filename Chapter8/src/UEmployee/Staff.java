package UEmployee;

public class Staff extends UEmployee
{
	private String jobName;
	
	public Staff (String n, int s, String j)
	{
		super(n, s);
		jobName = j;
	}
	
	public String getJobName()
	{
		return jobName;
	}
	
	public void setJobName(String j)
	{
		jobName = j;
	}
	
	public String toString()
	{
		return (super.getName() + " with job " + getJobName() + " earns $" + super.getSalary() + "/year");
	}
}