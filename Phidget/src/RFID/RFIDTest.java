package RFID;

import java.io.*;
import java.util.*;
import com.phidget22.*;

public class RFIDTest 
{
	static HashMap<String, String> data = new HashMap<String, String>();
	final static File DATA_FILE = new File("src//RFID//data.txt");
	
	public static void main(String[] args) throws Exception 
	{
		RFID rfid0 = new RFID();
		DigitalOutput digitalOutput2 = new DigitalOutput();

		digitalOutput2.setChannel(2);

		rfid0.addTagListener(new RFIDTagListener() 
		{
			public void onTag(RFIDTagEvent e) 
			{
				System.out.println("Tag: " + e.getTag());
				System.out.println("Protocol: " + e.getProtocol().name());
				if (data.get(e.getTag()) != null)
				{
					System.out.println("Found " + data.get(e.getTag()));
				}
				else
				{
					System.out.println("Found unknown tag");
				}
				System.out.println("\n");
				try 
				{
					digitalOutput2.setDutyCycle(1);
				} 
				catch (PhidgetException e1) 
				{
					System.out.println("LED Error");
				}
			}
		});

		rfid0.addTagLostListener(new RFIDTagLostListener() 
		{
			public void onTagLost(RFIDTagLostEvent e) 
			{
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
					digitalOutput2.setDutyCycle(0);
				} 
				catch (PhidgetException e1) 
				{
					System.out.println("LED Error");
				}
			}
		});
		
		BufferedReader in = new BufferedReader(new FileReader(DATA_FILE));
		String line = "";
		
		while ((line = in.readLine()) != null)
		{
			int indexSemicolon = line.indexOf(':');
			String tag = line.substring(0, indexSemicolon);
			String name = line.substring(indexSemicolon+1);
			
			data.put(tag, name);
		}

		rfid0.open(1000);
		digitalOutput2.open(1000);

		//Wait until Enter has been pressed before exiting
		System.in.read();

		rfid0.close();
	}
}