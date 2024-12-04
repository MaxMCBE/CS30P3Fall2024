package TDTest;

public class Tower 
{
	private Player owner;
	private String skin;
	private int level;
	private String type;
	
	private String model;
	private String location;
	
	public Tower (Player p, String t)
	{
		owner = p;
		type = t;
		
		setSkin(owner);
	}
	
	public void setSkin(Player p)
	{
		skin = p.equippedSkins.get(type);
	}
	
	public void setLocation(String l)
	{
		location = l;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void render()
	{
		if (model != null)
		{
			model = null;
		}
		
		model = skin + " " + level;
	}
	
	public void upgrade(Player p)
	{
		int cost = level;
		if (p == owner && p.getMoney() >= cost)
		{
			level++;
			p.setMoney(p.getMoney() - cost);
			render();
			System.out.println("Upgraded to " + model);
		}
		else
		{
			System.out.println("Not enough money or invalid owner");
		}
	}
}