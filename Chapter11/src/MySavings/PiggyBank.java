package MySavings;

//Imports
import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;

/*

Program: PiggyBank.java          Last Date of this Revision: October 1, 2024

Purpose: A class for use with MySavings.java that creates a PiggyBank object to store and modify data for the amount of coins in the piggy bank

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30

*/

public class PiggyBank 
{	
	//File to use for data storage
	File bankFile;
	/**
	 * File should look like:
	 * PENNIES_VALUE
	 * NICKELS_VALUE
	 * DIMES_VALUE
	 * QUARTERS_VALUE
	 * 
	 * ex:
	 * 3
	 * 7
	 * 2
	 * 0
	 */
	
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
	 * Tests to see if a given file exists
	 * @param path file path of the desired file
	 * @return true if the file exists, false if the file does not exist
	 */
	public boolean getFile(String path)
	{
		bankFile = new File(path); //Assign the source object to a file at the inputted path
		
		if (bankFile.exists()) //If it exists
		{
			return true; //Return true, and the program continues running
		}
		else //If it does not exist
		{
			//Output an error message
			JOptionPane.showMessageDialog(null, "File with path '" + path + "' could not be found", "File not found", JOptionPane.ERROR_MESSAGE); //Error message
			return false; //Return false (the program will not continue running)
		}
	}
	
	/*
	 * Reads a file at a given path for piggy bank data
	 * @param path of file to read
	 */
	public void read(String path)
	{
		if (getFile(path)) //If file exists
		{
			try //Catch exceptions from the reader or from parseInt
			{
				String line; //Current line
				int i = 0; //Index of current line
				BufferedReader in = new BufferedReader(new FileReader(bankFile)); //Create a reader
				
				while ((line = in.readLine()) != null) //While it can read a new line
				{
					if (i == 0) //If the line index is 0
					{
						pennies = Integer.parseInt(line); //Set number of pennies to value on line
					}
					else if (i == 1) //If the line index is 1
					{
						nickels = Integer.parseInt(line); //Set number of nickels to value on line
					}
					else if (i == 2) //If the line index is 2
					{
						dimes = Integer.parseInt(line); //Set number of dimes to value on line
					}
					else if (i == 3) //If the line index is 3
					{
						quarters = Integer.parseInt(line); //Set number of quarters to value on line
					}
					
					i++; //Increment index
				}
				
				in.close(); //Close reader stream
			}
			catch (Exception e) //If an exception is thrown (not found file, parseInt failed, etc)
			{
				JOptionPane.showMessageDialog(null, "An error occured while reading the file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
			}
		}
	}
	
	/*
	 * Writes piggy bank data to a file at a given path
	 * @param path of file to write to
	 */
	public void write(String path)
	{
		if (getFile(path)) //If it can successfully retrieve the file
		{
			try //Catch IOExceptions
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(bankFile)); //Create a writer
				
				out.write(Integer.toString(pennies)); //Line 0, write pennies value
				out.newLine(); //To line 1
				out.write(Integer.toString(nickels)); //Line 1, write nickels value
				out.newLine(); //To line 2
				out.write(Integer.toString(dimes)); //Line 2, write dimes value
				out.newLine(); //To line 3
				out.write(Integer.toString(quarters)); //Line 3, write quarters value
				
				out.close(); //Close writer, leaving the file with 4 lines each containing one value
			}
			catch (IOException e) //Catch any issues with the writer
			{
				JOptionPane.showMessageDialog(null, "An error occured while reading the file", "Error", JOptionPane.ERROR_MESSAGE); //Error message
			}
		}
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