package LocalBank;

//Imports
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/*

Program: Account.java          Last Date of this Revision: September 16, 2024

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
	public double balance;
	public String id;
	private String fName;
	private String lName;
	
	//Constructor, assigns all variables a value from parameters
	public Account(String i, double b, String f, String l)
	{
		id = i;
		balance = b;
		fName = f;
		lName = l;
	}
	
	//Return the full name of the account owner
	public String getName()
	{
		return fName + " " + lName;
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