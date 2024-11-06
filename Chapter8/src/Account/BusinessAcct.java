package Account;

/*

Program: BusinessAcct.java          Last Date of this Revision: November 6, 2024

Purpose: Subclass of Account.java with a higher minimum balance and penalty than PersonalAcct

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class BusinessAcct extends Account 
{
	public static final int MIN = 500; //Minimum balance
	public static final int PEN = 10; //Penalty for dropping below
	
	private String business;
	
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
	 */
	public BusinessAcct(String i, int p, String f, String l, String s, String c, String pr, String z, double b, String bu) 
	{
		super(i, p, f, l, s, c, pr, z, b, MIN, PEN); //Constructor that just passes all the parameters into the super constructor PLUS the minimum and penalty
		business = bu;
	}
	
	/*
	 * Returns the full name of the account owner as a String with the business name attached
	 */
	public String getName()
	{
		return super.fName + " " + super.lName + ", " + business;
	}
}