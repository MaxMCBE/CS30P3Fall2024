package TDTest;

public class test 
{
	public static void main(String[] args) 
	{
		Player p1 = new Player();
		p1.populate();
		
		p1.setMoney(5);
		
		Tower t1 = new Tower(p1, "1");
	}
}
