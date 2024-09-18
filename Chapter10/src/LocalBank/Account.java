package LocalBank;

//Imports
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/*

Program: Account.java          Last Date of this Revision: September 18, 2024

Purpose: Object that contains and manages individual account data for Bank.java and by extension LocalBank.java

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class Account 
{
	//DecimalFormat object to return balance
	private DecimalFormat dc = new DecimalFormat("0.00");
	
	//Account data variables
	public String id;
	private int pin;
	
	private String fName;
	private String lName;
	
	//Address
	private String street;
	private String city;
	private String province;
	private String zip;
	
	public double balance;
	
	//Constructor, assigns all variables a value from parameters
	public Account(String i, int p, String f, String l, String s, String c, String pr, String z, double b)
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
		
	}
	
	//Function that takes a PIN as input and checks if it matches, returning true or false
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
	
	//Method that allows the user to change the account PIN, taking the current and new PIN as parameters
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
	
	//Return the full name of the account owner
	public String getName()
	{
		return fName + " " + lName;
	}
	
	//Return the address and ZIP code of the account owner
	public String getAddress()
	{
		return street + ", " + city + ", " + province + ", ZIP: " + zip;
	}
	
	//Take parameters for all address variables and swap them. Just looks nicer than making them all public and doing it one at a time in the main class
	public void changeAddress(String s, String c, String p, String z)
	{
		street = s;
		city = c;
		province = p;
		zip = z;
		JOptionPane.showMessageDialog(null, "Address updated", "Address Change Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Return the formatted balance
	public String getBalance()
	{
		return ("Current balance: $" + dc.format(balance));
	}
	
	//Add money to account and output success
	public void deposit(double amount)
	{
		balance += amount;
		JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " deposited into account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void withdraw(double amount)
	{
		if (amount <= balance) //If withdrawal amount is valid
		{
			balance -= amount; //Remove money from account
			//Output success
			JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " withdrawn from account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Withdrawal Successful", JOptionPane.INFORMATION_MESSAGE);
		}
		else //If withdrawal account is invalid
		{
			//Output balance and invalid requested amount
			JOptionPane.showMessageDialog(null, "Not enough money in account with ID '" + id + "' \nBalance: $" + dc.format(balance) + "\nRequested amount: $" + dc.format(amount), "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
		}
	}
}