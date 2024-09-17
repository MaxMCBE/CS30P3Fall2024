package LocalBank;

//Imports
import java.util.*;
import javax.swing.JOptionPane;

/*

Program: Bank.java          Last Date of this Revision: September 17, 2024

Purpose: Object that contains and manages a HashMap of bank accounts for use with LocalBank.java and Account.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Bank 
{
	//Create a HashMap to contain accounts (an array seemed more annoying to use and less efficient)
	public HashMap<String, Account> accounts;
	
	//Constructor that just creates a new accounts HashMap
	public Bank ()
	{
		accounts = new HashMap<String, Account>();
	}
	
	//Create a new account with data equal to parameters and output success
	public void addAccount(String id, int pin, String fName, String lName, String street, String city, String province, String zip, double balance)
	{
		//This is a disgusting number of parameters, but I didn't really want to use an array for this and the textbook specifies the address data
		accounts.put(id, new Account(id, pin, fName, lName, street, city, province, zip, balance));
		JOptionPane.showMessageDialog(null, "Account successfully created with ID: '" + accounts.get(id).id +"'", "Account Creation Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void deleteAccount(String id)
	{
		if (accounts.get(id) != null) //If the requested account exists
		{
			accounts.remove(id); //Delete the account and output success
			JOptionPane.showMessageDialog(null, "Account with ID '" + id + "' deleted successfully", "Account Deleted", JOptionPane.INFORMATION_MESSAGE);
		}
		else //If the account does not exist
		{
			//Output failure
			JOptionPane.showMessageDialog(null, "Account with ID '" + id + "' not found.", "Account Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
}