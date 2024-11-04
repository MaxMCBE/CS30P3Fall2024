package UEmployee;

public class University 
{
	public static void main(String[] args) 
	{
		Faculty e1 = new Faculty("NAME1", 1, "DEPT1");
		Faculty e2 = new Faculty("NAME2", 2, "DEPT2");
		Staff e3 = new Staff("NAME3", 3, "JOB3");
		Faculty e4 = new Faculty("NAME4", 4, "DEPT4");
		Staff e5 = new Staff("NAME5", 5, "JOB5");
		
		Object[] employees = {e1, e2, e3, e4, e5};
		
		for (int i = 0; i < employees.length; i++)
		{
			System.out.println(employees[i].toString());
		}
	}
}
