package LocalBank;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Account 
{
	private DecimalFormat dc = new DecimalFormat("0.00");
	
	public double balance;
	public String id;
	private String fName;
	private String lName;
	
	public Account(String i, double b, String f, String l)
	{
		id = i;
		balance = b;
		fName = f;
		lName = l;
	}
	
	public String getName()
	{
		return fName + " " + lName;
	}
	
	public String getBalance()
	{
		return ("Current balance: $" + dc.format(balance));
	}
	
	public void deposit(double amount)
	{
		balance += amount;
		JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " deposited into account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void withdraw(double amount)
	{
		if (amount <= balance)
		{
			balance -= amount;
			JOptionPane.showMessageDialog(null, "$"+ dc.format(amount) + " withdrawn from account with ID '" + id + "' \nBalance: $" + dc.format(balance), "Withdrawal Successful", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Not enough money in account with ID '" + id + "' \nBalance: $" + dc.format(balance) + "\nRequested amount: $" + dc.format(amount), "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean equals(Account account)
	{
		if (id.equals(account.id))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}