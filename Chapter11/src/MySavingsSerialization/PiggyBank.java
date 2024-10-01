package MySavingsSerialization;

//Imports
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.*;

/*

Program: PiggyBank.java          Last Date of this Revision: October 1, 2024

Purpose: A class for use with MySavings.java that creates a PiggyBank object to store and modify data for the amount of coins in the piggy bank

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

@SuppressWarnings("serial") //Yellow warning for a missing variable not mentioned in textbook, so I'm just ignoring it
public class PiggyBank implements Serializable
{		
	//DecimalFormat object
	DecimalFormat dc = new DecimalFormat("0.00");
	
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
			else if (amount >= 0.10) //If a quarter cannot be broken off but a dime can
			{
				dimes++; //Add a dime
				amount -= 0.10; //Remove a dime from the amount
			}
			else if (amount >= 0.05) //If a dime cannot be broken off but a nickel can
			{
				nickels++; //Add a nickel
				amount -= 0.05; //Remove a nickel from the amount
			}
			else if (amount >= 0.01) //If a nickel cannot be broken off but a penny can
			{
				pennies++; //Add a penny
				amount -= 0.01; //Remove a penny from the amount
			}
			else //If there is less than 1 cent left in the amount, set it to 0 (prevent infinite loop if 0.001 or anything else below 1 cent is fed into the program)
			{
				amount = 0;
			}
		}
	}
	
	/*
	 * Withdraws specific requested coins from the bank
	 * @param p number of pennies to withdraw
	 * @param n number of nickels to withdraw
	 * @param d number of dimes to withdraw
	 * @param q number of quarters to withdraw
	 */
	public void withdraw(int p, int n, int d, int q)
	{
		try //If it cannot withdraw the requested coins it will throw an exception
		{
			if (pennies >= p) //If enough pennies exist
			{
				pennies -= p; //Remove the pennies
			}
			else //If they do not exist
			{
				throw new Exception(); //Throw exception
			}
			
			if (nickels >= n) //If enough nickels exist
			{
				nickels -= n; //Remove the nickels
			}
			else //If they do not exist
			{
				throw new Exception(); //Throw exception
			}
			
			if (dimes >= d) //If enough dimes exist
			{
				dimes -= d; //Remove the dimes
			}
			else //If they do not exist
			{
				throw new Exception(); //Throw exception
			}
				
			if (quarters >= q) //If enough quarters exist
			{
				quarters -= q; //Remove the quarters
			}
			else //If they do not exist
			{
				throw new Exception(); //Throw exception
			}
		}
		catch (Exception e) //Catch thrown exceptions (all thrown when requested coins do not exist)
		{
			JOptionPane.showMessageDialog(null, "Not enough coins in the piggy bank", "Insufficient balance", JOptionPane.ERROR_MESSAGE); //Error message
		}
	}
	
	/*
	 * Returns the number of each type of coin in the bank
	 * @return a string containing the number of each coin type
	 */
	public int[] returnCoins()
	{
		int[] coins = {pennies, nickels, dimes, quarters}; //Create an integer array containing the number of each coin type from smallest to largest value
		return coins; //Return the array
	}
	
	/*
	 * Returns the amount of money in the bank
	 * @return a string value calculated by adding the value of all coins in the bank and processing with DecimalFormat
	 */
	public String returnAmount()
	{
		return dc.format((0.25 * quarters) + (0.1 * dimes) + (0.05 * nickels) + (0.01 * pennies)); //Return a formatted decimal of the total value of all coins
	}
}