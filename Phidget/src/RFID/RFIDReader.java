package RFID;

/*

Program: RFIDTest.java          Last Date of this Revision: November 27, 2024

Purpose: Reads RFID tags and returns their name from data.txt if the tag is logged, otherwise it allows the user to add the tag to the file
Very easy to modify the program to store a third (or more) value for if the object is logged in or out, for example, using another colon to break up the string

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

import java.io.*;
import java.util.*;
import com.phidget22.*;

public class RFIDReader 
{
	//Data HashMap containing tag/name pairs
	static HashMap<String, String> data = new HashMap<String, String>();
	
	//File containing tag/name data
	final static File DATA_FILE = new File("src//RFID//data.txt");
	
	//Reads the file and builds the HashMap
	public static void readFile(File f) throws Exception
	{
		//Reader
		BufferedReader in = new BufferedReader(new FileReader(f));
		String line = ""; //Current line
		
		data.clear(); //Empty the HashMap before refilling it
		
		while ((line = in.readLine()) != null) //While the next line is NOT null
		{
			int colonIndex = line.indexOf(':'); //Find the semicolon (divides tag and name)
			String tag = line.substring(0, colonIndex); //Isolate the tag part
			String name = line.substring(colonIndex+1); //Isolate the name part
			
			data.put(tag, name); //Add the tag/name pair to the data HashMap
		}
		
		in.close(); //Close scanner
	}
	
	//Write new item to file
	public static void writeFile(File f, String tag) throws Exception
	{
		//Writer
		BufferedWriter out = new BufferedWriter(new FileWriter(f, true)); //True means it appends to the end of the file
		//Scanner
		Scanner in = new Scanner(System.in);
		
		//Get input
		System.out.println("Enter name of tag:");
		String name = in.nextLine();
		
		if (name.indexOf(":") != -1) //If the input contains no colons
		{
			out.write((tag + ":" + name));
			
			System.out.println("Tag '" + tag + "' added to file with name '" + name +"'\n");
			
			data.put(tag, name); //Add to the data HashMap (I used to just call readFile, but that requires reloading everything else as well so it's extremely inefficient
		}
		else //If the input contains a colon (may break everything, especially if more data is added)
		{
			System.out.println("Name cannot contain ':'\n"); //Error message
		}
		
		//Close writer and scanner
		out.close();
		in.close();
	}
	
	public static void main(String[] args) throws Exception 
	{
		//Define Phidgets
		RFID rfid0 = new RFID();
		DigitalOutput digitalOutput2 = new DigitalOutput();
		
		//Address Phidgets
		digitalOutput2.setChannel(2);
		
		//On tag found listener
		rfid0.addTagListener(new RFIDTagListener() 
		{
			public void onTag(RFIDTagEvent e) 
			{
				//Print tag and protocol
				System.out.println("Tag: " + e.getTag());
				System.out.println("Protocol: " + e.getProtocol().name());
				
				if (data.get(e.getTag()) != null) //If it exists in the data
				{
					System.out.println("Found " + data.get(e.getTag())); //Print the name
				}
				else //Otherwise, print unknown
				{
					System.out.println("Found unknown tag");
					
					//Ask the user if they want to add the tag to the file
					System.out.println("Would you like to add tag to file? Y or N:");
					try //Catch input issues
					{
						Scanner in = new Scanner(System.in); //Create scanner
						
						String input = in.nextLine(); //Get input
						
						in.close(); //Close scanner
						
						if ((input.toLowerCase()).equals("y")) //If yes
						{
							writeFile(DATA_FILE, e.getTag()); //Call writeFile() with the data file and current tag
						}
						else if ((input.toLowerCase()).equals("n")) //If no
						{
							System.out.println("Confirmed\n"); //Confirmation message
						}
						else //If neither
						{
							throw new Exception(); //Throw exception
						}
					}
					catch (Exception e1) //If anything goes wrong
					{
						System.out.println("Invalid entry\n"); //Error message
					}
				}
				
				System.out.println("\n"); //Spacer to make output nicer
				
				try //Try/catch because otherwise Eclipse throws a tantrum 
				{
					digitalOutput2.setDutyCycle(1); //Set LED to the true state
				} 
				catch (PhidgetException e1) 
				{
					System.out.println("LED Error");
				}
			}
		});
		
		//On tag lost listener
		rfid0.addTagLostListener(new RFIDTagLostListener() 
		{
			public void onTagLost(RFIDTagLostEvent e) 
			{
				//Repeat found but replace the word found with lost
				System.out.println("Tag: " + e.getTag());
				System.out.println("Protocol: " + e.getProtocol().name());
				
				if (data.get(e.getTag()) != null)
				{
					System.out.println("Lost " + data.get(e.getTag()));
				}
				else
				{
					System.out.println("Lost unknown tag");
				}
				
				System.out.println("\n");
				
				try 
				{
					digitalOutput2.setDutyCycle(0); //Set LED to false state
				} 
				catch (PhidgetException e1) 
				{
					System.out.println("LED Error");
				}
			}
		});
		
		readFile(DATA_FILE); //Reads the file and builds the HashMap

		//Open Phidgets
		rfid0.open(1000);
		digitalOutput2.open(1000);

		//Wait until Enter has been pressed before exiting
		System.in.read();
		
		//Close Phidgets
		rfid0.close();
		digitalOutput2.close();
	}
}