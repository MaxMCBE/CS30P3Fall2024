package TDTest;

import java.util.*;

public class Player 
{
	private int money;
	
	public HashMap<String, HashMap<String, String>> skins = new HashMap<String, HashMap<String, String>>();
	
	public HashMap<String, String> equippedSkins = new HashMap<String, String>();
	
	public void setMoney(int m)
	{
		money = m;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void populate()
	{
		HashMap<String, String> t1Skins = new HashMap<String, String>();
		t1Skins.put("1", "Skin 1");
		t1Skins.put("2", "Skin 2");
		
		HashMap<String, String> t2Skins = new HashMap<String, String>();
		t2Skins.put("1", "Skin 1");
		t2Skins.put("2", "Skin 2");
		t2Skins.put("3", "Skin 3");
		
		HashMap<String, String> t3Skins = new HashMap<String, String>();
		t3Skins.put("1", "Skin 1");
		
		skins.put("1", t1Skins);
		skins.put("2", t2Skins);
		skins.put("3", t3Skins);
		
		equippedSkins.put("1", "2");
		equippedSkins.put("2", "3");
		equippedSkins.put("3", "1");
	}
}