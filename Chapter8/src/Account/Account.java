package Account;

//Imports
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/*

Program: Account.java          Last Date of this Revision: November 6, 2024

Purpose: Abstract object used to create a personal or business account that contains and manages individual account data for Bank.java and by extension LocalBank.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public abstract class Account 
{
	//Minimum balance and penalty for going below
	private int minimum;
	private int penalty;
	
	//DecimalFormat object to return balance
	private DecimalFormat dc = new DecimalFormat("0.00");
	
	//Account data variables
	public String id;
	private int pin;
	
	protected String fName;
	protected String lName;
	
	//Address
	private String street;
	private String city;
	private String province;
	private String zip;
	
	public double balance;
	
	/*
	 * Constructor
	 * @param i ID of account
	 * @param p PIN of account
	 * @param f First name of owner
	 * @param l Last name of owner
	 * @param s Street name of address
	 * @param c City name of address
	 * @param pr Province name of address
	 * @param z ZIP code
	 * @param b Balance of account
	 * @param m Minimum balance allowed in account
	 * @param pe Penalty when dropping below minimum balance
	 */
	public Account(String i, int p, String f, String l, String s, String c, String pr, String z, double b, int m, int pe)
	{
		id = i;
		pin = p;
		
		fName = f;
		lName = l;
		
		street = s;
		city = c;
		province = pr;
		zip = z;
		
		balance = b;
		
		minimum = m;
		penalty = pe;
	}
	
	/*
	 * Checks if a value matches the account's PIN
	 * @param p Input value to check against PIN
	 * @return true if p matches the PIN, false if not
	 */
	public boolean checkPin(int p)
	{
		if (p == pin)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Changes the current PIN value
	 * @param newPin value of new PIN to replace the old with
	 */
	public void changePin(int newPin)
	{
		if (Integer.toString(newPin).length() == 4) //If the new PIN is a 4 digit number
		{
			int oldPin = pin;
			pin = newPin; //Set new PIN and output results (censored because that is usually done with passwords and I thought it'd be good to refresh my knowledge of string manipulation)
			JOptionPane.showMessageDialog(null, "PIN changed from '" + Integer.toString(oldPin).charAt(0) + "***' to '" + Integer.toString(newPin).charAt(0) +"***' successfully", "PIN Change Successful", JOptionPane.INFORMATION_MESSAGE);
		}
		else //If the new PIN is NOT a 4 digit number
		{
			JOptionPane.showMessageDialog(null, "Please enter a 4 digit number for your PIN", "Invalid PIN", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}
	
	/*
	 * Returns the full name of the account owner as a String
	 * @return First and last name as one String
	 */
	public String getName()
	{
		return fName + " " + lName;
	}
	
	/*
	 * Returns the address and ZIP code of the account owner
	 * @return Street, city, province, and ZIP as one Strnig
	 */
	public String getAddress()
	{
		return street + ", " + city + ", " + province + ", ZIP: " + zip;
	}
	
	/*
	 * Changes the address of the account owner
	 * @param s New street
	 * @param c New city
	 * @param p New province
	 * @param z New ZIP code
	 */
	public void changeAddress(String s, String c, String p, String z)
	{
		street = s;
		city = c;
		province = p;
		zip = z;
		JOptionPane.showMessageDialog(null, "Address updated", "Address Change Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*
	 * Returns the balance of the account formatted with DecimalFormat
	 * @return Balance variable formatted and placed in a String
	 */
	public String getBalance()
	{
		return ("Current balance: $" + dc.format(balance));
	}
	
	/*
	 * Deposits money in account
	 * @param amount Amount to deposit
	 */
	public void deposit(double amount)
	{
		balance += amount;
		JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " deposited into account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*
	 * Withdraws money from account
	 * @param amount Amount to withdraw
	 */
	public void withdraw(double amount)
	{
		if (amount <= balance) //If withdrawal amount is valid
		{
			balance -= amount; //Remove money from account
			//Output success
			JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " withdrawn from account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Withdrawal Successful", JOptionPane.INFORMATION_MESSAGE);
			
			if (balance < minimum) //If balance is below minimum balance
			{
				balance -= penalty; //Subtract penalty from minimum balance
				//Output
				JOptionPane.showMessageDialog(null, "Account with ID '" + id + "' below minimum balance of $" + minimum + "\n$" + penalty + " removed \nBalance: $" + dc.format(balance), "Below Minimum Balance", JOptionPane.ERROR_MESSAGE);
			}
		}
		else //If withdrawal account is invalid
		{
			//Output balance and invalid requested amount
			JOptionPane.showMessageDialog(null, "Not enough money in account with ID '" + id + "' \nBalance: $" + dc.format(balance) + "\nRequested amount: $" + dc.format(amount), "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
		}
	}
}