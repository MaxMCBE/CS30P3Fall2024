package MetricConversion;

//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*

Program: MetricConversion.java          Last Date of this Revision: September 12, 2024

Purpose: Displays metric and imperial conversions

Author: Max MacPhee 
School: CHHS
Course: Computer Science 30
 
*/

public class MetricConversion 
{
	//Define GUI elements
	private JFrame frame;
	private JLabel instructionLabel;
	private JComboBox<String> selectionBox;
	private JLabel out;
	
	private String[] conversions = {
			"inches to centimeters", 
			"centimeters to inches", 
			"feet to meters", 
			"meters to feet",
			"gallons to liters",
			"liters to gallons",
			"pounds to kilograms",
			"kilograms to pounds"};

	//Main
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() //Create thread
		{
			public void run() //Run thread
			{
				try 
				{
					MetricConversion window = new MetricConversion(); //Create a GUI object
					window.frame.setVisible(true); //Set it to visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MetricConversion() //Constructor
	{
		initialize(); //Creates GUI
	}

	private void initialize() //Init function to create GUI
	{
		//Create frame
		frame = new JFrame("MetricConversion");
		frame.setBounds(0, 0, 300, 125);
		frame.setLocationRelativeTo(null); //Center on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //Create border
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); //Vertical layout
		
		//Instruction label
		instructionLabel = new JLabel("Select a conversion:");
		frame.getContentPane().add(instructionLabel);
		instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //Center it on the X
		
		//Selection box
		selectionBox = new JComboBox<>(conversions);
		selectionBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String in = (String) selectionBox.getSelectedItem();
				
				if (in == "inches to centimeters")
				{
					out.setText("1 inch = 2.54 centimeters");
				}
				else if (in == "centimeters to inches")
				{
					out.setText("1 centimeter = 0.39 inches");
				}
				else if (in == "feet to meters")
				{
					out.setText("1 foot = 0.30 meters");
				}
				else if (in == "meters to feet")
				{
					out.setText("1 meter = 3.28 feet");
				}
				else if (in == "gallons to liters")
				{
					out.setText("1 gallon = 4.55 liters");
				}
				else if (in == "liters to gallons")
				{
					out.setText("1 liter = 0.26 gallons");
				}
				else if (in == "pounds to kilograms")
				{
					out.setText("1 pound = 0.45 kilograms");
				}
				else if (in == "kilograms to pounds")
				{
					out.setText("1 kilogram = 2.20 pounds");
				}
			}
		});
		frame.getContentPane().add(selectionBox);
		
		//Output label
		out = new JLabel("1 inch = 2.54cm");
		frame.getContentPane().add(out);
		out.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
