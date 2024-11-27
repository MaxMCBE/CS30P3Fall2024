package RFID;

/*

Program: RFIDTest.java          Last Date of this Revision: November 27, 2024

Purpose: Reads RFID tags and returns their name from data.txt if the tag is logged
Very easy to modify to add a writer to add items to the database, or a third value for if the object is logged in or out, for example, using another colon to break up the string

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

import java.io.*;
import java.util.*;
import com.phidget22.*;

public class RFIDTest 
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
		
		data.clear();
		
		while ((line = in.readLine()) != null) //While the next line is NOT null
		{
			int colonIndex = line.indexOf(':'); //Find the semicolon (divides tag and name)
			String tag = line.substring(0, colonIndex); //Isolate the tag part
			String name = line.substring(colonIndex+1); //Isolate the name part
			
			data.put(tag, name); //Add the tag/name pair to the data HashMap
		}
		
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