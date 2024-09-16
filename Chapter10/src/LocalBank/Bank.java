package LocalBank;

import java.util.*;

import javax.swing.JOptionPane;

public class Bank 
{
	public HashMap<String, Account> accounts;
	
	public Bank ()
	{
		accounts = new HashMap<String, Account>();
	}
	
	public void addAccount(String id, double balance, String fName, String lName)
	{
		accounts.put(id, new Account(id, balance, fName, lName));
		JOptionPane.showMessageDialog(null, "Account successfully created with ID: '" + accounts.get(id).id +"'", "Account Creation Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void deleteAccount(String id)
	{
		if (accounts.get(id) != null)
		{
			accounts.remove(id);
			JOptionPane.showMessageDialog(null, "Account with ID '" + id + "' deleted successfully", "Account Deleted", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Account with ID '" + id + "' not found.", "Account Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
}
