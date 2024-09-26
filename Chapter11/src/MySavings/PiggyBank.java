package MySavings;

/*

Program: PiggyBank.java          Last Date of this Revision: September 26, 2024

Purpose: A class for use with MySavings.java that creates a PiggyBank object to store and modify data for the amount of coins in the piggy bank

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class PiggyBank 
{
	//Coin variables
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;
	
	//Constructor
	public PiggyBank()
	{
		//Set everything to empty
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}
	
	/*
	 * Deposits a requested amount of money in the piggy bank, using the largest possible coins
	 * @param amount total balance of money to add
	 */
	public void deposit(double amount)
	{
		while (amount > 0) //While there is money to deposit
		{
			if (amount >= 0.25) //If a quarter can be broken off
			{
				quarters++; //Add a quarter
				amount -= 0.25; //Remove a quarter from the amount
			}
			else if (amount >= 0.10) //Repeat for other coin types
			{
				dimes++;
				amount -= 0.10;
			}
			else if (amount >= 0.05)
			{
				nickels++;
				amount -= 0.05;
			}
			else if (amount >= 0.01)
			{
				pennies++;
				amount -= 0.01;
			}
			else //If there is less than 1 cent left in the amount, set it to 0 (prevent infinite loop if 0.001 is fed into the program)
			{
				amount = 0;
			}
		}
	}
	
	/*
	 * Withdraws a requested amount of money from the piggy bank using the largest possible coins
	 * @param amount total balance of money to withdraw
	 */
	public void withdraw(double amount) 
	{
		//Exact same code as deposit() but it increments the coin type down instead of up
		while (amount > 0)
		{
			if (amount >= 0.25)
			{
				quarters--;
				amount -= 0.25;
			}
			else if (amount >= 0.10)
			{
				dimes--;
				amount -= 0.10;
			}
			else if (amount >= 0.05)
			{
				nickels--;
				amount -= 0.05;
			}
			else if (amount >= 0.01)
			{
				pennies--;
				amount -= 0.01;
			}
			else
			{
				amount = 0;
			}
		}
	}
	
	/*
	 * Returns the number of each type of coin in the bank
	 * @return a string containing the number of each coin type
	 */
	public String returnCoins()
	{
		return "Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels + ", Pennies: " + pennies;
	}
	
	/*
	 * Returns the amount of money in the bank
	 * @return a double value calculated by adding the value of all coins in the bank
	 */
	public double returnAmount()
	{
		return ((0.25 * quarters) + (0.1 * dimes) + (0.05 * nickels) + (0.01 * pennies));
	}
}