package Account;

//Imports
import java.util.*;
import javax.swing.JOptionPane;

/*

Program: Bank.java          Last Date of this Revision: November 6, 2024

Purpose: Object that contains and manages a HashMap of bank accounts for use with LocalBank.java and subclasses of Account.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Bank 
{
	//Create a HashMap to contain accounts (an array seemed more annoying to use and less efficient)
	public HashMap<String, Account> accounts;
	
	/*
	 * Constructor
	 */
	public Bank ()
	{
		accounts = new HashMap<String, Account>(); //Creates a hashmap to contain Account subclasses
	}
	
	/*
	 * Creates an account subclass object and adds it to the hashmap
	 * @param id ID of account
	 * @param pin PIN of account
	 * @param fName First name of owner
	 * @param lName Last name of owner
	 * @param street Street name of address
	 * @param city City name of address
	 * @param province Province name of address
	 * @param zip ZIP code
	 * @param balance Balance of account
	 * @param business Is this a business account (false means no, it is personal)
	 */
	public void addAccount(String id, int pin, String fName, String lName, String street, String city, String province, String zip, double balance, boolean business)
	{
		//This is a disgusting number of parameters, but I didn't really want to use an array for this and the textbook specifies the address data
		
		if (business) //If creating a business account
		{
			String businessName = JOptionPane.showInputDialog(null, "Enter name of business:", "Account Creation", JOptionPane.QUESTION_MESSAGE);
			if (balance >= BusinessAcct.MIN) //If the balance is above minimum business account balance
			{
				//Create the BusinessAcct and put it in the hashmap
				accounts.put(id, new BusinessAcct(id, pin, fName, lName, street, city, province, zip, balance, businessName));
				JOptionPane.showMessageDialog(null, "Account successfully created with ID: '" + accounts.get(id).id +"'", "Account Creation Successful", JOptionPane.INFORMATION_MESSAGE);
			}
			else //If the balance is below the minimum
			{
				//Error message
				JOptionPane.showMessageDialog(null, "Balance of $" + balance + " below minimum business account balance of $" + BusinessAcct.MIN, "Account Creation Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
		else //Otherwise
		{
			if (balance >= PersonalAcct.MIN) //if the balance is above the minimum personal account balance
			{
				//Create the PersonalAcct and put it in the hashmap
				accounts.put(id, new PersonalAcct(id, pin, fName, lName, street, city, province, zip, balance));
				JOptionPane.showMessageDialog(null, "Account successfully created with ID: '" + accounts.get(id).id +"'", "Account Creation Successful", JOptionPane.INFORMATION_MESSAGE);
			}
			else //If the balance is below the minimum
			{
				//Error message
				JOptionPane.showMessageDialog(null, "Balance of $" + balance + " below minimum personal account balance of $" + PersonalAcct.MIN, "Account Creation Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/*
	 * Deletes an account
	 * @param id ID of account to delete
	 */
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